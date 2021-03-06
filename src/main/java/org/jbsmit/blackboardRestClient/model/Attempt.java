package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Attempt {
    /*
     * The primary ID for this attempt.
     */
    private String id;

    /*
     * The user ID associated with this attempt.
     */
    private String userId;

    /*
     * The group attempt ID associated with this student attempt.
     */
    private String groupAttemptId;

    /*
     * Whether the score associated with this student attempt was overridden from the associated group attempt score. A value is only returned if the attempt grade is currently overridden.
     */
    private boolean groupOverride;

    /*
     * The status of this attempt.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | NotAttempted | none of the students in a group has submitted an attempt; applies only to group assessments |
     * | Abandoned |   **Deprecated**: Since 9.1 SP8 unsupported status, undetermined behavior if used. |
     * | InProgress | attempt activity has commenced, but has not been submitted for grading |
     * | Suspended |   **Deprecated**: Since 9.1 SP8 unsupported status, undetermined behavior if used. |
     * | Canceled |   **Deprecated**: Since 9.1 SP8 unsupported status, undetermined behavior if used. |
     * | NeedsGrading | attempt has been submitted for grading, but has not been fully graded |
     * | Completed | a grade has been entered for the attempt |
     * | InProgressAgain | attempt has been graded, but more student activity occurred after the grade was entered; applies only to collaborative tools such as discussions |
     * | NeedsGradingAgain | additional student activity occurring after a grade was entered requires that the attempt be regraded; applies only to collaborative tools such as discussions |
     *
     */
    private Status status;

    /*
     * The text representation of grade for this attempt.
     */
    private String text;

    /*
     * The score associated with this attempt.
     */
    private BigDecimal score;

    /*
     * The instructor notes associated with this attempt.
     */
    private String notes;

    /*
     * The instructor feedback associated with this attempt.
     */
    private String feedback;

    /*
     * The student comments associated with this attempt.
     */
    private String studentComments;

    /*
     * The student submission text associated with this attempt.
     */
    private String studentSubmission;

    /*
     * Whether the score associated with this attempt is ignored when computing the user's grade for the associated grade column.
     */
    private boolean exempt;

    /*
     * The date on which this attempt was created.
     */
    private Instant created;


    public enum Status {
        NotAttempted,
        Abandoned,
        InProgress,
        Suspended,
        Canceled,
        NeedsGrading,
        Completed,
        InProgressAgain,
        NeedsGradingAgain
    }

    public String getId() {
        return id;
    }

    public Attempt setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Attempt setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getGroupAttemptId() {
        return groupAttemptId;
    }

    public Attempt setGroupAttemptId(String groupAttemptId) {
        this.groupAttemptId = groupAttemptId;
        return this;
    }

    public boolean getGroupOverride() {
        return groupOverride;
    }

    public Attempt setGroupOverride(boolean groupOverride) {
        this.groupOverride = groupOverride;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Attempt setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getText() {
        return text;
    }

    public Attempt setText(String text) {
        this.text = text;
        return this;
    }

    public BigDecimal getScore() {
        return score;
    }

    public Attempt setScore(BigDecimal score) {
        this.score = score;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Attempt setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public Attempt setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public String getStudentComments() {
        return studentComments;
    }

    public Attempt setStudentComments(String studentComments) {
        this.studentComments = studentComments;
        return this;
    }

    public String getStudentSubmission() {
        return studentSubmission;
    }

    public Attempt setStudentSubmission(String studentSubmission) {
        this.studentSubmission = studentSubmission;
        return this;
    }

    public boolean getExempt() {
        return exempt;
    }

    public Attempt setExempt(boolean exempt) {
        this.exempt = exempt;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Attempt setCreated(Instant created) {
        this.created = created;
        return this;
    }
}

