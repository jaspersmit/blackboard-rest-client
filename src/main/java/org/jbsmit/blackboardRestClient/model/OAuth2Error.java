package org.jbsmit.blackboardRestClient.model;


public class OAuth2Error {
    /*
     * Error code indicating high level source of error
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | invalid_request | The request is missing a required parameter, includes an unsupported parameter value (other than grant type), repeats a parameter, includes multiple credentials, utilizes more than one mechanism for authenticating the client, or is otherwise malformed. |
     * | invalid_client | Client authentication failed (e.g., unknown client, no client authentication included, or unsupported authentication method).  The authorization server MAY return an HTTP 401 (Unauthorized) status code to indicate which HTTP authentication schemes are supported.  If the client attempted to authenticate via the 'Authorization' request header field, the authorization server MUST respond with an HTTP 401 (Unauthorized) status code and include the 'WWW-Authenticate' response header field matching the authentication scheme used by the client. |
     * | invalid_grant | The provided authorization grant (e.g., authorization code, resource owner credentials) or refresh token is invalid, expired, revoked, does not match the redirection URI used in the authorization request, or was issued to another client. |
     * | unauthorized_client | The authenticated client is not authorized to use this authorization grant type. |
     * | unsupported_grant_type | The authorization grant type is not supported by the authorization server. |
     * | invalid_scope | The requested scope is invalid, unknown, malformed, or exceeds the scope granted by the resource owner. |
     * | unsupported_response_type | The authorization server does not support obtaining an authorization code using this method. |
     * | server_error | The authorization server encountered an unexpected condition that prevented it from fulfilling the request. (This error code is needed because a 500 Internal Server Error HTTP status code cannot be returned to the client via a HTTP redirect.) |
     *
     */
    private Error error;

    /*
     * Optional text providing additional information about the error condition.
     */
    private String error_description;


    public enum Error {
        invalid_request,
        invalid_client,
        invalid_grant,
        unauthorized_client,
        unsupported_grant_type,
        invalid_scope,
        unsupported_response_type,
        server_error
    }

    public Error getError() {
        return error;
    }

    public OAuth2Error setError(Error error) {
        this.error = error;
        return this;
    }

    public String getError_description() {
        return error_description;
    }

    public OAuth2Error setError_description(String error_description) {
        this.error_description = error_description;
        return this;
    }
}

