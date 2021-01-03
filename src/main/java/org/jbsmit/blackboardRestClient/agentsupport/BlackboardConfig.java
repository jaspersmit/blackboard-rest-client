package org.jbsmit.blackboardRestClient.agentsupport;

public class BlackboardConfig {
    private final String url;
    private final String secret;

    public BlackboardConfig(String url, String secret) {
        this.url = url;
        this.secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public String getSecret() {
        return secret;
    }
}
