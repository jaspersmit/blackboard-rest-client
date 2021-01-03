package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.GroupMembership;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class CourseGroupUsersApi {
    /*
     * Get Group Memberships
     *
     * Returns a list of group memberships objects for the specified group.
     *
     * Callers not enrolled in the group must have at least one of the following entitlements:
     *
     * - course.group.VIEW
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<List<GroupMembership>> getGroupMemberships(String groupId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<GroupMembership>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}/users")
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
     * **Since**: 3600.0.0
     */
    public static RestCall<GroupMembership> getGroupMembership(String courseId, String groupId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<GroupMembership>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}/users/{userId}")
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
     * - course.group-user.manage.EXECUTE
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<Void> deleteGroupMembership(String courseId, String groupId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Create Group Membership
     *
     * Creates a group membership in the specified group for the user. For Ultra if the user is already enrolled in another group of the same content item (of the group he wishes to enroll) previously to creating the new membership the previous one is deleted (Move operation). If the conditions for the join operation are not fullfilled the operation will be canceled and a 409 Conflict error returned with a message specifying the reason.
     *
     * Minimal entitlements required:
     *
     * - course.group-user.manage.EXECUTE
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<GroupMembership> createGroupMembership(String courseId, String groupId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<GroupMembership>() {})
            .put()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .pathParam("userId", userId)
            .build();
    }
}
