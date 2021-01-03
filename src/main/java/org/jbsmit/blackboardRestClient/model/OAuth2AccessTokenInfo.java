package org.jbsmit.blackboardRestClient.model;


public class OAuth2AccessTokenInfo {
    /*
     * The ID of the registered third party application.
     */
    private String application_id;

    /*
     * The scope of the access granted by this token.
     */
    private String scope;


    public String getApplication_id() {
        return application_id;
    }

    public OAuth2AccessTokenInfo setApplication_id(String application_id) {
        this.application_id = application_id;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public OAuth2AccessTokenInfo setScope(String scope) {
        this.scope = scope;
        return this;
    }
}

