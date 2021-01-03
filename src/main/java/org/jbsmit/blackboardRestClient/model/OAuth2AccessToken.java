package org.jbsmit.blackboardRestClient.model;


public class OAuth2AccessToken {
    /*
     * The access token issued by the authorization server.
     */
    private String access_token;

    /*
     * The type of the token issued.  Value is case insensitive.
     */
    private String token_type;

    /*
     * The lifetime in seconds of the access token.
     */
    private int expires_in;

    /*
     * The refresh token issued by the authorization server during OAuth2 authorization code workflow if 'offline' scope was granted.
     */
    private String refresh_token;

    /*
     * The scope of the access granted by this token.
     */
    private String scope;

    /*
     * The ID of the user granted access via token
     */
    private String user_id;


    public String getAccess_token() {
        return access_token;
    }

    public OAuth2AccessToken setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getToken_type() {
        return token_type;
    }

    public OAuth2AccessToken setToken_type(String token_type) {
        this.token_type = token_type;
        return this;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public OAuth2AccessToken setExpires_in(int expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public OAuth2AccessToken setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public OAuth2AccessToken setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getUser_id() {
        return user_id;
    }

    public OAuth2AccessToken setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }
}

