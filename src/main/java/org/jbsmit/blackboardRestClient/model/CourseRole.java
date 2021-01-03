package org.jbsmit.blackboardRestClient.model;


public class CourseRole {
    /*
     * The primary ID of the course role
     */
    private String id;

    /*
     * The identifier used to assign the course role to a course enrollment.
     *
     * For system defined course roles, this value will be one of Student, Instructor, TeachingAssistant, CourseBuilder, Grader or Guest
     *
     * For custom course roles, this will be the roleId entered during the creation of the role. Allowed characters for the custom course roleId's are any letter, number, period, underscore and dash.
     */
    private String roleId;

    /*
     * The role name presented to users when the course role is associated with a course.
     */
    private String nameForCourses;

    /*
     * The role name presented to users when the course role is associated with an organization.
     */
    private String nameForOrganizations;

    /*
     * Optional description of the course role
     */
    private String description;

    /*
     * False if the course role exists as a system generated course role. True if the course role was created by an admin user.
     *
     * Both custom and system generated course roles can be modified, but only custom course roles can be deleted.
     */
    private boolean custom;

    /*
     * Implies access to unavailable courses, display in the Course catalog, and receiving email enrollment requests
     */
    private boolean actAsInstructor;

    private Availability availability;


    public static class Availability {
        /*
         * Whether the course role is currently available to course enrollments, organization enrollments, both or neither.  Valid values are:
         *
         * - Course: Course Role is available to Course Enrollments
         * - Organization: Course Role is available to Organization Enrollments
         * - Both: Course Role is available to both Course and Organization Enrollments
         * - None: Course Role is not available
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Course | Course only |
         * | Organization | Organization only |
         * | CourseAndOrganization | Both Course and Organization |
         * | No | Neither Course nor Organization |
         *
         */
        private Available available;

        public static Availability create() {
            return new Availability();
        }

        public enum Available {
            Course,
            Organization,
            CourseAndOrganization,
            No
        }

        public Available getAvailable() {
            return available;
        }

        public Availability setAvailable(Available available) {
            this.available = available;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public CourseRole setId(String id) {
        this.id = id;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public CourseRole setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getNameForCourses() {
        return nameForCourses;
    }

    public CourseRole setNameForCourses(String nameForCourses) {
        this.nameForCourses = nameForCourses;
        return this;
    }

    public String getNameForOrganizations() {
        return nameForOrganizations;
    }

    public CourseRole setNameForOrganizations(String nameForOrganizations) {
        this.nameForOrganizations = nameForOrganizations;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CourseRole setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getCustom() {
        return custom;
    }

    public CourseRole setCustom(boolean custom) {
        this.custom = custom;
        return this;
    }

    public boolean getActAsInstructor() {
        return actAsInstructor;
    }

    public CourseRole setActAsInstructor(boolean actAsInstructor) {
        this.actAsInstructor = actAsInstructor;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public CourseRole setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }
}

