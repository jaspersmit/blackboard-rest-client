package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.Session;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class SessionsApi {
    /*
     * Get Active Sessions
     *
     * List active user sessions in Learn.
     *
     * Users with the following entitlement can view others session:
     *
     * - system.user.sessions.VIEW
     * </p>
     *
     * Also with users with any of the following entitlements can view the users information using the expand param:
     *
     * - system.user.VIEW
     * - user.VIEW
     * </p>
     *
     * **Since**: 3800.4.0
     */
    public static RestCall<List<Session>> getActiveSessions(GetActiveSessionsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Session>>() {})
            .get()
            .url("/learn/api/public/v1/sessions")
            .options(options)
            .build();
    }

    public static class GetActiveSessionsOption extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>user</li></ul>
         */
        public static GetActiveSessionsOption expand(String expand) {
            return parameter("expand", expand, new GetActiveSessionsOption());
        }
    }
}
