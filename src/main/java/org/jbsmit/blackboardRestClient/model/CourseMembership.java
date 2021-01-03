package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CourseMembership {
    /*
     * The unique ID of this course/user relationship.
     *
     * **Since**: 3700.14.0
     */
    private String id;

    /*
     * The primary ID of the user.
     */
    private String userId;

    /*
     * The user associated with the membership.
     *
     * Shown when adding the query parameter: "expand=user". And can be filtered with the "fields" query parameter, for example "fields=user.uuid,user.externalId".
     *
     * **Since**: 3400.7.0
     */
    private User user;

    /*
     * The primary ID of the course.
     */
    private String courseId;

    /*
     * The primary ID of the child, cross-listed course, in which the user is directly enrolled. </p> This field is read only in Learn versions 3000.11.0 through 3400.0.0. As of 3400.1.0, this field is mutable.  </p> If this membership's course is a parent course in a cross-listed set, the childCourseId can be updated to move the membership enrollment between child courses and the parent course in  the set.  Patching the childCourseId to "null" will move the membership to the parent course.
     *
     * **Since**: 3000.11.0
     */
    private String childCourseId;

    /*
     * The ID of the data source associated with this course.  This may optionally be the data source's externalId using the syntax "externalId:math101".
     */
    private String dataSourceId;

    /*
     * The date this membership was created.
     */
    private Instant created;

    /*
     * The date this membership was modified.  A membership is considered modified only if an aspect of the membership itself changes (e.g.: availability or courseRoleId), and not if the Course or User alone is modified.
     *
     * **Since**: 3800.8.0
     */
    private Instant modified;

    /*
     * Settings controlling availability of the course membership.
     */
    private Availability availability;

    /*
     * The user's role in the course.
     *
     * These roles are also valid for an organization, although they are named differently in the UI.
     *
     * Custom course roles may also be referenced by their IDs.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Instructor | Has access to all areas in the Control Panel. This role is generally given to those developing, teaching, or facilitating the class. Instructors may access a course that is unavailable to students. This role is customizable and may have different capabilities from what is documented here. |
     * | BbFacilitator | The facilitator is an instructor like role. Facilitators are restricted versions of an instructor, in that they are able to deliver course instruction and administer all aspects of a pre-constructed course, but are not allowed to modify or alter the course. This role is customizable and may have different capabilities from what is documented here. |
     * | TeachingAssistant | The teaching assistant role is that of a co-teacher. Teaching assistants are able to administer all areas of a course. Their only limitations are those imposed by the instructor or Blackboard administrator at your school. This role is customizable and may have different capabilities from what is documented here. |
     * | CourseBuilder | Manages the course without having access to student grades. This role is customizable and may have different capabilities from what is documented here. |
     * | Grader | Assists the instructor in the creation, management, delivery, and grading of items. This role is customizable and may have different capabilities from what is documented here. |
     * | Student |  |
     * | Guest | Has no access to the Control Panel. Areas within the course are made available to guests, but typically they can only view course materials; they do not have access to tests or assessments, and do not have permission to post on discussion boards. This role's behavior is immutable. |
     *
     */
    private CourseRoleId courseRoleId;

    /*
     * If present, this date signals that the user associated with this membership has special access to the course regardless of the course's availability setting prior to the moment specified by this field. After the date has passed, the membership will respect the course's availability.
     */
    private Instant bypassCourseAvailabilityUntil;

    /*
     * This date signals the date this membership was used; in other words, the last date the user accessed the associated course or content contained by that course.
     *
     * The recording of any activity which would lead to this date getting updated does happen asynchronously in batches. So, there may be some delay between an activity which would update this value and the availability of the new date. It is recommended when using this value to note that activity within the last 5 minutes may not be taken into account.
     *
     * **Since**: 3300.9.0
     */
    private Instant lastAccessed;


    public enum CourseRoleId {
        Instructor,
        BbFacilitator,
        TeachingAssistant,
        CourseBuilder,
        Grader,
        Student,
        Guest
    }

    public String getId() {
        return id;
    }

    public CourseMembership setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public CourseMembership setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CourseMembership setUser(User user) {
        this.user = user;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public CourseMembership setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getChildCourseId() {
        return childCourseId;
    }

    public CourseMembership setChildCourseId(String childCourseId) {
        this.childCourseId = childCourseId;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public CourseMembership setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public CourseMembership setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public CourseMembership setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public CourseMembership setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public CourseRoleId getCourseRoleId() {
        return courseRoleId;
    }

    public CourseMembership setCourseRoleId(CourseRoleId courseRoleId) {
        this.courseRoleId = courseRoleId;
        return this;
    }

    public Instant getBypassCourseAvailabilityUntil() {
        return bypassCourseAvailabilityUntil;
    }

    public CourseMembership setBypassCourseAvailabilityUntil(Instant bypassCourseAvailabilityUntil) {
        this.bypassCourseAvailabilityUntil = bypassCourseAvailabilityUntil;
        return this;
    }

    public Instant getLastAccessed() {
        return lastAccessed;
    }

    public CourseMembership setLastAccessed(Instant lastAccessed) {
        this.lastAccessed = lastAccessed;
        return this;
    }
}

