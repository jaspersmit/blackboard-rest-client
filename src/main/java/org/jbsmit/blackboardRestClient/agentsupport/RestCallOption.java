package org.jbsmit.blackboardRestClient.agentsupport;


import java.time.Instant;

public class RestCallOption {
    private RestCallDecorator restCallDecorator;

    public RestCallDecorator getRestCallDecorator() {
        return restCallDecorator;
    }

    protected static <T extends RestCallOption> T parameter(String key, String value, T t) {
        return createOption(restCall -> restCall.addParameter(key, value), t);
    }

    protected static <T extends RestCallOption> T parameter(String key, boolean value, T t) {
        return createOption(restCall -> restCall.addParameter(key, value), t);
    }

    protected static <T extends RestCallOption> T parameter(String key, Instant value, T t) {
        return createOption(restCall -> restCall.addParameter(key, value), t);
    }

    protected static <T extends RestCallOption> T parameter(String key, int value, T t) {
        return createOption(restCall -> restCall.addParameter(key, value), t);
    }

    protected static <T extends RestCallOption> T parameter(String key, long value, T t) {
        return createOption(restCall -> restCall.addParameter(key, value), t);
    }

    protected static <T extends RestCallOption> T createOption(RestCallDecorator restCallDecorator, T t) {
        t.setRestCallDecorator(restCallDecorator);
        return t;
    }

    protected void setRestCallDecorator(RestCallDecorator restCallDecorator) {
        this.restCallDecorator = restCallDecorator;
    }
}