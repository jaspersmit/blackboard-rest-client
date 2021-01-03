package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import org.jbsmit.blackboardRestClient.model.ReviewStatus;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class ContentReviewApi {
    /*
     * Get Review Status
     *
     * Obtain the review status for a content item. This endpoint will only fetch the reviewStatus if the corresponding content was previously marked as reviewable.
     *
     * **Since**: 3700.16.0
     */
    public static RestCall<ReviewStatus> getReviewStatus(String courseId, String contentId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<ReviewStatus>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/users/{userId}/reviewStatus")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Update Review Status
     *
     * Update the review status for a content item. This endpoint will only update the reviewStatus if the corresponding content was previously marked as reviewable.
     *
     * **Since**: 3700.16.0
     */
    public static RestCall<ReviewStatus> updateReviewStatus(String courseId, String contentId, String userId, UpdateReviewStatusBody input) {
        return RestCallBuilder
            .start(new TypeToken<ReviewStatus>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/users/{userId}/reviewStatus")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("userId", userId)
            .body(input)
            .build();
    }

    public static class UpdateReviewStatusBody {
        /*
         * The current status of the content's 'reviewed' attribute.
         *
         * **Since**: 3700.16.0
         */
        private boolean reviewed;

        public static UpdateReviewStatusBody create() {
            return new UpdateReviewStatusBody();
        }

        public UpdateReviewStatusBody setReviewed(boolean reviewed) {
            this.reviewed = reviewed;
            return this;
        }
    }
}
