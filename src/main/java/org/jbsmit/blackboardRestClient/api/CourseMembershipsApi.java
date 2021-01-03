package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Availability;
import org.jbsmit.blackboardRestClient.model.CourseMembership;
import org.jbsmit.blackboardRestClient.model.UserMembership;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CourseMembershipsApi {
    /*
     * Get Course Memberships
     *
     * Returns a list of user memberships for the specified course or organization.
     *
     * Callers not enrolled in the course must have at least one of the following entitlements:
     *
     * - For courses: 'course.user.VIEW', 'system.user.course.enrollment.VIEW', or 'system.courseuserlist.VIEW'
     * - For organizations: 'course.user.VIEW', 'system.user.org.enrollment.VIEW', or 'system.orguserlist.VIEW'
     * Callers enrolled in the course will only be able to see memberships that are available and that have opted to be included in the course roster.
     *
     * For callers enrolled in the course as well as those with the 'course.user.VIEW' entitlement, system fields such as externalId and dataSourceId will not be visible.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<List<CourseMembership>> getCourseMemberships(String courseId, GetCourseMembershipsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseMembership>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/users")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetCourseMembershipsOption extends RestCallOption {
        /*
         * Search for memberships with a course role id that matches this value.
         *
         * **Since**: 3500.5.0
         */
        public static GetCourseMembershipsOption role(String role) {
            return parameter("role", role, new GetCourseMembershipsOption());
        }

        /*
         * Search for memberships with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3100.0.0
         */
        public static GetCourseMembershipsOption created(Instant created) {
            return parameter("created", created, new GetCourseMembershipsOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3100.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetCourseMembershipsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetCourseMembershipsOption());
        }

        /*
         * Search for memberships with a modified date relative to this value. 'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.9.0
         */
        public static GetCourseMembershipsOption modified(Instant modified) {
            return parameter("modified", modified, new GetCourseMembershipsOption());
        }

        /*
         * Used alongside the 'modified' search parameter. Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.9.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetCourseMembershipsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetCourseMembershipsOption());
        }

        /*
         * Search for memberships with this dataSourceId.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         *
         * **Since**: 3100.0.0
         */
        public static GetCourseMembershipsOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetCourseMembershipsOption());
        }

        /*
         * Search for memberships with a last accessed date relative to this value.  'lastAccessedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3300.9.0
         */
        public static GetCourseMembershipsOption lastAccessed(Instant lastAccessed) {
            return parameter("lastAccessed", lastAccessed, new GetCourseMembershipsOption());
        }

        /*
         * Used alongside the 'lastAccessed' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3300.9.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetCourseMembershipsOption lastAccessedCompare(String lastAccessedCompare) {
            return parameter("lastAccessedCompare", lastAccessedCompare, new GetCourseMembershipsOption());
        }

        /*
         * Search for users with availability.available properties that contain this value.
         *
         * **Since**: 3100.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Yes |  |
         * | No |  |
         * | Disabled |   **Since**: 3100.0.0 |
         *
         */
        public static GetCourseMembershipsOption availability_available(String availability_available) {
            return parameter("availability.available", availability_available, new GetCourseMembershipsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "created(desc)" Supported fields are:
         *
         * - created
         * - lastAccessed (Since 3300.9.0)
         *
         * **Since**: 3100.0.0
         */
        public static GetCourseMembershipsOption sort(String sort) {
            return parameter("sort", sort, new GetCourseMembershipsOption());
        }

        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>user</li></ul>
         */
        public static GetCourseMembershipsOption expand(String expand) {
            return parameter("expand", expand, new GetCourseMembershipsOption());
        }
    }

    /*
     * Get Membership
     *
     * Loads a user membership in the specified course.
     *
     * Entitlement and field visibility rules are the same as those when loading the memberships collection.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<CourseMembership> getMembership(String courseId, String userId, GetMembershipOption... options) {
        return RestCallBuilder
            .start(new TypeToken<CourseMembership>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .options(options)
            .build();
    }

    public static class GetMembershipOption extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>user</li></ul>
         */
        public static GetMembershipOption expand(String expand) {
            return parameter("expand", expand, new GetMembershipOption());
        }
    }

    /*
     * Delete Membership
     *
     * Deletes a user membership from the specified course.
     *
     * Required entitlements:
     *
     * - For courses: 'system.enrollment.DELETE' or 'course.user.DELETE'
     * - For organizations: 'system.enrollment.DELETE' or 'org.enrollment.DELETE'
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Void> deleteMembership(String courseId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Create Membership
     *
     * Creates a user membership in the specified course.
     *
     * Minimal entitlements required:
     *
     * - For courses: 'course.user-enroll.EXECUTE', 'system.enrollment.CREATE'
     * - For organizations: 'course.user-enroll.EXECUTE', 'org.enrollment.CREATE'
     * - For courses or organizations that have enabled self enrollment: 'system.generic.VIEW'
     *
     * By default courseRoleId is Student and availability.available is Yes.  Providing different values for these fields requires extra entitlements:
     *
     * - For courses: 'course.user-role.MODIFY' or 'course.user.MODIFY'
     * - For organizations: 'course.user-role.MODIFY' or 'org.user.MODIFY'
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<CourseMembership> createMembership(String courseId, String userId, CreateMembershipBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseMembership>() {})
            .put()
            .url("/learn/api/public/v1/courses/{courseId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .body(input)
            .build();
    }

    public static class CreateMembershipBody {
        /*
         * The primary ID of the child, cross-listed course, in which the user is directly enrolled. </p> This field is read only in Learn versions 3000.11.0 through 3400.0.0. As of 3400.1.0, this field is mutable.  </p> If this membership's course is a parent course in a cross-listed set, the childCourseId can be updated to move the membership enrollment between child courses and the parent course in  the set.  Patching the childCourseId to "null" will move the membership to the parent course.
         *
         * **Since**: 3000.11.0
         */
        private String childCourseId;

        /*
         * The ID of the data source associated with this course.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         */
        private String dataSourceId;

        /*
         * Settings controlling availability of the course membership.
         */
        private Availability availability;

        /*
         * The user's role in the course.
         *
         * These roles are also valid for an organization, although they are named differently in the UI.
         *
         * Custom course roles may also be referenced by their IDs.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Instructor | Has access to all areas in the Control Panel. This role is generally given to those developing, teaching, or facilitating the class. Instructors may access a course that is unavailable to students. This role is customizable and may have different capabilities from what is documented here. |
         * | BbFacilitator | The facilitator is an instructor like role. Facilitators are restricted versions of an instructor, in that they are able to deliver course instruction and administer all aspects of a pre-constructed course, but are not allowed to modify or alter the course. This role is customizable and may have different capabilities from what is documented here. |
         * | TeachingAssistant | The teaching assistant role is that of a co-teacher. Teaching assistants are able to administer all areas of a course. Their only limitations are those imposed by the instructor or Blackboard administrator at your school. This role is customizable and may have different capabilities from what is documented here. |
         * | CourseBuilder | Manages the course without having access to student grades. This role is customizable and may have different capabilities from what is documented here. |
         * | Grader | Assists the instructor in the creation, management, delivery, and grading of items. This role is customizable and may have different capabilities from what is documented here. |
         * | Student |  |
         * | Guest | Has no access to the Control Panel. Areas within the course are made available to guests, but typically they can only view course materials; they do not have access to tests or assessments, and do not have permission to post on discussion boards. This role's behavior is immutable. |
         *
         */
        private CourseRoleId courseRoleId;

        public static CreateMembershipBody create() {
            return new CreateMembershipBody();
        }

        public enum CourseRoleId {
            Instructor,
            BbFacilitator,
            TeachingAssistant,
            CourseBuilder,
            Grader,
            Student,
            Guest
        }

        public CreateMembershipBody setChildCourseId(String childCourseId) {
            this.childCourseId = childCourseId;
            return this;
        }

        public CreateMembershipBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public CreateMembershipBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateMembershipBody setCourseRoleId(CourseRoleId courseRoleId) {
            this.courseRoleId = courseRoleId;
            return this;
        }
    }

    /*
     * Update Membership
     *
     * Updates a user membership in the specified course.
     *
     *  | Field                  | Entitlements Required                                                           |
     *  |------------------------|---------------------------------------------------------------------------------|
     *  | dataSourceId           | 'course.user.MODIFY' or 'org.user.MODIFY'                                       |
     *  | childCourseId          | 'course.user.MODIFY' or 'org.user.MODIFY'                                       |
     *  | courseRoleId           | 'course.user.MODIFY', 'org.user.MODIFY', or 'course.user-role.MODIFY'           |
     *  | availability.available | 'course.user.MODIFY', 'org.user.MODIFY', or 'course.course-availability.MODIFY' |
     *
     *
     * In addition, callers must have standard view entitlements to receive a response.  Without view entitlements the operation will be performed but an empty result object will be returned.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<CourseMembership> updateMembership(String courseId, String userId, UpdateMembershipBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseMembership>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .body(input)
            .build();
    }

    public static class UpdateMembershipBody {
        /*
         * The primary ID of the child, cross-listed course, in which the user is directly enrolled. </p> This field is read only in Learn versions 3000.11.0 through 3400.0.0. As of 3400.1.0, this field is mutable.  </p> If this membership's course is a parent course in a cross-listed set, the childCourseId can be updated to move the membership enrollment between child courses and the parent course in  the set.  Patching the childCourseId to "null" will move the membership to the parent course.
         *
         * **Since**: 3000.11.0
         */
        private String childCourseId;

        /*
         * The ID of the data source associated with this course.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         */
        private String dataSourceId;

        /*
         * Settings controlling availability of the course membership.
         */
        private Availability availability;

        /*
         * The user's role in the course.
         *
         * These roles are also valid for an organization, although they are named differently in the UI.
         *
         * Custom course roles may also be referenced by their IDs.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Instructor | Has access to all areas in the Control Panel. This role is generally given to those developing, teaching, or facilitating the class. Instructors may access a course that is unavailable to students. This role is customizable and may have different capabilities from what is documented here. |
         * | BbFacilitator | The facilitator is an instructor like role. Facilitators are restricted versions of an instructor, in that they are able to deliver course instruction and administer all aspects of a pre-constructed course, but are not allowed to modify or alter the course. This role is customizable and may have different capabilities from what is documented here. |
         * | TeachingAssistant | The teaching assistant role is that of a co-teacher. Teaching assistants are able to administer all areas of a course. Their only limitations are those imposed by the instructor or Blackboard administrator at your school. This role is customizable and may have different capabilities from what is documented here. |
         * | CourseBuilder | Manages the course without having access to student grades. This role is customizable and may have different capabilities from what is documented here. |
         * | Grader | Assists the instructor in the creation, management, delivery, and grading of items. This role is customizable and may have different capabilities from what is documented here. |
         * | Student |  |
         * | Guest | Has no access to the Control Panel. Areas within the course are made available to guests, but typically they can only view course materials; they do not have access to tests or assessments, and do not have permission to post on discussion boards. This role's behavior is immutable. |
         *
         */
        private CourseRoleId courseRoleId;

        public static UpdateMembershipBody create() {
            return new UpdateMembershipBody();
        }

        public enum CourseRoleId {
            Instructor,
            BbFacilitator,
            TeachingAssistant,
            CourseBuilder,
            Grader,
            Student,
            Guest
        }

        public UpdateMembershipBody setChildCourseId(String childCourseId) {
            this.childCourseId = childCourseId;
            return this;
        }

        public UpdateMembershipBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public UpdateMembershipBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateMembershipBody setCourseRoleId(CourseRoleId courseRoleId) {
            this.courseRoleId = courseRoleId;
            return this;
        }
    }

    /*
     * Get User Memberships
     *
     * Returns a list of course and organization memberships for the specified user.
     *
     * Users can always view their own memberships.  Callers viewing the memberships of another user require at least one of the following entitlements:
     *
     * - 'system.user.course.enrollment.VIEW' allows callers to see course memberships
     * - 'system.user.org.enrollment.VIEW' allows callers to see organization memberships
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<List<UserMembership>> getUserMemberships(String userId, GetUserMembershipsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<UserMembership>>() {})
            .get()
            .url("/learn/api/public/v1/users/{userId}/courses")
            .pathParam("userId", userId)
            .options(options)
            .build();
    }

    public static class GetUserMembershipsOption extends RestCallOption {
        /*
         * Search for memberships with a course role id that matches this value.
         *
         * **Since**: 3500.5.0
         */
        public static GetUserMembershipsOption role(String role) {
            return parameter("role", role, new GetUserMembershipsOption());
        }

        /*
         * Search for memberships with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3100.0.0
         */
        public static GetUserMembershipsOption created(Instant created) {
            return parameter("created", created, new GetUserMembershipsOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3100.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetUserMembershipsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetUserMembershipsOption());
        }

        /*
         * Search for memberships with a modified date relative to this value. 'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.9.0
         */
        public static GetUserMembershipsOption modified(Instant modified) {
            return parameter("modified", modified, new GetUserMembershipsOption());
        }

        /*
         * Used alongside the 'modified' search parameter. Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.9.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetUserMembershipsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetUserMembershipsOption());
        }

        /*
         * Search for memberships with this dataSourceId.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         *
         * **Since**: 3100.0.0
         */
        public static GetUserMembershipsOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetUserMembershipsOption());
        }

        /*
         * Search for memberships with a last accessed date relative to this value.  'lastAccessedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3300.9.0
         */
        public static GetUserMembershipsOption lastAccessed(Instant lastAccessed) {
            return parameter("lastAccessed", lastAccessed, new GetUserMembershipsOption());
        }

        /*
         * Used alongside the 'lastAccessed' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3300.9.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetUserMembershipsOption lastAccessedCompare(String lastAccessedCompare) {
            return parameter("lastAccessedCompare", lastAccessedCompare, new GetUserMembershipsOption());
        }

        /*
         * Search for users with availability.available properties that contain this value.
         *
         * **Since**: 3100.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Yes |  |
         * | No |  |
         * | Disabled |   **Since**: 3100.0.0 |
         *
         */
        public static GetUserMembershipsOption availability_available(String availability_available) {
            return parameter("availability.available", availability_available, new GetUserMembershipsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "created(desc)" Supported fields are:
         *
         * - created
         * - lastAccessed (Since 3300.9.0)
         *
         * **Since**: 3100.0.0
         */
        public static GetUserMembershipsOption sort(String sort) {
            return parameter("sort", sort, new GetUserMembershipsOption());
        }

        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>course</li></ul>
         */
        public static GetUserMembershipsOption expand(String expand) {
            return parameter("expand", expand, new GetUserMembershipsOption());
        }
    }
}
