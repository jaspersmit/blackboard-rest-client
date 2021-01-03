package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.CourseChild;
import org.jbsmit.blackboardRestClient.model.CourseIdParam;
import org.jbsmit.blackboardRestClient.model.CourseTask;
import org.jbsmit.blackboardRestClient.model.CourseV2;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CoursesApi {
    /*
     * Get Course Children
     *
     * Returns a list of course cross-listings.
     *
     * The 'system.course.cross-list.VIEW' or 'system.org.cross-list.VIEW' or 'course.children.VIEW' entitlement is needed.
     *
     * **Since**: 3000.11.0
     */
    public static RestCall<List<CourseChild>> getCourseChildren(String courseId, GetCourseChildrenOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseChild>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/children")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetCourseChildrenOption extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>childCourse</li></ul>
         */
        public static GetCourseChildrenOption expand(String expand) {
            return parameter("expand", expand, new GetCourseChildrenOption());
        }
    }

    /*
     * Get Child
     *
     * Loads a specific course cross-listing.
     *
     * The 'system.course.cross-list.VIEW' or 'system.org.cross-list.VIEW' entitlement is needed.
     *
     * **Since**: 3000.11.0
     */
    public static RestCall<CourseChild> getChild(String courseId, String childCourseId) {
        return RestCallBuilder
            .start(new TypeToken<CourseChild>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/children/{childCourseId}")
            .pathParam("courseId", courseId)
            .pathParam("childCourseId", childCourseId)
            .build();
    }

    /*
     * Add Child Course
     *
     * Merges two courses (or organizations) together. Commonly referred to as cross-listing. Only a single level of parent/child relationship is supported (ie. Parent courses may not become children, similarly, a child cannot become a parent)
     *
     * Minimal entitlements required:
     *
     * - For courses: 'system.course.cross-list.VIEW'
     * - For organizations: 'system.org.cross-list.VIEW'
     *
     * Upon being merged, all enrollments in the child course are replicated in the parent course, and any future enrollment changes in the child course are also synchronized automatically with the parent course. Duplicate student enrollments will result in a 409 CONFLICT unless the 'ignoreEnrollmentErrors' query parameter is set to true. Users in other roles, such as grader, teaching assistant, or guest, are assigned roles based on the last time they are added to the parent course.
     *
     * **Since**: 3400.1.0
     */
    public static RestCall<CourseChild> addChildCourse(String courseId, String childCourseId) {
        return RestCallBuilder
            .start(new TypeToken<CourseChild>() {})
            .put()
            .url("/learn/api/public/v1/courses/{courseId}/children/{childCourseId}")
            .pathParam("courseId", courseId)
            .pathParam("childCourseId", childCourseId)
            .build();
    }

    /*
     * Get Cross List Set
     *
     * Returns the course cross-listing set for the specified course. This will return any and all parent/child associations regardless of the specified course being a parent or child course. The result will be empty if the specified course is not cross-listed.
     *
     * The 'system.course.cross-list.VIEW' or 'system.org.cross-list.VIEW' entitlement is needed.
     *
     * **Since**: 3400.1.0
     */
    public static RestCall<List<CourseChild>> getCrossListSet(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseChild>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/crossListSet")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Get Task
     *
     * Check the status of a queued task associated with a Course. Returns 200 unless task is complete. If task is complete this endpoint will return a 303 SEE OTHER with a Location header providing a URI to the GET Course endpoint. Statistical data shows that the average copy task duration is under a second. However, very large courses can take several minutes. Also important to note is that these background tasks can potentially be queued behind other system tasks therefore prolonging the time a task stays in the `Queued` status. We recommend that this endpoint be polled every 60 seconds while waiting for a Course copy to complete.
     *
     * Users with entitlements 'system.course.copy.EXECUTE' can view the task status.
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<CourseTask> getTask(String courseId, String taskId) {
        return RestCallBuilder
            .start(new TypeToken<CourseTask>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/tasks/{taskId}")
            .pathParam("courseId", courseId)
            .pathParam("taskId", taskId)
            .build();
    }

    /*
     * Copy Course
     *
     * Creates a copy of an existing Course into a new Course or an existing course. It is possible to limit the course content to be copied using options.
     *
     * Users with entitlements 'system.course.copy.EXECUTE' can create a course copy. Users with entitlements 'system.org.copy.EXECUTE' can create an organization copy. Users with entitlement 'course.content.copy.exact.EXECUTE' can copy Course/Organization materials to a new or existing course Users with entitlement 'course.content.copy.new.EXECUTE' can copy Course/Organization materials to a new course. All users's must also have 'course.content.copy.EXECUTE' entitlement associated with the specified source courseId.
     *
     * **Since**: 3800.2.0
     */
    public static RestCall<Void> copyCourse(CopyCourseBody copyRequest, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .post()
            .url("/learn/api/public/v2/courses/{courseId}/copy")
            .body(copyRequest)
            .pathParam("courseId", courseId)
            .build();
    }

    public static class CopyCourseBody {
        /*
         * The destination course to copy into. This can be either a new course, defined by the courseId field, or an existing course, defined by the id field.
         */
        private TargetCourseV2 targetCourse;

        /*
         * The options which will be used when copying the specified course
         */
        private CopyV2 copy;

        public static CopyCourseBody create() {
            return new CopyCourseBody();
        }

        public static class TargetCourseV2 {
            /*
             * The CourseId that will represent the new course.
             */
            private String courseId;

            /*
             * An identifier representing an existing course to be copied into.
             */
            private CourseIdParam id;

            public static TargetCourseV2 create() {
                return new TargetCourseV2();
            }

            public TargetCourseV2 setCourseId(String courseId) {
                this.courseId = courseId;
                return this;
            }

            public TargetCourseV2 setId(CourseIdParam id) {
                this.id = id;
                return this;
            }
        }

        public static class CopyV2 {
            /*
             * Represents whether or not the adaptive release rules will be copied.
             */
            private boolean adaptiveReleaseRules;

            /*
             * Represents whether or not the announcements will be copied.
             */
            private boolean announcements;

            /*
             * Represents whether or not the assessments will be copied.
             */
            private boolean assessments;

            /*
             * Represents whether or not the blogs will be copied.
             */
            private boolean blogs;

            /*
             * Represents whether or not the calendar will be copied.
             */
            private boolean calendar;

            /*
             * Represents whether or not the contacts information will be copied.
             */
            private boolean contacts;

            /*
             * Represents whether or not the content alignments will be copied.
             */
            private boolean contentAlignments;

            /*
             * Represents whether or not the content areas will be copied.
             */
            private boolean contentAreas;

            /*
             * Represents whether and how to copy the discussion forum
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | None | Discussion board will not be copied |
             * | ForumsAndStarterPosts | Discussion board with Formus and starter posts will be copied |
             * | ForumsOnly | Discussion board with only forums will be copied |
             *
             */
            private Discussions discussions;

            /*
             * Represents whether or not the glossary will be copied.
             */
            private boolean glossary;

            /*
             * Represents whether or not the grade book, columns and settings will be copied.
             */
            private boolean gradebook;

            /*
             * Represents whether or not the group settings will be copied.
             */
            private boolean groupSettings;

            /*
             * Represents whether or not the journals will be copied.
             */
            private boolean journals;

            /*
             * Represents whether or not the retention rules will be copied.
             */
            private boolean retentionRules;

            /*
             * Represents whether or not the rubrics will be copied.
             */
            private boolean rubrics;

            /*
             * The course settings to be copied
             */
            private SettingsCopyOptionsV2 settings;

            /*
             * Represents whether or not the tasks will be copied.
             */
            private boolean tasks;

            /*
             * Represents whether or not the wikis will be copied.
             */
            private boolean wikis;

            public static CopyV2 create() {
                return new CopyV2();
            }

            public static class SettingsCopyOptionsV2 {
                /*
                 * Represents whether or not the Availability setting will be copied.
                 */
                private boolean availability;

                /*
                 * Represents whether or not the banner image will be copied.
                 */
                private boolean bannerImage;

                /*
                 * Represents whether or not the duration settings will be copied.
                 */
                private boolean duration;

                /*
                 * Represents whether or not the enrollment options will be copied.
                 */
                private boolean enrollmentOptions;

                /*
                 * Represents whether or not the guest access settings will be copied.
                 */
                private boolean guestAccess;

                /*
                 * Represents whether or not the languange packs will be copied.
                 */
                private boolean languagePack;

                /*
                 * Represents whether or not the navigation settings will be copied.
                 */
                private boolean navigationSettings;

                /*
                 * Represents whether or not the observer access settings will be copied.
                 */
                private boolean observerAccess;

                public static SettingsCopyOptionsV2 create() {
                    return new SettingsCopyOptionsV2();
                }

                public SettingsCopyOptionsV2 setAvailability(boolean availability) {
                    this.availability = availability;
                    return this;
                }

                public SettingsCopyOptionsV2 setBannerImage(boolean bannerImage) {
                    this.bannerImage = bannerImage;
                    return this;
                }

                public SettingsCopyOptionsV2 setDuration(boolean duration) {
                    this.duration = duration;
                    return this;
                }

                public SettingsCopyOptionsV2 setEnrollmentOptions(boolean enrollmentOptions) {
                    this.enrollmentOptions = enrollmentOptions;
                    return this;
                }

                public SettingsCopyOptionsV2 setGuestAccess(boolean guestAccess) {
                    this.guestAccess = guestAccess;
                    return this;
                }

                public SettingsCopyOptionsV2 setLanguagePack(boolean languagePack) {
                    this.languagePack = languagePack;
                    return this;
                }

                public SettingsCopyOptionsV2 setNavigationSettings(boolean navigationSettings) {
                    this.navigationSettings = navigationSettings;
                    return this;
                }

                public SettingsCopyOptionsV2 setObserverAccess(boolean observerAccess) {
                    this.observerAccess = observerAccess;
                    return this;
                }
            }

            public enum Discussions {
                None,
                ForumsAndStarterPosts,
                ForumsOnly
            }

            public CopyV2 setAdaptiveReleaseRules(boolean adaptiveReleaseRules) {
                this.adaptiveReleaseRules = adaptiveReleaseRules;
                return this;
            }

            public CopyV2 setAnnouncements(boolean announcements) {
                this.announcements = announcements;
                return this;
            }

            public CopyV2 setAssessments(boolean assessments) {
                this.assessments = assessments;
                return this;
            }

            public CopyV2 setBlogs(boolean blogs) {
                this.blogs = blogs;
                return this;
            }

            public CopyV2 setCalendar(boolean calendar) {
                this.calendar = calendar;
                return this;
            }

            public CopyV2 setContacts(boolean contacts) {
                this.contacts = contacts;
                return this;
            }

            public CopyV2 setContentAlignments(boolean contentAlignments) {
                this.contentAlignments = contentAlignments;
                return this;
            }

            public CopyV2 setContentAreas(boolean contentAreas) {
                this.contentAreas = contentAreas;
                return this;
            }

            public CopyV2 setDiscussions(Discussions discussions) {
                this.discussions = discussions;
                return this;
            }

            public CopyV2 setGlossary(boolean glossary) {
                this.glossary = glossary;
                return this;
            }

            public CopyV2 setGradebook(boolean gradebook) {
                this.gradebook = gradebook;
                return this;
            }

            public CopyV2 setGroupSettings(boolean groupSettings) {
                this.groupSettings = groupSettings;
                return this;
            }

            public CopyV2 setJournals(boolean journals) {
                this.journals = journals;
                return this;
            }

            public CopyV2 setRetentionRules(boolean retentionRules) {
                this.retentionRules = retentionRules;
                return this;
            }

            public CopyV2 setRubrics(boolean rubrics) {
                this.rubrics = rubrics;
                return this;
            }

            public CopyV2 setSettings(SettingsCopyOptionsV2 settings) {
                this.settings = settings;
                return this;
            }

            public CopyV2 setTasks(boolean tasks) {
                this.tasks = tasks;
                return this;
            }

            public CopyV2 setWikis(boolean wikis) {
                this.wikis = wikis;
                return this;
            }
        }

        public CopyCourseBody setTargetCourse(TargetCourseV2 targetCourse) {
            this.targetCourse = targetCourse;
            return this;
        }

        public CopyCourseBody setCopy(CopyV2 copy) {
            this.copy = copy;
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
     * **Since**: 3800.1.0
     */
    public static RestCall<List<CourseV2>> getCourses(GetCoursesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseV2>>() {})
            .get()
            .url("/learn/api/public/v3/courses")
            .options(options)
            .build();
    }

    public static class GetCoursesOption extends RestCallOption {
        /*
         * Search for courses with a modified date relative to this value.  'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3500.4.0
         */
        public static GetCoursesOption modified(Instant modified) {
            return parameter("modified", modified, new GetCoursesOption());
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
        public static GetCoursesOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetCoursesOption());
        }

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
         * - modified
         *
         * **Since**: 3400.8.0
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
     * **Since**: 3800.1.0
     */
    public static RestCall<CourseV2> createCourse(CreateCourseBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseV2>() {})
            .post()
            .url("/learn/api/public/v3/courses")
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

        public CreateCourseBody setClosedComplete(boolean closedComplete) {
            this.closedComplete = closedComplete;
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
     * **Since**: 3800.1.0
     */
    public static RestCall<CourseV2> getCourse(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<CourseV2>() {})
            .get()
            .url("/learn/api/public/v3/courses/{courseId}")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Delete Course
     *
     * Registers a queued task to delete a course or organization in asynchronous fashion.
     *
     * The 'system.course.DELETE' entitlement is needed to delete a course, while 'system.org.DELETE' is needed for an organization.
     *
     * **Since**: 3800.1.0
     */
    public static RestCall<Void> deleteCourse(String courseId, DeleteCourseOption... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v3/courses/{courseId}")
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
     * **Since**: 3800.1.0
     */
    public static RestCall<CourseV2> updateCourse(String courseId, UpdateCourseBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseV2>() {})
            .patch()
            .url("/learn/api/public/v3/courses/{courseId}")
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

        public UpdateCourseBody setClosedComplete(boolean closedComplete) {
            this.closedComplete = closedComplete;
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
}
