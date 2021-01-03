package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Announcement;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class AnnouncementsApi {
    /*
     * Get Announcements
     *
     * Return a list of System Announcements. Users with the 'system.announcements.VIEW' entitlement can view 'available' System Announcements. Users with the 'system.announcements.admin.VIEW' entitlement can view 'available' & 'unavailable' System Announcements.
     *
     * **Since**: 3100.7.0
     */
    public static RestCall<List<Announcement>> getAnnouncements() {
        return RestCallBuilder
            .start(new TypeToken<List<Announcement>>() {})
            .get()
            .url("/learn/api/public/v1/announcements")
            .build();
    }

    /*
     * Create Announcement
     *
     * Create a System Announcement. Users with the 'system.announcements.CREATE' entitlement can create System Announcements.
     *
     * **Since**: 3100.7.0
     */
    public static RestCall<Announcement> createAnnouncement(CreateAnnouncementBody input) {
        return RestCallBuilder
            .start(new TypeToken<Announcement>() {})
            .post()
            .url("/learn/api/public/v1/announcements")
            .body(input)
            .build();
    }

    public static class CreateAnnouncementBody {
        /*
         * The title of this System Announcement.
         */
        private String title;

        /*
         * The message body of the System Announcement. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * Settings controlling availability of the System Announcement.
         */
        private Availability availability;

        /*
         * Whether this System Announcement should be displayed on the login page.
         */
        private boolean showAtLogin;

        /*
         * Whether this System Announcement should be displayed on courses.
         */
        private boolean showInCourses;

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
                 * Indicates whether this System Announcement is always displayed (Permanent) or if it is shown only between the Start and End dates (Restricted).
                 *
                 *
                 * | Type      | Description
                 *  | --------- | --------- |
                 * | Permanent | The Announcement will always be displayed. |
                 * | Restricted | The Announcement will start being displayed on Duration.Start and stop being displayed on Duration.End |
                 *
                 */
                private Type type;

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

                public enum Type {
                    Permanent,
                    Restricted
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

        public CreateAnnouncementBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateAnnouncementBody setShowAtLogin(boolean showAtLogin) {
            this.showAtLogin = showAtLogin;
            return this;
        }

        public CreateAnnouncementBody setShowInCourses(boolean showInCourses) {
            this.showInCourses = showInCourses;
            return this;
        }
    }

    /*
     * Get Announcement
     *
     * Get a System Announcement. Users with the 'system.announcements.VIEW' entitlement can view 'available' System Announcements. Users with the 'system.announcements.admin.VIEW' entitlement can view 'available' & 'unavailable' System Announcements.
     *
     * **Since**: 3100.7.0
     */
    public static RestCall<Announcement> getAnnouncement(String announcementId) {
        return RestCallBuilder
            .start(new TypeToken<Announcement>() {})
            .get()
            .url("/learn/api/public/v1/announcements/{announcementId}")
            .pathParam("announcementId", announcementId)
            .build();
    }

    /*
     * Delete Announcement
     *
     * Delete a System Announcement. Users with the 'system.announcements.DELETE' entitlement can delete System Announcements.
     *
     * **Since**: 3100.7.0
     */
    public static RestCall<Void> deleteAnnouncement(String announcementId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/announcements/{announcementId}")
            .pathParam("announcementId", announcementId)
            .build();
    }

    /*
     * Update Announcement
     *
     * Update a System Announcement. Users with the 'system.announcements.MODIFY' entitlement can update System Announcements.
     *
     * **Since**: 3100.7.0
     */
    public static RestCall<Announcement> updateAnnouncement(String announcementId, UpdateAnnouncementBody input) {
        return RestCallBuilder
            .start(new TypeToken<Announcement>() {})
            .patch()
            .url("/learn/api/public/v1/announcements/{announcementId}")
            .pathParam("announcementId", announcementId)
            .body(input)
            .build();
    }

    public static class UpdateAnnouncementBody {
        /*
         * The title of this System Announcement.
         */
        private String title;

        /*
         * The message body of the System Announcement. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * Settings controlling availability of the System Announcement.
         */
        private Availability availability;

        /*
         * Whether this System Announcement should be displayed on the login page.
         */
        private boolean showAtLogin;

        /*
         * Whether this System Announcement should be displayed on courses.
         */
        private boolean showInCourses;

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
                 * Indicates whether this System Announcement is always displayed (Permanent) or if it is shown only between the Start and End dates (Restricted).
                 *
                 *
                 * | Type      | Description
                 *  | --------- | --------- |
                 * | Permanent | The Announcement will always be displayed. |
                 * | Restricted | The Announcement will start being displayed on Duration.Start and stop being displayed on Duration.End |
                 *
                 */
                private Type type;

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

                public enum Type {
                    Permanent,
                    Restricted
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

        public UpdateAnnouncementBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateAnnouncementBody setShowAtLogin(boolean showAtLogin) {
            this.showAtLogin = showAtLogin;
            return this;
        }

        public UpdateAnnouncementBody setShowInCourses(boolean showInCourses) {
            this.showInCourses = showInCourses;
            return this;
        }
    }
}
