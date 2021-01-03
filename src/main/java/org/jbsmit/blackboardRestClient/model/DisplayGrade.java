package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;

public class DisplayGrade {
    /*
     * The type of Grade Column Grading Schema used when creating the displayed grade
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Percent |  |
     * | Score |  |
     * | Tabular |  |
     * | Text |  |
     * | CompleteIncomplete |  |
     *
     */
    private ScaleType scaleType;

    /*
     * The displayed score
     */
    private BigDecimal score;

    /*
     * The displayed text grade, based on the Grade Column Grading Schema or Grade Notation description.
     */
    private String text;


    public enum ScaleType {
        Percent,
        Score,
        Tabular,
        Text,
        CompleteIncomplete
    }

    public ScaleType getScaleType() {
        return scaleType;
    }

    public DisplayGrade setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    public BigDecimal getScore() {
        return score;
    }

    public DisplayGrade setScore(BigDecimal score) {
        this.score = score;
        return this;
    }

    public String getText() {
        return text;
    }

    public DisplayGrade setText(String text) {
        this.text = text;
        return this;
    }
}

