package org.jbsmit.blackboardRestClient.agentsupport;

import java.time.Instant;

public class TokenManager {
    private String token = "";
    private Instant expirationInstant = Instant.ofEpochMilli(0);

    public boolean isTokenExpired() {
        return Instant.now().isAfter(expirationInstant);
    }

    public String getToken() {
        return token;
    }

    public void updateToken(String token, Instant expirationInstant) {
        this.token = token;
        this.expirationInstant = expirationInstant;
    }
}
