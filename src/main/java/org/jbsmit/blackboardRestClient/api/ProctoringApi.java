package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.ProctoringService;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class ProctoringApi {
    /*
     * Get Proctoring Services
     *
     * Returns a list of proctoring services Supports the standard paging query parameters, with a maximum page size of 1000. No entitlement check is performed as this data is not restricted. Any secure fields such as keys/secrets are not included in the results.
     *
     * **Since**: 3500.6.0
     */
    public static RestCall<List<ProctoringService>> getProctoringServices() {
        return RestCallBuilder
            .start(new TypeToken<List<ProctoringService>>() {})
            .get()
            .url("/learn/api/public/v1/proctoring/services")
            .build();
    }

    /*
     * Get Proctoring Service
     *
     * Returns the proctoring service with the specified Id No entitlement check is performed as this data is not restricted. Any secure fields such as keys/secrets are not included in the results.
     *
     * **Since**: 3500.6.0
     */
    public static RestCall<ProctoringService> getProctoringService(String proctoringServiceId) {
        return RestCallBuilder
            .start(new TypeToken<ProctoringService>() {})
            .get()
            .url("/learn/api/public/v1/proctoring/services/{proctoringServiceId}")
            .pathParam("proctoringServiceId", proctoringServiceId)
            .build();
    }
}
