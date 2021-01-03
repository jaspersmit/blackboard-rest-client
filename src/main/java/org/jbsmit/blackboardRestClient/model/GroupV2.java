package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class GroupV2 {
    /*
     * The primary ID of the group.
     */
    private String id;

    /*
     * An externally-defined unique ID for the group. Defaults to a random UUID if not provided during create.
     */
    private String externalId;

    /*
     * The primary ID of the group's parent group set.
     */
    private String groupSetId;

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

    /*
     * A system-wide unique identifier created by Learn
     */
    private String uuid;

    /*
     * Created date of the group
     *
     * **Since**: 3800.8.0
     */
    private Instant created;

    /*
     * Modified date of the group
     *
     * **Since**: 3800.8.0
     */
    private Instant modified;


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

        public Available getAvailable() {
            return available;
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

            public String getName() {
                return name;
            }

            public SignupSheet setName(String name) {
                this.name = name;
                return this;
            }

            public String getDescription() {
                return description;
            }

            public SignupSheet setDescription(String description) {
                this.description = description;
                return this;
            }

            public boolean getShowMembers() {
                return showMembers;
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

        public Type getType() {
            return type;
        }

        public Enrollment setType(Type type) {
            this.type = type;
            return this;
        }

        public int getLimit() {
            return limit;
        }

        public Enrollment setLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public SignupSheet getSignupSheet() {
            return signupSheet;
        }

        public Enrollment setSignupSheet(SignupSheet signupSheet) {
            this.signupSheet = signupSheet;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public GroupV2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public GroupV2 setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getGroupSetId() {
        return groupSetId;
    }

    public GroupV2 setGroupSetId(String groupSetId) {
        this.groupSetId = groupSetId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GroupV2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GroupV2 setDescription(String description) {
        this.description = description;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public GroupV2 setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public GroupV2 setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public GroupV2 setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public GroupV2 setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public GroupV2 setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}

