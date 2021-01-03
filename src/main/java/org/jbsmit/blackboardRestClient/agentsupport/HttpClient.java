package org.jbsmit.blackboardRestClient.agentsupport;

import okhttp3.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Set;

public class HttpClient {
    private final String blackboardUrl;
    private final OkHttpClient httpClient;

    public HttpClient(String blackboardUrl) {
        this.blackboardUrl = blackboardUrl;
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(30))
                .readTimeout(Duration.ofMinutes(2))
                .writeTimeout(Duration.ofMinutes(2))
                .callTimeout(Duration.ofMinutes(5))
                .build();
    }

    public String run(RestCall<?> restCall) {
        var endPoint = restCall.getUrl();
        for (var entry : restCall.getPathParameters().entrySet()) {
            endPoint = endPoint.replace("{" + entry.getKey() + "}", entry.getValue());
        }

        var httpUrl = Objects.requireNonNull(HttpUrl.parse(blackboardUrl + endPoint));
        var urlBuilder = httpUrl.newBuilder();
        for (var entry : restCall.getParameters().entrySet()) {
            urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }

        var requestBuilder = (new Request.Builder())
                .get()
                .url(urlBuilder.build());

        for (var header : restCall.getHeaders().entrySet()) {
            requestBuilder.header(header.getKey(), header.getValue());
        }

        var requestBody = (RequestBody)null;
        if(restCall.getBody() != null) {
            requestBody = RequestBody.create(restCall.getContentType(), restCall.getBody());
        }
        requestBuilder.method(restCall.getMethodType().name(), requestBody);

        var call = httpClient.newCall(requestBuilder.build());
        try (var response = call.execute()) {
            var body = Objects.requireNonNull(response.body());
            if (response.code() == 404) {
                throw new UnsupportedOperationException(String.format("'%s' not found \n\n%s",
                        restCall.getUrl(),
                        body.string()));
            }

            var validCodes = Set.of(200, 201, 204);
            if (!validCodes.contains(response.code())) {
                System.out.println("Unexpected response code " + response.code());
                throw new RuntimeException(body.string());
            }

            return Objects.requireNonNull(body).string();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
