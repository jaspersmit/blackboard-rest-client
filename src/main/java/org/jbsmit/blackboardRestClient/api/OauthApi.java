package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import org.jbsmit.blackboardRestClient.model.OAuth2AccessToken;
import org.jbsmit.blackboardRestClient.model.OAuth2AccessTokenInfo;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class OauthApi {
    /*
     * Authorization Code
     *
     * Requests an OAuth 2 authorization code. Use of PKCE standard is optional, but highly recommended.
     *
     * **Since**: 3200.7.0
     */
    public static RestCall<Void> authorizationCode(AuthorizationCodeOption... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .get()
            .url("/learn/api/public/v1/oauth2/authorizationcode")
            .options(options)
            .build();
    }

    public static class AuthorizationCodeOption extends RestCallOption {
        /*
         * A code challenge to verify credentials along with the granted authorization code. It is used with the PKCE standard.
         *
         * **Since**: 3700.4.0
         */
        public static AuthorizationCodeOption code_challenge(String code_challenge) {
            return parameter("code_challenge", code_challenge, new AuthorizationCodeOption());
        }

        /*
         * This is the method used to verify the code challenge using the PKCE standard. Blackboard only supports s256 as the code challenge method.
         *
         * **Since**: 3700.4.0
         */
        public static AuthorizationCodeOption code_challenge_method(String code_challenge_method) {
            return parameter("code_challenge_method", code_challenge_method, new AuthorizationCodeOption());
        }
    }

    /*
     * Request Token
     *
     * Requests an OAuth 2 access token.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<OAuth2AccessToken> requestToken(RequestTokenOption... options) {
        return RestCallBuilder
            .start(new TypeToken<OAuth2AccessToken>() {})
            .post()
            .url("/learn/api/public/v1/oauth2/token")
            .options(options)
            .build();
    }

    public static class RequestTokenOption extends RestCallOption {
        /*
         * The redirectUri to send the end user to once an access token response is made in Oauth2 Authorization Code Workflow
         *
         * **Since**: 3200.7.0
         */
        public static RequestTokenOption redirect_uri(String redirect_uri) {
            return parameter("redirect_uri", redirect_uri, new RequestTokenOption());
        }

        /*
         * The refresh token granted for use by an application in Oauth2 Refresh Token Workflow
         *
         * **Since**: 3200.7.0
         */
        public static RequestTokenOption refresh_token(String refresh_token) {
            return parameter("refresh_token", refresh_token, new RequestTokenOption());
        }

        /*
         * The code_verifier to be passed along with authorization code if PKCE standard was used to grant the authorization code.
         *
         * **Since**: 3700.4.0
         */
        public static RequestTokenOption code_verifier(String code_verifier) {
            return parameter("code_verifier", code_verifier, new RequestTokenOption());
        }
    }

    /*
     * Get Token Info
     *
     * Requests an OAuth 2 access token info.
     *
     * **Since**: 3700.6.0
     */
    public static RestCall<OAuth2AccessTokenInfo> getTokenInfo() {
        return RestCallBuilder
            .start(new TypeToken<OAuth2AccessTokenInfo>() {})
            .get()
            .url("/learn/api/public/v1/oauth2/tokeninfo")
            .build();
    }
}
