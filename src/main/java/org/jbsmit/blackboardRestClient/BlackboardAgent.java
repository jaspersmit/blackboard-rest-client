package org.jbsmit.blackboardRestClient;

import com.google.common.base.Strings;
import com.google.gson.reflect.TypeToken;
import org.jbsmit.blackboardRestClient.agentsupport.*;
import okhttp3.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Performs RestCall's. This is class is bound to a particular instance of Blackboard.
 */
public class BlackboardAgent {
    private final BlackboardConfig blackboardConfig;
    private final TokenManager tokenManager = new TokenManager();
    private final JsonDeserializer jsonDeserializer = new JsonDeserializer();
    private final HttpClient httpClient;

    /**
     * Construct a new BlackboardAgent
     * @param blackboardConfig Provides the url to the Blackboard instance and the secret token.
     */
    public BlackboardAgent(BlackboardConfig blackboardConfig) {
        this.blackboardConfig = blackboardConfig;
        this.httpClient = new HttpClient(blackboardConfig.getUrl());
    }

    /**
     * Run a RestCall
     *
     * If the RestCall returns a paged result, it will fetch all pages.
     *
     * @param restCall The RestCall
     * @param <T> The response type of this rest call
     * @return The result of this rest call
     */
    public <T> T run(RestCall<T> restCall) {
        restCall.addHeader("Authorization", "Bearer " + getAccessToken());
        if (hasListResult(restCall)) {
            //noinspection unchecked
            return (T) runList((RestCall<List<?>>)restCall);
        } else {
            var bodyString = httpClient.run(restCall);
            return parseResult(bodyString, restCall);
        }
    }

    private <T> List<T> runList(RestCall<List<? extends T>> restCall) {
        var page = parsePagedResult(httpClient.run(restCall), restCall.getReturnType());
        var results = new ArrayList<T>(page.getResults());

        while (page.getPaging() != null
                && !Strings.isNullOrEmpty(page.getPaging().getNextPage())) {
            var nextPage = page.getPaging().getNextPage();
            restCall.setUrl(nextPage);
            page = parsePagedResult(httpClient.run(restCall), restCall.getReturnType());
            results.addAll(page.getResults());
        }

        return results;
    }

    private <T> T parseResult(String bodyString, RestCall<T> restCall) {
        return jsonDeserializer.fromJson(bodyString, restCall.getReturnType().getType());
    }

    private <T> boolean hasListResult(RestCall<T> restCall) {
        var typeToken = restCall.getReturnType();
        var type = typeToken.getType();
        var rawType = getRawType(type);
        return List.class.isAssignableFrom(rawType);
    }

    private Class<?> getRawType(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            var parameterizedType = (ParameterizedType) type;
            return (Class<?>) parameterizedType.getRawType();
        } else {
            throw new RuntimeException("Expected class or parameterized type");
        }
    }

    private <T> PagedResult<T> parsePagedResult(String bodyString, TypeToken<T> typeToken) {
        var type = TypeToken.getParameterized(PagedResult.class, typeToken.getType()).getType();
        return jsonDeserializer.fromJson(bodyString, type);
    }

    private String getAccessToken() {
        if (tokenManager.isTokenExpired()) {
            var token = renewAccessToken();
            var expirationInstant = Instant.now().plusSeconds(token.getExpires_in());
            tokenManager.updateToken(token.getAccess_token(), expirationInstant);
        }

        return tokenManager.getToken();
    }

    private Token renewAccessToken() {
        var restCall = RestCallBuilder
                .start(new TypeToken<Token>() {
                })
                .method(MethodType.POST)
                .url("/learn/api/public/v1/oauth2/token")
                .body(MediaType.get("application/x-www-form-urlencoded"), "grant_type=client_credentials")
                .header("Authorization", "Basic " + hashSecret())
                .build();

        var responseString = httpClient.run(restCall);
        return jsonDeserializer.fromJson(responseString, Token.class);
    }

    private String hashSecret() {
        return Base64.getEncoder().encodeToString(blackboardConfig.getSecret().getBytes());
    }
}
