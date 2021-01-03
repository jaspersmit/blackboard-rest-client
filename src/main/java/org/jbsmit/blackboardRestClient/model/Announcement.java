package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class Announcement {
    /*
     * Primary key identifier
     */
    private String id;

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

    /*
     * The date that the System Announcement was created.
     */
    private Instant created;

    private Instant modified;


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
        }

        public Duration getDuration() {
            return duration;
        }

        public Availability setDuration(Duration duration) {
            this.duration = duration;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public Announcement setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Announcement setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Announcement setBody(String body) {
        this.body = body;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Announcement setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public boolean getShowAtLogin() {
        return showAtLogin;
    }

    public Announcement setShowAtLogin(boolean showAtLogin) {
        this.showAtLogin = showAtLogin;
        return this;
    }

    public boolean getShowInCourses() {
        return showInCourses;
    }

    public Announcement setShowInCourses(boolean showInCourses) {
        this.showInCourses = showInCourses;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Announcement setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public Announcement setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}

