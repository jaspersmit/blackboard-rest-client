package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.GroupMembership;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class Deprecated_CourseGroupUsersApi {
    /*
     * Get Group Memberships
     *
     * Returns a list of group memberships objects for the specified group.
     *
     * Callers not enrolled in the group must have at least one of the following entitlements:
     *
     * - course.group.VIEW
     *
     * **Since**: 3100.6.0
     *
     * **Deprecated**: since 3600.0.0; use the v2 end-point instead
     */
    public static RestCall<List<GroupMembership>> getGroupMemberships(String groupId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<GroupMembership>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}/users")
            .pathParam("groupId", groupId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Get Group Membership
     *
     * Loads a group membership in the specified group.
     *
     * Callers not enrolled in the group must have at least one of the following entitlements:
     *
     * - course.group.VIEW
     *
     * **Since**: 3100.6.0
     *
     * **Deprecated**: since 3600.0.0; use the v2 end-point instead
     */
    public static RestCall<GroupMembership> getGroupMembership(String courseId, String groupId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<GroupMembership>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Delete Group Membership
     *
     * Deletes a group from the specified course.
     *
     * Required entitlements:
     *
     * - course.group.MODIFY
     *
     * **Since**: 3100.6.0
     *
     * **Deprecated**: since 3600.0.0; use the v2 end-point instead
     */
    public static RestCall<Void> deleteGroupMembership(String courseId, String groupId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Create Group Membership
     *
     * Creates a group membership in the specified group.
     *
     * Minimal entitlements required:
     *
     * - course.group.MODIFY
     *
     * **Since**: 3100.6.0
     *
     * **Deprecated**: since 3600.0.0; use the v2 end-point instead
     */
    public static RestCall<GroupMembership> createGroupMembership(String courseId, String groupId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<GroupMembership>() {})
            .put()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .pathParam("userId", userId)
            .build();
    }
}
