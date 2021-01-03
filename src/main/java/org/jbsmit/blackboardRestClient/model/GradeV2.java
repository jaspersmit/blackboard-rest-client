package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;
import java.time.Instant;

public class GradeV2 {
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
     * The primary display grade associated with this grade. Secondary display grade is not exposed via API
     */
    private DisplayGrade displayGrade;

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

    /*
     * The Id of a Grade Notation which can be optionally associated with this Grade. If a Grade Notation is specified for this Grade, then the DisplayGrade's Text attribute will contain the Grade Notation's Description.
     */
    private String gradeNotationId;

    /*
     * The change index associated with this grade which indicates what relative point in time the grade was created or last updated.
     */
    private long changeIndex;


    public enum Status {
        Graded,
        NeedsGrading
    }

    public String getUserId() {
        return userId;
    }

    public GradeV2 setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getColumnId() {
        return columnId;
    }

    public GradeV2 setColumnId(String columnId) {
        this.columnId = columnId;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public GradeV2 setStatus(Status status) {
        this.status = status;
        return this;
    }

    public DisplayGrade getDisplayGrade() {
        return displayGrade;
    }

    public GradeV2 setDisplayGrade(DisplayGrade displayGrade) {
        this.displayGrade = displayGrade;
        return this;
    }

    public String getText() {
        return text;
    }

    public GradeV2 setText(String text) {
        this.text = text;
        return this;
    }

    public BigDecimal getScore() {
        return score;
    }

    public GradeV2 setScore(BigDecimal score) {
        this.score = score;
        return this;
    }

    public Instant getOverridden() {
        return overridden;
    }

    public GradeV2 setOverridden(Instant overridden) {
        this.overridden = overridden;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public GradeV2 setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getFeedback() {
        return feedback;
    }

    public GradeV2 setFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public boolean getExempt() {
        return exempt;
    }

    public GradeV2 setExempt(boolean exempt) {
        this.exempt = exempt;
        return this;
    }

    public boolean getCorrupt() {
        return corrupt;
    }

    public GradeV2 setCorrupt(boolean corrupt) {
        this.corrupt = corrupt;
        return this;
    }

    public String getGradeNotationId() {
        return gradeNotationId;
    }

    public GradeV2 setGradeNotationId(String gradeNotationId) {
        this.gradeNotationId = gradeNotationId;
        return this;
    }

    public long getChangeIndex() {
        return changeIndex;
    }

    public GradeV2 setChangeIndex(long changeIndex) {
        this.changeIndex = changeIndex;
        return this;
    }
}

