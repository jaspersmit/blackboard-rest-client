package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import org.jbsmit.blackboardRestClient.model.PrivacyPolicy;
import org.jbsmit.blackboardRestClient.model.SystemTask;
import org.jbsmit.blackboardRestClient.model.VersionInfo;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class SystemApi {
    /*
     * Get Policies
     *
     * Returns the links to the Blackboard and Institution privacy policies
     *
     * **Since**: 3400.5.0
     */
    public static RestCall<PrivacyPolicy> getPolicies(GetPoliciesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<PrivacyPolicy>() {})
            .get()
            .url("/learn/api/public/v1/system/policies/privacy")
            .options(options)
            .build();
    }

    public static class GetPoliciesOption extends RestCallOption {
        /*
         * the locale, otherwise it defaults to en_US
         */
        public static GetPoliciesOption locale(String locale) {
            return parameter("locale", locale, new GetPoliciesOption());
        }
    }

    /*
     * Get System Task
     *
     * Get the background task by the given task Id.
     *
     * **Since**: 3800.1.0
     */
    public static RestCall<SystemTask> getSystemTask(String taskId) {
        return RestCallBuilder
            .start(new TypeToken<SystemTask>() {})
            .get()
            .url("/learn/api/public/v1/system/tasks/{taskId}")
            .pathParam("taskId", taskId)
            .build();
    }

    /*
     * Get Version
     *
     * Gets the current Learn server version.
     *
     * **Since**: 3000.3.0
     */
    public static RestCall<VersionInfo> getVersion() {
        return RestCallBuilder
            .start(new TypeToken<VersionInfo>() {})
            .get()
            .url("/learn/api/public/v1/system/version")
            .build();
    }
}
