package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.AttendanceDataDownloadUrl;
import org.jbsmit.blackboardRestClient.model.AttendanceRecord;
import org.jbsmit.blackboardRestClient.model.CourseMeeting;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class AttendanceApi {
    /*
     * Get Course Meetings
     *
     * Returns a list of course meetings for a given course id.
     *
     * The "course.attendance.VIEW" entitlement is required to view a Course Meeting.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<List<CourseMeeting>> getCourseMeetings(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseMeeting>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/meetings")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Create Course Meeting
     *
     * Creates a new Course Meeting within the provided Course/Organization Id. An attendance grade book column will automatically be generated if one does not exist.
     *
     * The "course.attendance.CREATE" entitlement is required to create a Course Meeting.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<CourseMeeting> createCourseMeeting(String courseId, CreateCourseMeetingBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseMeeting>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/meetings")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateCourseMeetingBody {
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

        public static CreateCourseMeetingBody create() {
            return new CreateCourseMeetingBody();
        }

        public CreateCourseMeetingBody setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public CreateCourseMeetingBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateCourseMeetingBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateCourseMeetingBody setStart(Instant start) {
            this.start = start;
            return this;
        }

        public CreateCourseMeetingBody setEnd(Instant end) {
            this.end = end;
            return this;
        }

        public CreateCourseMeetingBody setExternalLink(String externalLink) {
            this.externalLink = externalLink;
            return this;
        }
    }

    /*
     * Delete All Meetings In Course
     *
     * Deletes all course meetings in the course for the given course Id.
     *
     * The 'course.attendance.DELETE' entitlement is required to delete Course Meetings.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> deleteAllMeetingsInCourse(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/meetings")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Generate Attendance Data Download Url
     *
     * Generate Download URL for Attendance Data.
     *
     * The "course.attendance.CREATE" entitlement is required to generate download URL for attendance data.
     *
     * **Since**: ????
     */
    public static RestCall<AttendanceDataDownloadUrl> generateAttendanceDataDownloadUrl(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<AttendanceDataDownloadUrl>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/downloadUrl")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Get Attendance Records By User Id
     *
     * Returns a list of Course Meeting Attendance for a given user id regardless of courses and meetings.
     *
     * The "course.attendance.VIEW" entitlement is required to view a Course Meeting attendance.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<List<AttendanceRecord>> getAttendanceRecordsByUserId(String courseId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<List<AttendanceRecord>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Delete All Attendance Records By Course And User Id
     *
     * Deletes all attendance records for the user in specific course.
     *
     * The 'course.attendance.DELETE' entitlement is required to delete attendance records.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> deleteAllAttendanceRecordsByCourseAndUserId(String courseId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Delete All Attendance By User Id
     *
     * Deletes all attendance records for the user. It will delete meeting attendance regardless of course.
     *
     * The 'course.attendance.DELETE' entitlement is required to delete attendance records.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> deleteAllAttendanceByUserId(String courseId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/users/{userId}/all")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Get Course Meeting
     *
     * Returns a Course Meeting for the given meeting Id.
     *
     * The "course.attendance.VIEW" entitlement is required to view a Course Meeting.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<CourseMeeting> getCourseMeeting(String courseId, String meetingId) {
        return RestCallBuilder
            .start(new TypeToken<CourseMeeting>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .build();
    }

    /*
     * Delete Course Meeting
     *
     * Delete the Course Meeting for the given course meeting Id.
     *
     * The 'course.attendance.DELETE' entitlement is required to delete Course Meetings.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> deleteCourseMeeting(String courseId, String meetingId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .build();
    }

    /*
     * Update Course Meeting
     *
     * Update the Course Meeting for the given Course/Organization.
     *
     * The "course.attendance.MODIFY" entitlement is required to update a Course Meeting. The "course.attendance.VIEW" entitlement is required to view a Course Meeting.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<CourseMeeting> updateCourseMeeting(String courseId, String meetingId, UpdateCourseMeetingBody input) {
        return RestCallBuilder
            .start(new TypeToken<CourseMeeting>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .body(input)
            .build();
    }

    public static class UpdateCourseMeetingBody {
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

        public static UpdateCourseMeetingBody create() {
            return new UpdateCourseMeetingBody();
        }

        public UpdateCourseMeetingBody setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public UpdateCourseMeetingBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateCourseMeetingBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateCourseMeetingBody setStart(Instant start) {
            this.start = start;
            return this;
        }

        public UpdateCourseMeetingBody setEnd(Instant end) {
            this.end = end;
            return this;
        }

        public UpdateCourseMeetingBody setExternalLink(String externalLink) {
            this.externalLink = externalLink;
            return this;
        }
    }

    /*
     * Get Attendance Records By Meeting Id
     *
     * Returns a list of Course Meeting Attendance for a given meeting id.
     *
     * The "course.attendance.VIEW" entitlement is required to view a Course Meeting attendance.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<List<AttendanceRecord>> getAttendanceRecordsByMeetingId(String courseId, String meetingId) {
        return RestCallBuilder
            .start(new TypeToken<List<AttendanceRecord>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .build();
    }

    /*
     * Create Attendance Record
     *
     * Creates a new Course Meeting Attendance within the provided Course/Organization Id.
     *
     * The "course.attendance.CREATE" entitlement is required to create a Course Meeting Attendance.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<AttendanceRecord> createAttendanceRecord(String courseId, String meetingId, CreateAttendanceRecordBody input) {
        return RestCallBuilder
            .start(new TypeToken<AttendanceRecord>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .body(input)
            .build();
    }

    public static class CreateAttendanceRecordBody {
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

        public static CreateAttendanceRecordBody create() {
            return new CreateAttendanceRecordBody();
        }

        public enum Status {
            Absent,
            Late,
            Present,
            Excused
        }

        public CreateAttendanceRecordBody setMeetingId(String meetingId) {
            this.meetingId = meetingId;
            return this;
        }

        public CreateAttendanceRecordBody setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public CreateAttendanceRecordBody setStatus(Status status) {
            this.status = status;
            return this;
        }
    }

    /*
     * Delete All Records In Meeting
     *
     * Deletes all attendance records in the course meeting for a given meeting Id.
     *
     * The 'course.attendance.DELETE' entitlement is required to delete attendance records.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> deleteAllRecordsInMeeting(String courseId, String meetingId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .build();
    }

    /*
     * Update Attendance Records
     *
     * Creates or updates attendance records for the meeting for all users in the course.
     *
     * User required both of the entitlements below. If the user does not have the required entitlements,no records are created or modified.  Entitlement | User Access ------------|-----------  course.attendance.CREATE | Create Course/Organization Course Meeting Attendance course.attendance.MODIFY | Update Course/Organization Meeting Attendance
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> updateAttendanceRecords(String courseId, String meetingId, UpdateAttendanceRecordsBody input) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users/bulk")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .body(input)
            .build();
    }

    public static class UpdateAttendanceRecordsBody {
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

        public static UpdateAttendanceRecordsBody create() {
            return new UpdateAttendanceRecordsBody();
        }

        public enum Status {
            Absent,
            Late,
            Present,
            Excused
        }

        public UpdateAttendanceRecordsBody setMeetingId(String meetingId) {
            this.meetingId = meetingId;
            return this;
        }

        public UpdateAttendanceRecordsBody setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UpdateAttendanceRecordsBody setStatus(Status status) {
            this.status = status;
            return this;
        }
    }

    /*
     * Get Attendance Record
     *
     * Returns a Course Meeting Attendance information for the given meeting and user Id.
     *
     * The "course.attendance.VIEW" entitlement is required to view a Course Meeting Attendance.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<AttendanceRecord> getAttendanceRecord(String courseId, String meetingId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<AttendanceRecord>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Delete Attendance Record
     *
     * Delete attendance record for meeting.It will delete meeting attendance within a course meeting.
     *
     * The 'course.attendance.DELETE' entitlement is required to delete Attendance Record.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<Void> deleteAttendanceRecord(String courseId, String meetingId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Update Attendance Record
     *
     * Update the Course Meeting Attendance data for the given Course/Organization.
     *
     * The "course.attendance.MODIFY" entitlement is required to update a Course Meeting Attendance. The "course.attendance.VIEW" entitlement is required to view a Course Meeting attendance.
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<AttendanceRecord> updateAttendanceRecord(String courseId, String meetingId, String userId, UpdateAttendanceRecordBody input) {
        return RestCallBuilder
            .start(new TypeToken<AttendanceRecord>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/meetings/{meetingId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("meetingId", meetingId)
            .pathParam("userId", userId)
            .body(input)
            .build();
    }

    public static class UpdateAttendanceRecordBody {
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

        public static UpdateAttendanceRecordBody create() {
            return new UpdateAttendanceRecordBody();
        }

        public enum Status {
            Absent,
            Late,
            Present,
            Excused
        }

        public UpdateAttendanceRecordBody setMeetingId(String meetingId) {
            this.meetingId = meetingId;
            return this;
        }

        public UpdateAttendanceRecordBody setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UpdateAttendanceRecordBody setStatus(Status status) {
            this.status = status;
            return this;
        }
    }
}
