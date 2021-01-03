package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.AggregateReviewStatus;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class PerformanceDashboardApi {
    /*
     * Get Review Status By Course Id
     *
     * List the content review statuses for all the users enrolled in a course. Users calling this endpoint must have the following entitlement: this entitlement check.
     *
     * - course.performance.dashboard.VIEW
     *
     * **Since**: 3700.15.0
     */
    public static RestCall<List<AggregateReviewStatus>> getReviewStatusByCourseId(String courseId, GetReviewStatusByCourseIdOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<AggregateReviewStatus>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/performance/contentReviewStatus")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetReviewStatusByCourseIdOption extends RestCallOption {
        /*
         * Optional search criteria to filter by user id.
         *
         * **Since**: 3700.15.0
         */
        public static GetReviewStatusByCourseIdOption userId(String userId) {
            return parameter("userId", userId, new GetReviewStatusByCourseIdOption());
        }
    }
}
