package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Grade {
    /*
     * The user ID associated with this grade.
     */
    private String userId;

    /*
     * The grade column ID for this grade.
     */
    private String columnId;

    /*
     * The status of this grade.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Graded | Grade has been graded, corresponding to dbValue 1 |
     * | NeedsGrading | Grade needs grading, corresponding to dbValue 2 |
     *
     */
    private Status status;

    /*
     * The text representation of this grade.
     */
    private String text;

    /*
     * The score associated with this grade.
     */
    private BigDecimal score;

    /*
     * The date on which the score associated with this grade was last overridden.  An ISODate value is only returned if this grade is currently overridden; otherwise, returns null.
     */
    private Instant overridden;

    /*
     * The instructor notes associated with this grade. This notes field is used for grades on manual grade columns.   That is, when column.grading.type = Manual.  It is also used when column.grading.type = Attempts and the grade has been manually overridden.
     */
    private String notes;

    /*
     * The instructor feedback associated with this grade.  This feedback is used for grades on manual grade columns.   That is, when column.grading.type = Manual.  It is also used when column.grading.type = Attempts and the grade has been manually overridden.
     */
    private String feedback;

    /*
     * Whether the score associated with this grade is ignored when computing the course grade.
     */
    private boolean exempt;

    /*
     * Whether the grade for a calculated column could be successfully computed.
     */
    private boolean corrupt;


    public enum Status {
        Graded,
        NeedsGrading
    }

    public String getUserId() {
        return userId;
    }

    public Grade setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getColumnId() {
        return columnId;
    }

    public Grade setColumnId(String columnId) {
        this.columnId = columnId;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Grade setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getText() {
        return text;
    }

    public Grade setText(String text) {
        this.text = text;
        return this;
    }

    public BigDecimal getScore() {
        return score;
    }

    public Grade setScore(BigDecimal score) {
        this.score = score;
        return this;
    }

    public Instant getOverridden() {
        return overridden;
    }

    public Grade setOverridden(Instant overridden) {
        this.overridden = overridden;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Grade setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public Grade setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public boolean getExempt() {
        return exempt;
    }

    public Grade setExempt(boolean exempt) {
        this.exempt = exempt;
        return this;
    }

    public boolean getCorrupt() {
        return corrupt;
    }

    public Grade setCorrupt(boolean corrupt) {
        this.corrupt = corrupt;
        return this;
    }
}

