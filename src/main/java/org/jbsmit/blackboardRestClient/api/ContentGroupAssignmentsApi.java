package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.ContentGroup;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class ContentGroupAssignmentsApi {
    /*
     * Get Content Groups
     *
     * Returns a list of content group associations for the specified content.
     *
     * Callers not enrolled in the course must have at least one of the following entitlements:
     *
     * - course.content.designer.VIEW  Callers enrolled in the course will only be able to see Groups that are available to them.
     *
     * **Since**: 3100.5.0
     */
    public static RestCall<List<ContentGroup>> getContentGroups(String courseId, String contentId) {
        return RestCallBuilder
            .start(new TypeToken<List<ContentGroup>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/groups")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .build();
    }

    /*
     * Get Content Group
     *
     * Returns a content group association for the specified content and group.
     *
     * Callers not enrolled in the course must have at least one of the following entitlements:
     *
     * - course.content.designer.VIEW  Callers enrolled in the course will only be able to see Groups that are available to them.
     *
     * **Since**: 3100.5.0
     */
    public static RestCall<ContentGroup> getContentGroup(String courseId, String contentId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<ContentGroup>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("groupId", groupId)
            .build();
    }

    /*
     * Delete Content Group
     *
     * Deletes a content group association.
     *
     * Required entitlements:
     *
     * - course.content.DELETE  If the content is going to be accessed in Ultra, and the group being removed is part of a group set, then the caller should ensure that all groups within that set are removed from the content.
     *
     * **Since**: 3100.5.0
     */
    public static RestCall<Void> deleteContentGroup(String courseId, String contentId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("groupId", groupId)
            .build();
    }

    /*
     * Create Content Group
     *
     * Creates a content group association.
     *
     * Callers not enrolled in the course must have at least one of the following entitlements:
     *
     * - course.content.MODIFY  If the content is going to be accessed in Ultra, the following rules should be followed by the caller:
     *
     * - If the group is part of a set, all groups with the set should be associated with the content. - The content should be associated exclusively to individual groups or groups within a set, but not both.
     *
     * **Since**: 3100.5.0
     */
    public static RestCall<ContentGroup> createContentGroup(String courseId, String contentId, String groupId, CreateContentGroupBody input) {
        return RestCallBuilder
            .start(new TypeToken<ContentGroup>() {})
            .put()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("groupId", groupId)
            .body(input)
            .build();
    }

    public static class CreateContentGroupBody {
        /*
         * The ID of the associated content.
         */
        private String contentId;

        /*
         * The ID of the association of content and group.
         */
        private String groupId;

        public static CreateContentGroupBody create() {
            return new CreateContentGroupBody();
        }

        public CreateContentGroupBody setContentId(String contentId) {
            this.contentId = contentId;
            return this;
        }

        public CreateContentGroupBody setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }
    }
}
