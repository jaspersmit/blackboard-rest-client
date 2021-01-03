package org.jbsmit.blackboardRestClient.agentsupport;

import com.google.gson.reflect.TypeToken;
import okhttp3.MediaType;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class RestCall<T> {
    private TypeToken<T> returnType;
    private MethodType methodType = MethodType.GET;
    private String url;
    private MediaType contentType;
    private String body;
    private final Map<String, String> parameters = new HashMap<>();
    private final Map<String, String> pathParameters = new HashMap<>();
    private final Map<String, String> headers = new HashMap<>();

    public TypeToken<T> getReturnType() {
        return returnType;
    }

    public void setReturnType(TypeToken<T> returnType) {
        this.returnType = returnType;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MediaType getContentType() {
        return contentType;
    }

    public void setContentType(MediaType contentType) {
        this.contentType = contentType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void addParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    public void addParameter(String key, boolean value) {
        this.parameters.put(key, value + "");
    }

    public void addParameter(String key, int value) {
        this.parameters.put(key, value + "");
    }

    public void addParameter(String key, long value) {
        this.parameters.put(key, value + "");
    }

    public void addParameter(String key, Instant value) {
        this.parameters.put(key, DateTimeFormatter.ISO_DATE_TIME.format(value));
    }

    public void addPathParameter(String key, String value) {
        this.pathParameters.put(key, value);
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }
}
