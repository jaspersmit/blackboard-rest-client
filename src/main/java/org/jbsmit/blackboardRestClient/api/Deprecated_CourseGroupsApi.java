package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Group;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class Deprecated_CourseGroupsApi {
    /*
     * Get Groups
     *
     * Callers with the following entitlement can view all groups in the course:
     *
     * - course.groups.VIEW
     * Callers enrolled in course can view all groups they're enrolled in, and all self-enrollment groups
     *
     * **Since**: 3100.5.0
     *
     * **Deprecated**: since 3800.6.0; use the v2 end-point instead.
     */
    public static RestCall<List<Group>> getGroups(String courseId, GetGroupsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Group>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/groups")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetGroupsOption extends RestCallOption {
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
     * Minimal entitlements required:
     *
     * - course.group.CREATE
     *
     * **Since**: 3100.5.0
     *
     * **Deprecated**: since 3800.6.0; use the v2 end-point instead.
     */
    public static RestCall<Group> createGroup(String courseId, CreateGroupBody input) {
        return RestCallBuilder
            .start(new TypeToken<Group>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/groups")
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
         * The primary ID of the group's parent group set.
         */
        private String parentId;

        /*
         * The title of the group.
         */
        private String name;

        /*
         * The description of the group. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Whether or not this is a group set.
         *
         * **Since**: 3700.1.0
         */
        private boolean isGroupSet;

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

        public CreateGroupBody setParentId(String parentId) {
            this.parentId = parentId;
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

        public CreateGroupBody setIsGroupSet(boolean isGroupSet) {
            this.isGroupSet = isGroupSet;
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
     * Get Group
     *
     * Loads a group in the specified course.
     *
     * Entitlement and field visibility rules are the same as those when loading the groups collection.
     *
     * **Since**: 3100.5.0
     *
     * **Deprecated**: since 3800.6.0; use the v2 end-point instead.
     */
    public static RestCall<Group> getGroup(String courseId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<Group>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
            .build();
    }

    /*
     * Delete Group
     *
     * Deletes a group from the specified course.
     *
     * Required entitlements:
     *
     * - course.group.DELETE
     *
     * **Since**: 3100.5.0
     *
     * **Deprecated**: since 3800.6.0; use the v2 end-point instead.
     */
    public static RestCall<Void> deleteGroup(String courseId, String groupId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}")
            .pathParam("courseId", courseId)
            .pathParam("groupId", groupId)
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
     * **Since**: 3100.5.0
     *
     * **Deprecated**: since 3800.6.0; use the v2 end-point instead.
     */
    public static RestCall<Group> updateGroup(String courseId, String groupId, UpdateGroupBody input) {
        return RestCallBuilder
            .start(new TypeToken<Group>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/groups/{groupId}")
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
         * The primary ID of the group's parent group set.
         */
        private String parentId;

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

        public UpdateGroupBody setParentId(String parentId) {
            this.parentId = parentId;
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
