package org.jbsmit.blackboardRestClient.model;


public class AttendanceRecord {
    /*
     * The primary ID of the attendance record.
     */
    private long id;

    /*
     * The primary id of the meeting.
     */
    private String meetingId;

    /*
     * The learn external id of the user.
     */
    private String userId;

    /*
     * The attendance status of the user.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Absent |  |
     * | Late |  |
     * | Present |  |
     * | Excused |  |
     *
     */
    private Status status;


    public enum Status {
        Absent,
        Late,
        Present,
        Excused
    }

    public long getId() {
        return id;
    }

    public AttendanceRecord setId(long id) {
        this.id = id;
        return this;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public AttendanceRecord setMeetingId(String meetingId) {
        this.meetingId = meetingId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AttendanceRecord setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public AttendanceRecord setStatus(Status status) {
        this.status = status;
        return this;
    }
}

