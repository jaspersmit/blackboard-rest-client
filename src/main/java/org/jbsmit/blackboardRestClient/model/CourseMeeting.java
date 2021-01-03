package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CourseMeeting {
    /*
     * The primary ID of the meeting.
     */
    private long id;

    /*
     * The primary ID of the course.
     */
    private String courseId;

    /*
     * The title of the meeting
     */
    private String title;

    /*
     * The description of the meeting
     */
    private String description;

    /*
     * The start time of meeting
     */
    private Instant start;

    /*
     * The end time of meeting
     */
    private Instant end;

    /*
     * The externalLink of course meeting
     */
    private String externalLink;


    public long getId() {
        return id;
    }

    public CourseMeeting setId(long id) {
        this.id = id;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public CourseMeeting setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CourseMeeting setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CourseMeeting setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getStart() {
        return start;
    }

    public CourseMeeting setStart(Instant start) {
        this.start = start;
        return this;
    }

    public Instant getEnd() {
        return end;
    }

    public CourseMeeting setEnd(Instant end) {
        this.end = end;
        return this;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public CourseMeeting setExternalLink(String externalLink) {
        this.externalLink = externalLink;
        return this;
    }
}

