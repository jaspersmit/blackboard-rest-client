package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.CourseAnnouncement;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CourseAnnouncementsApi {
    /*
     * Get Announcements
     *
     * Return a list of Course Announcements. Users with the 'course.announcements.VIEW' entitlement can view 'available' Course Announcements. Users with the 'course.announcements.VIEW' & 'course.announcements.MODIFY' entitlement can view 'available' & 'unavailable' Course Announcements.
     *
     * **Since**: 3500.3.0
     */
    public static RestCall<List<CourseAnnouncement>> getAnnouncements(String courseId, GetAnnouncementsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseAnnouncement>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/announcements")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetAnnouncementsOption extends RestCallOption {
        /*
         * Search for announcements with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3500.3.0
         */
        public static GetAnnouncementsOption created(Instant created) {
            return parameter("created", created, new GetAnnouncementsOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Defaults to greaterOrEqual if not specified. 'lessThan' also an accepted value.
         *
         * **Since**: 3500.3.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetAnnouncementsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetAnnouncementsOption());
        }

        /*
         * Search for announcements with a modified date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3500.3.0
         */
        public static GetAnnouncementsOption modified(Instant modified) {
            return parameter("modified", modified, new GetAnnouncementsOption());
        }

        /*
         * Used alongside the 'modified' search parameter. Defaults to greaterOrEqual if not specified. 'lessThan' also an accepted value.
         *
         * **Since**: 3500.3.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetAnnouncementsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetAnnouncementsOption());
        }

        /*
         * Search for announcements with a title like the provided value.
         *
         * **Since**: 3500.3.0
         */
        public static GetAnnouncementsOption title(String title) {
            return parameter("title", title, new GetAnnouncementsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "title(desc),created" Supported fields are:
         *
         * - title
         * - modified
         *
         * **Since**: 3500.3.0
         */
        public static GetAnnouncementsOption sort(String sort) {
            return parameter("sort", sort, new GetAnnouncementsOption());
        }
    }

    /*
     * Create Announcement
     *
     * Create a Course Announcement. Users with the 'course.announcements.CREATE' and 'course.announcements.VIEW' entitlements can create Course Announcements.
     *
     * **Since**: 3500.3.0
     */
    public static RestCall<CourseAnnouncement> createAnnouncement(CreateAnnouncementBody input, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<CourseAnnouncement>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/announcements")
            .body(input)
            .pathParam("courseId", courseId)
            .build();
    }

    public static class CreateAnnouncementBody {
        /*
         * The title of this Announcement.
         */
        private String title;

        /*
         * The message body of the Announcement. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * An indication of whether or not the Announcement is in draft status.
         */
        private boolean draft;

        /*
         * Settings controlling availability of the course to students.
         */
        private Availability availability;

        public static CreateAnnouncementBody create() {
            return new CreateAnnouncementBody();
        }

        public static class Availability {
            /*
             * Duration indicates when the System Announcement is Available based on whether it is Permanent or if the date/time of the request falls within its Start & End dates.
             */
            private Duration duration;

            public static Availability create() {
                return new Availability();
            }

            public static class Duration {
                /*
                 * The date this Announcement starts being Available.
                 */
                private Instant start;

                /*
                 * The date this Announcement stops being Available.
                 */
                private Instant end;

                public static Duration create() {
                    return new Duration();
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
                }
            }

            public Availability setDuration(Duration duration) {
                this.duration = duration;
                return this;
            }
        }

        public CreateAnnouncementBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateAnnouncementBody setBody(String body) {
            this.body = body;
            return this;
        }

        public CreateAnnouncementBody setDraft(boolean draft) {
            this.draft = draft;
            return this;
        }

        public CreateAnnouncementBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }
    }

    /*
     * Get Announcement
     *
     * Get a Course Announcement. Users with the 'course.announcements.VIEW' entitlement can view 'available' Course Announcements. Users with the 'course.announcements.VIEW' & 'course.announcements.MODIFY' entitlement can view 'available' & 'unavailable' Course Announcements.
     *
     * **Since**: 3500.3.0
     */
    public static RestCall<CourseAnnouncement> getAnnouncement(String announcementId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<CourseAnnouncement>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/announcements/{announcementId}")
            .pathParam("announcementId", announcementId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Delete Announcement
     *
     * Delete a Course Announcement. Users with the 'course.announcements.DELETE' and 'course.announcements.VIEW' entitlements can delete Course Announcements.
     *
     * **Since**: 3500.3.0
     */
    public static RestCall<Void> deleteAnnouncement(String announcementId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/announcements/{announcementId}")
            .pathParam("announcementId", announcementId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Update Announcement
     *
     * Update a Course Announcement. Users with the 'course.announcements.MODIFY' and 'course.announcements.VIEW' entitlements can update Course Announcements.
     *
     * **Since**: 3500.3.0
     */
    public static RestCall<CourseAnnouncement> updateAnnouncement(String announcementId, String courseId, UpdateAnnouncementBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseAnnouncement>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/announcements/{announcementId}")
            .pathParam("announcementId", announcementId)
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class UpdateAnnouncementBody {
        /*
         * The title of this Announcement.
         */
        private String title;

        /*
         * The message body of the Announcement. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * An indication of whether or not the Announcement is in draft status.
         */
        private boolean draft;

        /*
         * Settings controlling availability of the course to students.
         */
        private Availability availability;

        public static UpdateAnnouncementBody create() {
            return new UpdateAnnouncementBody();
        }

        public static class Availability {
            /*
             * Duration indicates when the System Announcement is Available based on whether it is Permanent or if the date/time of the request falls within its Start & End dates.
             */
            private Duration duration;

            public static Availability create() {
                return new Availability();
            }

            public static class Duration {
                /*
                 * The date this Announcement starts being Available.
                 */
                private Instant start;

                /*
                 * The date this Announcement stops being Available.
                 */
                private Instant end;

                public static Duration create() {
                    return new Duration();
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
                }
            }

            public Availability setDuration(Duration duration) {
                this.duration = duration;
                return this;
            }
        }

        public UpdateAnnouncementBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateAnnouncementBody setBody(String body) {
            this.body = body;
            return this;
        }

        public UpdateAnnouncementBody setDraft(boolean draft) {
            this.draft = draft;
            return this;
        }

        public UpdateAnnouncementBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }
    }
}
