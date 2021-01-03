package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Course;
import org.jbsmit.blackboardRestClient.model.CourseV2;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class Deprecated_CoursesApi {
    /*
     * Get Courses
     *
     * Returns a list of courses and organizations.
     *
     * To view disabled courses a user must have the entitlement 'system.course.VIEW'.
     *
     * Users with the 'course.configure-properties.EXECUTE' entitlement can access all course properties.
     *
     * Users enrolled in the course have read access to all properties except:
     *
     * - uuid
     * - externalId
     * - dataSourceId
     * - created
     * - allowGuests
     * - enrollment.accessCode
     *
     * Users who are not enrolled in the course and do not have associated entitlements only have read access to the following properties:
     *
     * - id
     * - courseId
     * - name
     * - description
     * - organization
     * - readOnly
     * - termId
     * - availability.available
     * - availability.duration.type
     * - availability.duration.start
     * - availability.duration.end
     * - availability.duration.daysOfUse
     * If the course enrollment is self-enroll, all users can view the course as though they were enrolled.
     *
     * **Since**: 3000.1.0
     *
     * **Deprecated**: since 3400.8.0; use the v2 end-point instead
     */
    public static RestCall<List<Course>> getCourses(GetCoursesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Course>>() {})
            .get()
            .url("/learn/api/public/v1/courses")
            .options(options)
            .build();
    }

    public static class GetCoursesOption extends RestCallOption {
        /*
         * Search for courses with courseId properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption courseId(String courseId) {
            return parameter("courseId", courseId, new GetCoursesOption());
        }

        /*
         * Search for courses with name properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption name(String name) {
            return parameter("name", name, new GetCoursesOption());
        }

        /*
         * Search for courses with description properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption description(String description) {
            return parameter("description", description, new GetCoursesOption());
        }

        /*
         * Search for courses with externalId properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption externalId(String externalId) {
            return parameter("externalId", externalId, new GetCoursesOption());
        }

        /*
         * Search for courses with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption created(Instant created) {
            return parameter("created", created, new GetCoursesOption());
        }

        /*
         * Search for courses which are configured to allow/disallow guest access, based on input.  Default: n/a (return courses regardless of guests allowed)
         *
         * **Since**: 3200.3.0
         */
        public static GetCoursesOption allowGuests(boolean allowGuests) {
            return parameter("allowGuests", allowGuests, new GetCoursesOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Defaults to greaterOrEqual if not specified.
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
        public static GetCoursesOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetCoursesOption());
        }

        /*
         * Search for courses with availability.available properties that contain this value.
         *
         * **Since**: 3000.13.0
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
        public static GetCoursesOption availability_available(String availability_available) {
            return parameter("availability.available", availability_available, new GetCoursesOption());
        }

        /*
         * Search for courses with this dataSourceId.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetCoursesOption());
        }

        /*
         * Search for courses with this termId.  This may optionally be the term's externalId using the syntax "externalId:spring2015".
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption termId(String termId) {
            return parameter("termId", termId, new GetCoursesOption());
        }

        /*
         * Search for courses by organization flag.  A value of 'true' indicates that search results should be limited to only Organizations.  A value of 'false' indicates results should be limited to Courses.  Not setting this field indicates that both Courses and Organizations should be returned.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption organization(boolean organization) {
            return parameter("organization", organization, new GetCoursesOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name(desc),created" Supported fields are:
         *
         * - courseId
         * - name
         * - externalId
         * - created
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesOption sort(String sort) {
            return parameter("sort", sort, new GetCoursesOption());
        }
    }

    /*
     * Create Course
     *
     * Creates a course or organization.
     *
     * The 'system.course.CREATE' entitlement is needed to create a course, while 'system.org.CREATE' is needed for an organization.
     *
     * **Since**: 2015.11.0
     *
     * **Deprecated**: since 3400.8.0; use the v2 end-point instead
     */
    public static RestCall<Course> createCourse(CreateCourseBody input) {
        return RestCallBuilder
            .start(new TypeToken<Course>() {})
            .post()
            .url("/learn/api/public/v1/courses")
            .body(input)
            .build();
    }

    public static class CreateCourseBody {
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

        public static CreateCourseBody create() {
            return new CreateCourseBody();
        }

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

                public Duration setType(Type type) {
                    this.type = type;
                    return this;
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
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

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
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

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Enrollment setEnd(Instant end) {
                this.end = end;
                return this;
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

            public Locale setId(String id) {
                this.id = id;
                return this;
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

        public CreateCourseBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateCourseBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public CreateCourseBody setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public CreateCourseBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreateCourseBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateCourseBody setOrganization(boolean organization) {
            this.organization = organization;
            return this;
        }

        public CreateCourseBody setUltraStatus(UltraStatus ultraStatus) {
            this.ultraStatus = ultraStatus;
            return this;
        }

        public CreateCourseBody setAllowGuests(boolean allowGuests) {
            this.allowGuests = allowGuests;
            return this;
        }

        public CreateCourseBody setReadOnly(boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public CreateCourseBody setTermId(String termId) {
            this.termId = termId;
            return this;
        }

        public CreateCourseBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateCourseBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }

        public CreateCourseBody setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }
    }

    /*
     * Get Course
     *
     * Loads a specific course or organization.
     *
     * To view disabled courses a user must have the entitlement 'system.course.VIEW'.
     *
     * Users with the 'course.configure-properties.EXECUTE' entitlement can access all course properties.
     *
     * Users enrolled in the course have read access to all properties except:
     *
     * - uuid
     * - externalId
     * - dataSourceId
     * - created
     * - allowGuests
     * - enrollment.accessCode
     *
     * Users who are not enrolled in the course and do not have associated entitlements only have read access to the following properties:
     *
     * - id
     * - courseId
     * - name
     * - description
     * - organization
     * - readOnly
     * - termId
     * - availability.available
     * - availability.duration.type
     * - availability.duration.start
     * - availability.duration.end
     * - availability.duration.daysOfUse
     * If the course enrollment is self-enroll, all users can view the course as though they were enrolled.
     *
     * **Since**: 2015.11.0
     *
     * **Deprecated**: since 3400.8.0; use the v2 end-point instead
     */
    public static RestCall<Course> getCourse(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Course>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Delete Course
     *
     * Deletes a course or organization in synchronous fashion.
     *
     * The 'system.course.DELETE' entitlement is needed to delete a course, while 'system.org.DELETE' is needed for an organization.
     *
     * **Since**: 2015.11.0
     *
     * **Deprecated**: since 3400.8.0; use the v2 end-point instead
     */
    public static RestCall<Void> deleteCourse(String courseId, DeleteCourseOption... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class DeleteCourseOption extends RestCallOption {
        /*
         * Whether to delete course files.  Defaults to true.
         */
        public static DeleteCourseOption removeFiles(boolean removeFiles) {
            return parameter("removeFiles", removeFiles, new DeleteCourseOption());
        }
    }

    /*
     * Update Course
     *
     * Updates a course or organization.
     *
     * To update a course, the user must have either 'system.course|org.properties.MODIFY' or 'course.configure-properties.EXECUTE' entitlements.  However, if the user has the latter entitlement, then additional entitlements are needed to be able to update certain fields, as shown below:
     *
     *  | Field                           | Entitlements Required                                                  |
     *  |---------------------------------|------------------------------------------------------------------------|
     *  | name                            | course.name.MODIFY                                                     |
     *  | description                     | course.name.MODIFY                                                     |
     *  | allowGuests                     | course.configure-guest-access.EXECUTE                                  |
     *  | enrollment.type                 | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | enrollment.start                | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | enrollment.end                  | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | enrollment.accessCode           | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | availability.available          | course.configure-properties.EXECUTE, course.availability.MODIFY        |
     *  | locale.id                       | course.configure-properties.EXECUTE, course.locale.MODIFY              |
     *  | locale.force                    | course.configure-properties.EXECUTE, course.locale.MODIFY              |
     *  | availability.duration.type      | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *  | availability.duration.start     | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *  | availability.duration.end       | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *  | availability.duration.daysOfUse | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *
     *
     * **Since**: 2015.11.0
     *
     * **Deprecated**: since 3400.8.0; use the v2 end-point instead
     */
    public static RestCall<Course> updateCourse(String courseId, UpdateCourseBody input) {
        return RestCallBuilder
            .start(new TypeToken<Course>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class UpdateCourseBody {
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
         * The name of the course.
         */
        private String name;

        /*
         * The description of the course.
         */
        private String description;

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

        public static UpdateCourseBody create() {
            return new UpdateCourseBody();
        }

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

                public Duration setType(Type type) {
                    this.type = type;
                    return this;
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
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

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
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

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Enrollment setEnd(Instant end) {
                this.end = end;
                return this;
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

            public Locale setId(String id) {
                this.id = id;
                return this;
            }

            public Locale setForce(boolean force) {
                this.force = force;
                return this;
            }
        }

        public UpdateCourseBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateCourseBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public UpdateCourseBody setName(String name) {
            this.name = name;
            return this;
        }

        public UpdateCourseBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateCourseBody setAllowGuests(boolean allowGuests) {
            this.allowGuests = allowGuests;
            return this;
        }

        public UpdateCourseBody setReadOnly(boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public UpdateCourseBody setTermId(String termId) {
            this.termId = termId;
            return this;
        }

        public UpdateCourseBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateCourseBody setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }

        public UpdateCourseBody setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }
    }

    /*
     * Copy Course
     *
     * Creates an exact copy of an existing Course into a new Course.
     *
     * Users with entitlements 'system.course.copy.EXECUTE' can create a course copy. Users with entitlements 'system.org.copy.EXECUTE' can create an organization copy. All users's must also have 'course.content.copy.EXECUTE' entitlement associated with the specified source courseId.
     *
     * **Since**: 3300.0.0
     *
     * **Deprecated**: since 3800.0.0; use the v2 end-point instead.
     */
    public static RestCall<Void> copyCourse(String courseId, CopyCourseBody reqCourseObjToConvert) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/copy")
            .pathParam("courseId", courseId)
            .body(reqCourseObjToConvert)
            .build();
    }

    public static class CopyCourseBody {
        /*
         * The Course ID to copy into.
         */
        private String courseId;

        public static CopyCourseBody create() {
            return new CopyCourseBody();
        }

        public CopyCourseBody setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }
    }

    /*
     * Get Courses
     *
     * Returns a list of courses and organizations.
     *
     * To view disabled courses a user must have the entitlement 'system.course.VIEW'.
     *
     * Users with the 'course.configure-properties.EXECUTE' course entitlement, or the 'system.course.properties.MODIFY' system entitlement can access all course properties.
     *
     * Users enrolled in the course have read access to all properties except:
     *
     * - uuid
     * - externalId
     * - dataSourceId
     * - created
     * - allowGuests
     * - enrollment.accessCode
     *
     * Users who are not enrolled in the course and do not have associated entitlements only have read access to the following properties:
     *
     * - id
     * - courseId
     * - name
     * - description
     * - organization
     * - readOnly
     * - termId
     * - availability.available
     * - availability.duration.type
     * - availability.duration.start
     * - availability.duration.end
     * - availability.duration.daysOfUse
     * If the course enrollment is self-enroll, all users can view the course as though they were enrolled.
     *
     * **Since**: 3400.8.0
     *
     * **Deprecated**: since 3800.1.0; use the v3 end-point instead
     */
    public static RestCall<List<CourseV2>> getCoursesV2(GetCoursesV2Option... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses")
            .options(options)
            .build();
    }

    public static class GetCoursesV2Option extends RestCallOption {
        /*
         * Search for courses with a modified date relative to this value.  'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3500.4.0
         */
        public static GetCoursesV2Option modified(Instant modified) {
            return parameter("modified", modified, new GetCoursesV2Option());
        }

        /*
         * Used alongside the 'modified' search parameter. Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3500.4.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetCoursesV2Option modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetCoursesV2Option());
        }

        /*
         * Search for courses with courseId properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option courseId(String courseId) {
            return parameter("courseId", courseId, new GetCoursesV2Option());
        }

        /*
         * Search for courses with name properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option name(String name) {
            return parameter("name", name, new GetCoursesV2Option());
        }

        /*
         * Search for courses with description properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option description(String description) {
            return parameter("description", description, new GetCoursesV2Option());
        }

        /*
         * Search for courses with externalId properties that contain this value.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option externalId(String externalId) {
            return parameter("externalId", externalId, new GetCoursesV2Option());
        }

        /*
         * Search for courses with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option created(Instant created) {
            return parameter("created", created, new GetCoursesV2Option());
        }

        /*
         * Search for courses which are configured to allow/disallow guest access, based on input.  Default: n/a (return courses regardless of guests allowed)
         *
         * **Since**: 3200.3.0
         */
        public static GetCoursesV2Option allowGuests(boolean allowGuests) {
            return parameter("allowGuests", allowGuests, new GetCoursesV2Option());
        }

        /*
         * Used alongside the 'created' search parameter.  Defaults to greaterOrEqual if not specified.
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
        public static GetCoursesV2Option createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetCoursesV2Option());
        }

        /*
         * Search for courses with availability.available properties that contain this value.
         *
         * **Since**: 3000.13.0
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
        public static GetCoursesV2Option availability_available(String availability_available) {
            return parameter("availability.available", availability_available, new GetCoursesV2Option());
        }

        /*
         * Search for courses with this dataSourceId.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetCoursesV2Option());
        }

        /*
         * Search for courses with this termId.  This may optionally be the term's externalId using the syntax "externalId:spring2015".
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option termId(String termId) {
            return parameter("termId", termId, new GetCoursesV2Option());
        }

        /*
         * Search for courses by organization flag.  A value of 'true' indicates that search results should be limited to only Organizations.  A value of 'false' indicates results should be limited to Courses.  Not setting this field indicates that both Courses and Organizations should be returned.
         *
         * **Since**: 3100.0.0
         */
        public static GetCoursesV2Option organization(boolean organization) {
            return parameter("organization", organization, new GetCoursesV2Option());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name(desc),created" Supported fields are:
         *
         * - courseId
         * - name
         * - externalId
         * - created
         * - modified
         *
         * **Since**: 3400.8.0
         */
        public static GetCoursesV2Option sort(String sort) {
            return parameter("sort", sort, new GetCoursesV2Option());
        }
    }

    /*
     * Create Course
     *
     * Creates a course or organization.
     *
     * The 'system.course.CREATE' entitlement is needed to create a course, while 'system.org.CREATE' is needed for an organization.
     *
     * **Since**: 3400.8.0
     *
     * **Deprecated**: since 3800.1.0; use the v3 end-point instead
     */
    public static RestCall<CourseV2> createCourseV2(CreateCourseV2Body input) {
        return RestCallBuilder
            .start(new TypeToken<CourseV2>() {})
            .post()
            .url("/learn/api/public/v2/courses")
            .body(input)
            .build();
    }

    public static class CreateCourseV2Body {
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
         * This status does not affect availability of the course for viewing in any way. closedComplete is valid for both Ultra and Classic courses. If an Ultra course is in closedComplete mode, updates are not possible. For a Classic course in closedComplete mode, updates are still possible (through Web UI but not through REST i.e. closed is enforced for original courses when updated through REST the same way Ultra courses are blocked) but new notifications are not generated.
         */
        private boolean closedComplete;

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

        public static CreateCourseV2Body create() {
            return new CreateCourseV2Body();
        }

        public static class Availability {
            /*
             * Whether the course is currently available to students. Instructors can always access the course if they have 'Access unavailable course' entitlement. If set to 'Term', the course's parent term availability settings will be used.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the course. |
             * | No | Students may not access the course. |
             * | Disabled | Disabled by the SIS. Students may not access the course. @since 3100.0.0 |
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
                 * The intended length of the course. Possible values are:
                 *
                 * - Continuous: The course is active on an ongoing basis. This is the default.
                 * - DateRange: The course will only be available between specific date ranges.
                 * - FixedNumDays: The course will only be available for a set number of days.
                 * - Term: The course's parent term duration settings will be used.
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

                public Duration setType(Type type) {
                    this.type = type;
                    return this;
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
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

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
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

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Enrollment setEnd(Instant end) {
                this.end = end;
                return this;
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

            public Locale setId(String id) {
                this.id = id;
                return this;
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

        public CreateCourseV2Body setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateCourseV2Body setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public CreateCourseV2Body setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public CreateCourseV2Body setName(String name) {
            this.name = name;
            return this;
        }

        public CreateCourseV2Body setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateCourseV2Body setOrganization(boolean organization) {
            this.organization = organization;
            return this;
        }

        public CreateCourseV2Body setUltraStatus(UltraStatus ultraStatus) {
            this.ultraStatus = ultraStatus;
            return this;
        }

        public CreateCourseV2Body setAllowGuests(boolean allowGuests) {
            this.allowGuests = allowGuests;
            return this;
        }

        public CreateCourseV2Body setClosedComplete(boolean closedComplete) {
            this.closedComplete = closedComplete;
            return this;
        }

        public CreateCourseV2Body setTermId(String termId) {
            this.termId = termId;
            return this;
        }

        public CreateCourseV2Body setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateCourseV2Body setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }

        public CreateCourseV2Body setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }
    }

    /*
     * Get Course
     *
     * Loads a specific course or organization.
     *
     * To view disabled courses a user must have the entitlement 'system.course.VIEW'.
     *
     * Users with the 'course.configure-properties.EXECUTE' entitlement can access all course properties.
     *
     * Users enrolled in the course have read access to all properties except:
     *
     * - uuid
     * - externalId
     * - dataSourceId
     * - created
     * - allowGuests
     * - enrollment.accessCode
     *
     * Users with no access to the course only have read access to the following properties:
     *
     * - id
     * - courseId
     * - name
     * - description
     * - organization
     * - closedComplete
     * - termId
     * - availability.available
     * - availability.duration.type
     * - availability.duration.start
     * - availability.duration.end
     * - availability.duration.daysOfUse
     * If the course enrollment is self-enroll, all users can view the course as though they were enrolled.
     *
     * **Since**: 3400.8.0
     *
     * **Deprecated**: since 3800.1.0; use the v3 end-point instead
     */
    public static RestCall<CourseV2> getCourseV2(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<CourseV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Delete Course
     *
     * Deletes a course or organization in synchronous fashion.
     *
     * The 'system.course.DELETE' entitlement is needed to delete a course, while 'system.org.DELETE' is needed for an organization.
     *
     * **Since**: 3400.8.0
     *
     * **Deprecated**: since 3800.1.0; use the v3 end-point instead
     */
    public static RestCall<Void> deleteCourseV2(String courseId, DeleteCourseV2Option... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v2/courses/{courseId}")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class DeleteCourseV2Option extends RestCallOption {
        /*
         * Whether to delete course files.  Defaults to true.
         */
        public static DeleteCourseV2Option removeFiles(boolean removeFiles) {
            return parameter("removeFiles", removeFiles, new DeleteCourseV2Option());
        }
    }

    /*
     * Update Course
     *
     * Updates a course or organization.
     *
     * To update a course, the user must have either 'system.course|org.properties.MODIFY' or 'course.configure-properties.EXECUTE' entitlements.  However, if the user has the latter entitlement, then additional entitlements are needed to be able to update certain fields, as shown below:
     *
     *  | Field                           | Entitlements Required                                                  |
     *  |---------------------------------|------------------------------------------------------------------------|
     *  | name                            | course.name.MODIFY                                                     |
     *  | description                     | course.name.MODIFY                                                     |
     *  | allowGuests                     | course.configure-guest-access.EXECUTE                                  |
     *  | enrollment.type                 | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | enrollment.start                | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | enrollment.end                  | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | enrollment.accessCode           | course.configure-properties.EXECUTE, course.enrollment.MODIFY          |
     *  | availability.available          | course.configure-properties.EXECUTE, course.availability.MODIFY        |
     *  | locale.id                       | course.configure-properties.EXECUTE, course.locale.MODIFY              |
     *  | locale.force                    | course.configure-properties.EXECUTE, course.locale.MODIFY              |
     *  | availability.duration.type      | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *  | availability.duration.start     | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *  | availability.duration.end       | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *  | availability.duration.daysOfUse | course.configure-properties.EXECUTE, course.configure-duration.EXECUTE |
     *
     *
     * **Since**: 3400.8.0
     *
     * **Deprecated**: since 3800.1.0; use the v3 end-point instead
     */
    public static RestCall<CourseV2> updateCourseV2(String courseId, UpdateCourseV2Body input) {
        return RestCallBuilder
            .start(new TypeToken<CourseV2>() {})
            .patch()
            .url("/learn/api/public/v2/courses/{courseId}")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class UpdateCourseV2Body {
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
         * The name of the course.
         */
        private String name;

        /*
         * The description of the course.
         */
        private String description;

        /*
         * Whether guests (users with the role guest) are allowed access to the course. Defaults to true.
         */
        private boolean allowGuests;

        /*
         * This status does not affect availability of the course for viewing in any way. closedComplete is valid for both Ultra and Classic courses. If an Ultra course is in closedComplete mode, updates are not possible. For a Classic course in closedComplete mode, updates are still possible (through Web UI but not through REST i.e. closed is enforced for original courses when updated through REST the same way Ultra courses are blocked) but new notifications are not generated.
         */
        private boolean closedComplete;

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

        public static UpdateCourseV2Body create() {
            return new UpdateCourseV2Body();
        }

        public static class Availability {
            /*
             * Whether the course is currently available to students. Instructors can always access the course if they have 'Access unavailable course' entitlement. If set to 'Term', the course's parent term availability settings will be used.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the course. |
             * | No | Students may not access the course. |
             * | Disabled | Disabled by the SIS. Students may not access the course. @since 3100.0.0 |
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
                 * The intended length of the course. Possible values are:
                 *
                 * - Continuous: The course is active on an ongoing basis. This is the default.
                 * - DateRange: The course will only be available between specific date ranges.
                 * - FixedNumDays: The course will only be available for a set number of days.
                 * - Term: The course's parent term duration settings will be used.
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

                public Duration setType(Type type) {
                    this.type = type;
                    return this;
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
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

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
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

            public Enrollment setType(Type type) {
                this.type = type;
                return this;
            }

            public Enrollment setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Enrollment setEnd(Instant end) {
                this.end = end;
                return this;
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

            public Locale setId(String id) {
                this.id = id;
                return this;
            }

            public Locale setForce(boolean force) {
                this.force = force;
                return this;
            }
        }

        public UpdateCourseV2Body setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateCourseV2Body setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public UpdateCourseV2Body setName(String name) {
            this.name = name;
            return this;
        }

        public UpdateCourseV2Body setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateCourseV2Body setAllowGuests(boolean allowGuests) {
            this.allowGuests = allowGuests;
            return this;
        }

        public UpdateCourseV2Body setClosedComplete(boolean closedComplete) {
            this.closedComplete = closedComplete;
            return this;
        }

        public UpdateCourseV2Body setTermId(String termId) {
            this.termId = termId;
            return this;
        }

        public UpdateCourseV2Body setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateCourseV2Body setEnrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }

        public UpdateCourseV2Body setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }
    }
}
