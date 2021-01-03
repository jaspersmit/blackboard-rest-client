package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CourseAnnouncement {
    /*
     * Primary key identifier
     */
    private String id;

    /*
     * The title of this Announcement.
     */
    private String title;

    /*
     * The message body of the Announcement. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
     */
    private String body;

    /*
     * The user that created the Announcement.
     */
    private String creator;

    /*
     * An indication of whether or not the Announcement is in draft status.
     */
    private boolean draft;

    /*
     * Settings controlling availability of the course to students.
     */
    private Availability availability;

    /*
     * The date that the Announcement was created.
     */
    private Instant created;

    private Instant modified;

    /*
     * The number of users that the Announcement will reach.
     *
     * Shown when adding the query parameter: "expand=readCount".
     */
    private int participants;

    /*
     * The position of the Announcement.
     */
    private int position;

    /*
     * The number of reads for the Announcement.
     *
     * Shown when adding the query parameter: "expand=readCount".
     */
    private int readCount;


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
             * Indicates whether this Course Announcement is always displayed (Permanent) or if it is shown only between the Start and End dates (Restricted).
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

    public CourseAnnouncement setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CourseAnnouncement setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public CourseAnnouncement setBody(String body) {
        this.body = body;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public CourseAnnouncement setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public boolean getDraft() {
        return draft;
    }

    public CourseAnnouncement setDraft(boolean draft) {
        this.draft = draft;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public CourseAnnouncement setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public CourseAnnouncement setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public CourseAnnouncement setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public int getParticipants() {
        return participants;
    }

    public CourseAnnouncement setParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public CourseAnnouncement setPosition(int position) {
        this.position = position;
        return this;
    }

    public int getReadCount() {
        return readCount;
    }

    public CourseAnnouncement setReadCount(int readCount) {
        this.readCount = readCount;
        return this;
    }
}

