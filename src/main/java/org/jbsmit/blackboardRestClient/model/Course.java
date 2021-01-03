package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class Course {
    /*
     * The primary ID of the course.
     */
    private String id;

    /*
     * A secondary unique ID for the course. Used by LTI launches and other inter-server operations.
     */
    private String uuid;

    /*
     * An optional externally-defined unique ID for the course. Defaults to the courseId.
     *
     * Formerly known as 'batchUid'.
     */
    private String externalId;

    /*
     * The ID of the data source associated with this course. This may optionally be the data source's externalId using the syntax "externalId:math101".
     */
    private String dataSourceId;

    /*
     * The Course ID attribute, shown to users in the UI.
     */
    private String courseId;

    /*
     * The name of the course.
     */
    private String name;

    /*
     * The description of the course.
     */
    private String description;

    /*
     * The date this course was created.
     */
    private Instant created;

    /*
     * Whether this object represents an Organization. Defaults to false.
     */
    private boolean organization;

    /*
     * Whether the course is rendered using Classic or Ultra Course View.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Undecided | The ultra status is not decided. |
     * | Classic | The course is decided as classic. |
     * | Ultra | The course is decided as ultra |
     * | UltraPreview | The course is currently in Ultra mode but during the preview state where it may still be reverted via a Restore to the classic state |
     *
     */
    private UltraStatus ultraStatus;

    /*
     * Whether guests (users with the role guest) are allowed access to the course. Defaults to true.
     */
    private boolean allowGuests;

    /*
     * This status does not affect availability of the course for viewing in any way. readOnly is valid for both Ultra and Classic courses. If an Ultra course is in readOnly mode, updates are not possible. For a Classic course in readOnly mode, updates are still possible (through Web UI but not through REST i.e. closed is enforced for original courses when updated through REST the same way Ultra courses are blocked) but new notifications are not generated.
     *
     * **Deprecated**: since 3400.8.0; use the v2 endpoint's closedComplete property instead
     */
    private boolean readOnly;

    /*
     * The ID of the term associated to this course. This may optionally be the term's externalId using the syntax "externalId:spring.2016".
     */
    private String termId;

    /*
     * Settings controlling availability of the course to students.
     */
    private Availability availability;

    /*
     * Settings controlling how students may enroll in the course.
     */
    private Enrollment enrollment;

    /*
     * Settings controlling localization within the course.
     */
    private Locale locale;

    /*
     * Whether the course has any cross-listed children.
     *
     * **Since**: 3000.11.0
     */
    private boolean hasChildren;

    /*
     * The cross-listed parentId associated with the course, if the course is a child course.
     *
     * **Since**: 3000.11.0
     */
    private String parentId;

    /*
     * A URL corresponding to the Course Page for the course.  Formatting varies based on whether the course is rendered using Classic or Ultra Course View
     *
     * **Since**: 3200.3.0
     */
    private String externalAccessUrl;

    /*
     * A URL for viewing the Course Page for the course as a guest.  Formatting varies based on whether the course is rendered using Classic or Ultra Course View
     *
     * **Since**: 3200.3.0
     */
    private String guestAccessUrl;


    public static class Availability {
        /*
         * Whether the course is currently available to students. Instructors can always access the course if they have 'Access unavailable course' entitlement. If set to 'Term', the course's parent term availability settings will be used.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Yes | Students may access the course. |
         * | No | Students may not access the course. |
         * | Disabled | Disabled by the SIS. Students may not access the course.  **Since**: 3100.0.0 |
         * | Term | Availability is inherited from the term settings. Requires a termId be set. |
         *
         */
        private Available available;

        /*
         * Settings controlling the length of time the course is available.
         */
        private Duration duration;

        public static Availability create() {
            return new Availability();
        }

        public static class Duration {
            /*
             * The intended length of the course.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Continuous | Course is active on an ongoing basis. |
             * | DateRange | Course is only intended to be available between specific date ranges |
             * | FixedNumDays | Course is only available for a set number of days |
             * | Term | Course availablity is dictated by its associated term |
             *
             */
            private Type type;

            /*
             * The date this course starts. May only be set if availability.duration.type is DateRange.
             */
            private Instant start;

            /*
             * The date this course ends. May only be set if availability.duration.type is DateRange.
             */
            private Instant end;

            /*
             * The number of days this course can be used. May only be set if availability.duration.type is FixedNumDays.
             */
            private int daysOfUse;

            public static Duration create() {
                return new Duration();
            }

            public enum Type {
                Continuous,
                DateRange,
                FixedNumDays,
                Term
            }

            public Type getType() {
                return type;
            }

            public Duration setType(Type type) {
                this.type = type;
                return this;
            }

            public Instant getStart() {
                return start;
            }

            public Duration setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Instant getEnd() {
                return end;
            }

            public Duration setEnd(Instant end) {
                this.end = end;
                return this;
            }

            public int getDaysOfUse() {
                return daysOfUse;
            }

            public Duration setDaysOfUse(int daysOfUse) {
                this.daysOfUse = daysOfUse;
                return this;
            }
        }

        public enum Available {
            Yes,
            No,
            Disabled,
            Term
        }

        public Available getAvailable() {
            return available;
        }

        public Availability setAvailable(Available available) {
            this.available = available;
            return this;
        }

        public Duration getDuration() {
            return duration;
        }

        public Availability setDuration(Duration duration) {
            this.duration = duration;
            return this;
        }
    }

    public static class Enrollment {
        /*
         * Specifies the enrollment options for the course. Defaults to InstructorLed.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | InstructorLed | Enrollment tasks for the course can only performed by the instructor |
         * | SelfEnrollment | Instructors have the ability to enroll users, and students can also enroll themselves in the course |
         * | EmailEnrollment | Instructors have the ability to enroll users, and students can email requests to the instructor for enrollment |
         *
         */
        private Type type;

        /*
         * The date on which enrollments are allowed for the course. May only be set if enrollment.type is SelfEnrollment.
         */
        private Instant start;

        /*
         * The date on which enrollment in this course ends. May only be set if enrollment.type is SelfEnrollment.
         */
        private Instant end;

        /*
         * The enrollment access code associated with this course. May only be set if enrollment.type is SelfEnrollment.
         */
        private String accessCode;

        public static Enrollment create() {
            return new Enrollment();
        }

        public enum Type {
            InstructorLed,
            SelfEnrollment,
            EmailEnrollment
        }

        public Type getType() {
            return type;
        }

        public Enrollment setType(Type type) {
            this.type = type;
            return this;
        }

        public Instant getStart() {
            return start;
        }

        public Enrollment setStart(Instant start) {
            this.start = start;
            return this;
        }

        public Instant getEnd() {
            return end;
        }

        public Enrollment setEnd(Instant end) {
            this.end = end;
            return this;
        }

        public String getAccessCode() {
            return accessCode;
        }

        public Enrollment setAccessCode(String accessCode) {
            this.accessCode = accessCode;
            return this;
        }
    }

    public static class Locale {
        /*
         * The locale of this course.
         */
        private String id;

        /*
         * Whether students are forced to use the course's specified locale.
         */
        private boolean force;

        public static Locale create() {
            return new Locale();
        }

        public String getId() {
            return id;
        }

        public Locale setId(String id) {
            this.id = id;
            return this;
        }

        public boolean getForce() {
            return force;
        }

        public Locale setForce(boolean force) {
            this.force = force;
            return this;
        }
    }

    public enum UltraStatus {
        Undecided,
        Classic,
        Ultra,
        UltraPreview
    }

    public String getId() {
        return id;
    }

    public Course setId(String id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Course setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public Course setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public Course setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public Course setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Course setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public boolean getOrganization() {
        return organization;
    }

    public Course setOrganization(boolean organization) {
        this.organization = organization;
        return this;
    }

    public UltraStatus getUltraStatus() {
        return ultraStatus;
    }

    public Course setUltraStatus(UltraStatus ultraStatus) {
        this.ultraStatus = ultraStatus;
        return this;
    }

    public boolean getAllowGuests() {
        return allowGuests;
    }

    public Course setAllowGuests(boolean allowGuests) {
        this.allowGuests = allowGuests;
        return this;
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    public Course setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public String getTermId() {
        return termId;
    }

    public Course setTermId(String termId) {
        this.termId = termId;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Course setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public Course setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
        return this;
    }

    public Locale getLocale() {
        return locale;
    }

    public Course setLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    public boolean getHasChildren() {
        return hasChildren;
    }

    public Course setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Course setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getExternalAccessUrl() {
        return externalAccessUrl;
    }

    public Course setExternalAccessUrl(String externalAccessUrl) {
        this.externalAccessUrl = externalAccessUrl;
        return this;
    }

    public String getGuestAccessUrl() {
        return guestAccessUrl;
    }

    public Course setGuestAccessUrl(String guestAccessUrl) {
        this.guestAccessUrl = guestAccessUrl;
        return this;
    }
}

