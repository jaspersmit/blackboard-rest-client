package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.SISLogEntry;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class SISLogsApi {
    /*
     * Get SIS Logs By Data Set Uid
     *
     *
     *
     * Returns a list of SIS Integration logs. Users with 'system.dataintegrations.log.VIEW' entitlement can view these logs. </p> </p> NOTE: If integration is processing the feed file then 423 (LOCKED) will be returned as response.
     *
     * **Since**: 3200.0.1
     */
    public static RestCall<List<SISLogEntry>> getSISLogsByDataSetUid(String id) {
        return RestCallBuilder
            .start(new TypeToken<List<SISLogEntry>>() {})
            .get()
            .url("/learn/api/public/v1/logs/sis/dataSets/{id}")
            .pathParam("id", id)
            .build();
    }
}
