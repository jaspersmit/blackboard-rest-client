package org.jbsmit.blackboardRestClient.agentsupport;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.MediaType;

public class RestCallBuilder<T> {
    private final RestCall<T> restCall = new RestCall<>();

    private static final Gson gson = new Gson();

    public static <T> RestCallBuilder<T> start(TypeToken<T> typeToken) {
        return new RestCallBuilder<>(typeToken);
    }

    public RestCallBuilder<T> url(String url) {
        restCall.setUrl(url);
        return this;
    }

    public RestCallBuilder<T> get() {
        return method(MethodType.GET);
    }

    public RestCallBuilder<T> post() {
        return method(MethodType.POST);
    }

    public RestCallBuilder<T> delete() {
        return method(MethodType.DELETE);
    }

    public RestCallBuilder<T> patch() {
        return method(MethodType.PATCH);
    }

    public RestCallBuilder<T> put() {
        return method(MethodType.PUT);
    }

    public RestCallBuilder<T> method(MethodType method) {
        restCall.setMethodType(method);
        return this;
    }

    public RestCallBuilder<T> param(String key, String value) {
		restCall.addParameter(key, value);
		return this;
	}

	public RestCallBuilder<T> pathParam(String key, String value) {
        restCall.addPathParameter(key, value);
        return this;
    }

    public RestCallBuilder<T> body(MediaType mediaType, String bodyString) {
        restCall.setContentType(mediaType);
        restCall.setBody(bodyString);
        return this;
    }

    public RestCallBuilder<T> body(Object object) {
        restCall.setContentType(MediaType.get("application/json"));
        restCall.setBody(gson.toJson(object));
        return this;
    }

    public RestCallBuilder<T> header(String key, String value) {
        restCall.addHeader(key, value);
        return this;
    }

    public RestCallBuilder<T> options(RestCallOption... options) {
        for(var option : options) {
            option.getRestCallDecorator().decorate(restCall);
        }
        return this;
    }

	public RestCall<T> build() {
		return restCall;
	}

    private RestCallBuilder(TypeToken<T> typeToken) {
        restCall.setReturnType(typeToken);
    }
}
