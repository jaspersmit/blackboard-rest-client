package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.GroupV2;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CourseGroupsApi {
    /*
     * Get Groups
     *
     * Returns a list of all top-level groups in the specified course.
     *
     * Callers with the following entitlement can view all groups in the course:
     *
     * - course.groups.VIEW
     * Callers enrolled in course can view all groups they're enrolled in, and all self-enrollment groups
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<List<GroupV2>> getGroups(String courseId, GetGroupsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GroupV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetGroupsOption extends RestCallOption {
        /*
         * Search for groups with created date relative to this value. 'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.8.0
         */
        public static GetGroupsOption created(Instant created) {
            return parameter("created", created, new GetGroupsOption());
        }

        /*
         * Used alongside the 'created' search parameter.
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetGroupsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetGroupsOption());
        }

        /*
         * Search for groups with modified date relative to this value. 'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.8.0
         */
        public static GetGroupsOption modified(Instant modified) {
            return parameter("modified", modified, new GetGroupsOption());
        }

        /*
         * Used alongside the 'modified' search parameter.
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetGroupsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetGroupsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name(desc)" Supported fields are:
         *
         * - name
         * - externalId
         *
         * **Since**: 3100.4.0
         */
        public static GetGroupsOption sort(String sort) {
            return parameter("sort", sort, new GetGroupsOption());
        }
    }

    /*
     * Create Group
     *
     * Creates a group in the specified course.
     *
     * Callers must have the following entitlement:
     *
     * - 'course.groups.CREATE'
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> createGroup(String courseId, CreateGroupBody input) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .post()
            .url("/learn/api/public/v2/courses/{courseId}/groups")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateGroupBody {
        /*
         * An externally-defined unique ID for the group. Defaults to a random UUID if not provided during create.
         */
        private String externalId;

        /*
         * The title of the group.
         */
        private String name;

        /*
         * The description of the group. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the group to students.
         */
        private Availability availability;

        /*
         * Settings controlling enrollment of the group to students.
         */
        private Enrollment enrollment;

        public static CreateGroupBody create() {
            return new CreateGroupBody();
        }

        public static class Availability {
            /*
             * Whether the Group is currently available to students.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the group. |
             * | No | Students may not access the group. |
             * | SignupOnly | Students may only signup and see the group listed, not yet access it. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                SignupOnly
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Enrollment {
            /*
             * Whether the Group allows self enrollment or only enrolled by instructor. This can only be set on creation.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | InstructorOnly | Students are added to the Group by the instructor |
             * | SelfEnrollment | Students are added to the Group by self enrollment |
             *
             */
            private Type type;

            /*
             * The maximum allowed enrollment size for self enrolled groups.
             */
            private int limit;

            /*
             * Settings controlling signup to the group for students. Only applicable if Enrollment.Type allows self enrollment.
             */
            private SignupSheet signupSheet;

            public static Enrollment create() {
                return new Enrollment();
            }

            public static class SignupSheet {
                /*
                 * The name of the signup sheet
                 */
                private String name;

                /*
                 * The description of the signup sheet This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
                 */
                private String description;

                /*
                 * A boolean indicating whether or not members can be seen by others prior to signing up.
                 */
                private boolean showMembers;

                public static SignupSheet create() {
                    return new SignupSheet();
                }

                public SignupSheet setName(String name) {
                    this.name = name;
                    return this;
                }

                public SignupSheet setDescription(String description) {
                    this.description = description;
                    return this;
                }

                public SignupSheet setShowMembers(boolean showMembers) {
                    this.showMembers = showMembers;
                    return this;
                }
            }

            public enum Type {
                InstructorOnly,
                SelfEnrollment
            }

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setLimit(int limit) {
                this.limit = limit;
                return this;
            }

            public Enrollment setSignupSheet(SignupSheet signupSheet) {
                this.signupSheet = signupSheet;
                return this;
            }
        }

        public CreateGroupBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateGroupBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreateGroupBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGroupBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateGroupBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }
    }

    /*
     * Get Group Sets
     *
     * Returns a list of all groupsets
     *
     * Callers not enrolled in the course must have the following entitlement:
     *
     * - course.groups.VIEW
     * - course.groups.admin.VIEW
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<List<GroupV2>> getGroupSets(String courseId, GetGroupSetsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GroupV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetGroupSetsOption extends RestCallOption {
        /*
         * Search for groups with created date relative to this value. 'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.8.0
         */
        public static GetGroupSetsOption created(Instant created) {
            return parameter("created", created, new GetGroupSetsOption());
        }

        /*
         * Used alongside the 'created' search parameter.
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetGroupSetsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetGroupSetsOption());
        }

        /*
         * Search for groups with modified date relative to this value. 'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.8.0
         */
        public static GetGroupSetsOption modified(Instant modified) {
            return parameter("modified", modified, new GetGroupSetsOption());
        }

        /*
         * Used alongside the 'modified' search parameter.
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetGroupSetsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetGroupSetsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name(desc)" Supported fields are:
         *
         * - name
         * - externalId
         *
         * **Since**: 3100.4.0
         */
        public static GetGroupSetsOption sort(String sort) {
            return parameter("sort", sort, new GetGroupSetsOption());
        }
    }

    /*
     * Create Group Set
     *
     * Creates a groupset in the specified course.
     *
     * Callers must have the following entitlement:
     *
     * - 'course.groups.CREATE'
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> createGroupSet(String courseId, CreateGroupSetBody input) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .post()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateGroupSetBody {
        /*
         * An externally-defined unique ID for the group. Defaults to a random UUID if not provided during create.
         */
        private String externalId;

        /*
         * The title of the group.
         */
        private String name;

        /*
         * The description of the group. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the group to students.
         */
        private Availability availability;

        /*
         * Settings controlling enrollment of the group to students.
         */
        private Enrollment enrollment;

        public static CreateGroupSetBody create() {
            return new CreateGroupSetBody();
        }

        public static class Availability {
            /*
             * Whether the Group is currently available to students.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the group. |
             * | No | Students may not access the group. |
             * | SignupOnly | Students may only signup and see the group listed, not yet access it. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                SignupOnly
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Enrollment {
            /*
             * Whether the Group allows self enrollment or only enrolled by instructor. This can only be set on creation.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | InstructorOnly | Students are added to the Group by the instructor |
             * | SelfEnrollment | Students are added to the Group by self enrollment |
             *
             */
            private Type type;

            /*
             * The maximum allowed enrollment size for self enrolled groups.
             */
            private int limit;

            /*
             * Settings controlling signup to the group for students. Only applicable if Enrollment.Type allows self enrollment.
             */
            private SignupSheet signupSheet;

            public static Enrollment create() {
                return new Enrollment();
            }

            public static class SignupSheet {
                /*
                 * The name of the signup sheet
                 */
                private String name;

                /*
                 * The description of the signup sheet This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
                 */
                private String description;

                /*
                 * A boolean indicating whether or not members can be seen by others prior to signing up.
                 */
                private boolean showMembers;

                public static SignupSheet create() {
                    return new SignupSheet();
                }

                public SignupSheet setName(String name) {
                    this.name = name;
                    return this;
                }

                public SignupSheet setDescription(String description) {
                    this.description = description;
                    return this;
                }

                public SignupSheet setShowMembers(boolean showMembers) {
                    this.showMembers = showMembers;
                    return this;
                }
            }

            public enum Type {
                InstructorOnly,
                SelfEnrollment
            }

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setLimit(int limit) {
                this.limit = limit;
                return this;
            }

            public Enrollment setSignupSheet(SignupSheet signupSheet) {
                this.signupSheet = signupSheet;
                return this;
            }
        }

        public CreateGroupSetBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateGroupSetBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreateGroupSetBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGroupSetBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateGroupSetBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }
    }

    /*
     * Get Group Set
     *
     * Loads a groupset in the specified course.
     *
     * Users calling this end point should meet at least one of these entitlement checks.
     *
     * - course.groups.VIEW
     * - course.groups.admin.VIEW
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> getGroupSet(String courseId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .build();
    }

    /*
     * Delete Group Set
     *
     * Deletes a groupset from the specified course.
     *
     * Required entitlements:
     *
     * - course.group.DELETE
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<Void> deleteGroupSet(String courseId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .build();
    }

    /*
     * Update Group Set
     *
     * Updates a groupset in the specified course.
     *
     * Minimal entitlements required:
     *
     * - course.group.MODIFY
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> updateGroupSet(String groupId, String courseId, UpdateGroupSetBody input) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .patch()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets/{groupId}")
            .pathParam("groupId", groupId)
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class UpdateGroupSetBody {
        /*
         * An externally-defined unique ID for the group. Defaults to a random UUID if not provided during create.
         */
        private String externalId;

        /*
         * The title of the group.
         */
        private String name;

        /*
         * The description of the group. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the group to students.
         */
        private Availability availability;

        /*
         * Settings controlling enrollment of the group to students.
         */
        private Enrollment enrollment;

        public static UpdateGroupSetBody create() {
            return new UpdateGroupSetBody();
        }

        public static class Availability {
            /*
             * Whether the Group is currently available to students.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the group. |
             * | No | Students may not access the group. |
             * | SignupOnly | Students may only signup and see the group listed, not yet access it. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                SignupOnly
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Enrollment {
            /*
             * The maximum allowed enrollment size for self enrolled groups.
             */
            private int limit;

            /*
             * Settings controlling signup to the group for students. Only applicable if Enrollment.Type allows self enrollment.
             */
            private SignupSheet signupSheet;

            public static Enrollment create() {
                return new Enrollment();
            }

            public static class SignupSheet {
                /*
                 * The name of the signup sheet
                 */
                private String name;

                /*
                 * The description of the signup sheet This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
                 */
                private String description;

                /*
                 * A boolean indicating whether or not members can be seen by others prior to signing up.
                 */
                private boolean showMembers;

                public static SignupSheet create() {
                    return new SignupSheet();
                }

                public SignupSheet setName(String name) {
                    this.name = name;
                    return this;
                }

                public SignupSheet setDescription(String description) {
                    this.description = description;
                    return this;
                }

                public SignupSheet setShowMembers(boolean showMembers) {
                    this.showMembers = showMembers;
                    return this;
                }
            }

            public Enrollment setLimit(int limit) {
                this.limit = limit;
                return this;
            }

            public Enrollment setSignupSheet(SignupSheet signupSheet) {
                this.signupSheet = signupSheet;
                return this;
            }
        }

        public UpdateGroupSetBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateGroupSetBody setName(String name) {
            this.name = name;
            return this;
        }

        public UpdateGroupSetBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateGroupSetBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateGroupSetBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }
    }

    /*
     * Get Group Set Children
     *
     * Returns a list of all groups within a groupset
     *
     * Callers not enrolled in the group must have the following entitlement:
     *
     * - course.groups.VIEW
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<List<GroupV2>> getGroupSetChildren(String groupId, String courseId, GetGroupSetChildrenOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GroupV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets/{groupId}/groups")
            .pathParam("groupId", groupId)
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetGroupSetChildrenOption extends RestCallOption {
        /*
         * Search for groups with created date relative to this value. 'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.8.0
         */
        public static GetGroupSetChildrenOption created(Instant created) {
            return parameter("created", created, new GetGroupSetChildrenOption());
        }

        /*
         * Used alongside the 'created' search parameter.
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetGroupSetChildrenOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetGroupSetChildrenOption());
        }

        /*
         * Search for groups with modified date relative to this value. 'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.8.0
         */
        public static GetGroupSetChildrenOption modified(Instant modified) {
            return parameter("modified", modified, new GetGroupSetChildrenOption());
        }

        /*
         * Used alongside the 'modified' search parameter.
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetGroupSetChildrenOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetGroupSetChildrenOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name(desc)" Supported fields are:
         *
         * - name
         * - externalId
         *
         * **Since**: 3100.4.0
         */
        public static GetGroupSetChildrenOption sort(String sort) {
            return parameter("sort", sort, new GetGroupSetChildrenOption());
        }
    }

    /*
     * Create Group Set Child
     *
     * Creates a group within a groupset.
     *
     * Callers must have the following entitlement:
     *
     * - 'course.groups.CREATE'
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> createGroupSetChild(String groupId, String courseId, CreateGroupSetChildBody input) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .post()
            .url("/learn/api/public/v2/courses/{courseId}/groups/sets/{groupId}/groups")
            .pathParam("groupId", groupId)
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateGroupSetChildBody {
        /*
         * An externally-defined unique ID for the group. Defaults to a random UUID if not provided during create.
         */
        private String externalId;

        /*
         * The title of the group.
         */
        private String name;

        /*
         * The description of the group. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the group to students.
         */
        private Availability availability;

        /*
         * Settings controlling enrollment of the group to students.
         */
        private Enrollment enrollment;

        public static CreateGroupSetChildBody create() {
            return new CreateGroupSetChildBody();
        }

        public static class Availability {
            /*
             * Whether the Group is currently available to students.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the group. |
             * | No | Students may not access the group. |
             * | SignupOnly | Students may only signup and see the group listed, not yet access it. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                SignupOnly
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Enrollment {
            /*
             * Whether the Group allows self enrollment or only enrolled by instructor. This can only be set on creation.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | InstructorOnly | Students are added to the Group by the instructor |
             * | SelfEnrollment | Students are added to the Group by self enrollment |
             *
             */
            private Type type;

            /*
             * The maximum allowed enrollment size for self enrolled groups.
             */
            private int limit;

            /*
             * Settings controlling signup to the group for students. Only applicable if Enrollment.Type allows self enrollment.
             */
            private SignupSheet signupSheet;

            public static Enrollment create() {
                return new Enrollment();
            }

            public static class SignupSheet {
                /*
                 * The name of the signup sheet
                 */
                private String name;

                /*
                 * The description of the signup sheet This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
                 */
                private String description;

                /*
                 * A boolean indicating whether or not members can be seen by others prior to signing up.
                 */
                private boolean showMembers;

                public static SignupSheet create() {
                    return new SignupSheet();
                }

                public SignupSheet setName(String name) {
                    this.name = name;
                    return this;
                }

                public SignupSheet setDescription(String description) {
                    this.description = description;
                    return this;
                }

                public SignupSheet setShowMembers(boolean showMembers) {
                    this.showMembers = showMembers;
                    return this;
                }
            }

            public enum Type {
                InstructorOnly,
                SelfEnrollment
            }

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setLimit(int limit) {
                this.limit = limit;
                return this;
            }

            public Enrollment setSignupSheet(SignupSheet signupSheet) {
                this.signupSheet = signupSheet;
                return this;
            }
        }

        public CreateGroupSetChildBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateGroupSetChildBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreateGroupSetChildBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGroupSetChildBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateGroupSetChildBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }
    }

    /*
     * Get Group
     *
     * Loads a group in the specified course.
     *
     * Callers not enrolled in the course must have the following entitlement:
     *
     * - course.groups.VIEW
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> getGroup(String courseId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .build();
    }

    /*
     * Delete Group
     *
     * Deletes a groupset from the specified course.
     *
     * Required entitlements:
     *
     * - course.group.DELETE
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<Void> deleteGroup(String groupId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}")
            .pathParam("groupId", groupId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Update Group
     *
     * Updates a group in the specified course.
     *
     * Minimal entitlements required:
     *
     * - course.group.MODIFY
     *
     * **Since**: 3800.6.0
     */
    public static RestCall<GroupV2> updateGroup(String courseId, String groupId, UpdateGroupBody input) {
        return RestCallBuilder
            .start(new TypeToken<GroupV2>() {})
            .patch()
            .url("/learn/api/public/v2/courses/{courseId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .body(input)
            .build();
    }

    public static class UpdateGroupBody {
        /*
         * An externally-defined unique ID for the group. Defaults to a random UUID if not provided during create.
         */
        private String externalId;

        /*
         * The title of the group.
         */
        private String name;

        /*
         * The description of the group. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the group to students.
         */
        private Availability availability;

        /*
         * Settings controlling enrollment of the group to students.
         */
        private Enrollment enrollment;

        public static UpdateGroupBody create() {
            return new UpdateGroupBody();
        }

        public static class Availability {
            /*
             * Whether the Group is currently available to students.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the group. |
             * | No | Students may not access the group. |
             * | SignupOnly | Students may only signup and see the group listed, not yet access it. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No,
                SignupOnly
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Enrollment {
            /*
             * The maximum allowed enrollment size for self enrolled groups.
             */
            private int limit;

            /*
             * Settings controlling signup to the group for students. Only applicable if Enrollment.Type allows self enrollment.
             */
            private SignupSheet signupSheet;

            public static Enrollment create() {
                return new Enrollment();
            }

            public static class SignupSheet {
                /*
                 * The name of the signup sheet
                 */
                private String name;

                /*
                 * The description of the signup sheet This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
                 */
                private String description;

                /*
                 * A boolean indicating whether or not members can be seen by others prior to signing up.
                 */
                private boolean showMembers;

                public static SignupSheet create() {
                    return new SignupSheet();
                }

                public SignupSheet setName(String name) {
                    this.name = name;
                    return this;
                }

                public SignupSheet setDescription(String description) {
                    this.description = description;
                    return this;
                }

                public SignupSheet setShowMembers(boolean showMembers) {
                    this.showMembers = showMembers;
                    return this;
                }
            }

            public Enrollment setLimit(int limit) {
                this.limit = limit;
                return this;
            }

            public Enrollment setSignupSheet(SignupSheet signupSheet) {
                this.signupSheet = signupSheet;
                return this;
            }
        }

        public UpdateGroupBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateGroupBody setName(String name) {
            this.name = name;
            return this;
        }

        public UpdateGroupBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateGroupBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateGroupBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }
    }
}
