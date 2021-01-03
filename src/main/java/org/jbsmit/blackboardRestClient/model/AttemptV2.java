package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;
import java.time.Instant;

public class AttemptV2 {
    /*
     * The primary ID for this attempt.
     */
    private String id;

    /*
     * The user ID associated with this attempt.  Defaults to the authenticated user on create.  Can be specified as a user other than the authenticated user if the authenticated user has the "course.gradebook.MODIFY" entitlement and the authenticated application has the "course.attempt.nonowner.SUBMIT" entitlement.
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
     * The display grade associated with this attempt.
     */
    private DisplayGrade displayGrade;

    /*
     * The text grade associated with this attempt.
     */
    private String text;

    /*
     * The score associated with this attempt.
     */
    private BigDecimal score;

    /*
     * The reconciliation mode to use when reconciling the attempt grade.  When modifying reconciliationMode, score is also required.  A new score will not be calculated based on the reconciliationMode
     *
     * **Since**: 3700.2.0
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Average |  |
     * | Highest |  |
     * | Lowest |  |
     * | Custom |  |
     *
     */
    private ReconciliationMode reconciliationMode;

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

    /*
     * Return the attempt date associated with this attempt.
     */
    private Instant attemptDate;

    /*
     * The date when the attempt was modified.
     *
     * **Since**: 3800.0.0
     */
    private Instant modified;


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

    public enum ReconciliationMode {
        Average,
        Highest,
        Lowest,
        Custom
    }

    public String getId() {
        return id;
    }

    public AttemptV2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AttemptV2 setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getGroupAttemptId() {
        return groupAttemptId;
    }

    public AttemptV2 setGroupAttemptId(String groupAttemptId) {
        this.groupAttemptId = groupAttemptId;
        return this;
    }

    public boolean getGroupOverride() {
        return groupOverride;
    }

    public AttemptV2 setGroupOverride(boolean groupOverride) {
        this.groupOverride = groupOverride;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public AttemptV2 setStatus(Status status) {
        this.status = status;
        return this;
    }

    public DisplayGrade getDisplayGrade() {
        return displayGrade;
    }

    public AttemptV2 setDisplayGrade(DisplayGrade displayGrade) {
        this.displayGrade = displayGrade;
        return this;
    }

    public String getText() {
        return text;
    }

    public AttemptV2 setText(String text) {
        this.text = text;
        return this;
    }

    public BigDecimal getScore() {
        return score;
    }

    public AttemptV2 setScore(BigDecimal score) {
        this.score = score;
        return this;
    }

    public ReconciliationMode getReconciliationMode() {
        return reconciliationMode;
    }

    public AttemptV2 setReconciliationMode(ReconciliationMode reconciliationMode) {
        this.reconciliationMode = reconciliationMode;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public AttemptV2 setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public AttemptV2 setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public String getStudentComments() {
        return studentComments;
    }

    public AttemptV2 setStudentComments(String studentComments) {
        this.studentComments = studentComments;
        return this;
    }

    public String getStudentSubmission() {
        return studentSubmission;
    }

    public AttemptV2 setStudentSubmission(String studentSubmission) {
        this.studentSubmission = studentSubmission;
        return this;
    }

    public boolean getExempt() {
        return exempt;
    }

    public AttemptV2 setExempt(boolean exempt) {
        this.exempt = exempt;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public AttemptV2 setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getAttemptDate() {
        return attemptDate;
    }

    public AttemptV2 setAttemptDate(Instant attemptDate) {
        this.attemptDate = attemptDate;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public AttemptV2 setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}

