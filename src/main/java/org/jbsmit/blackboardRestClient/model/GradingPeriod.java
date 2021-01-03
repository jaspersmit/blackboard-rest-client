package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class GradingPeriod {
    /*
     * The REST Id object that uniquely identifies this grading period for REST usage
     */
    private String id;

    /*
     * The title of the grading period. Length is limited to 64 characters.
     */
    private String title;

    /*
     * The description of the grading period. Length is limited to 1000 characters.
     */
    private String description;

    /*
     * The relative position of the grading period to other grading periods when viewed in the grade book.
     */
    private int position;

    /*
     * Property may be set to DoNotUseDates to explicitly blank dates,  in which case startDate and endDate are ignored; otherwise set to  UseDates; in this case startDate and endDate must be included and valid.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | DoNotUseDates | Do not use dates |
     * | UseDates | Use dates |
     *
     */
    private DateMode dateMode;

    /*
     * If start and end are set, and start is before end, these define temporal  coverage of grading period which may be used to associate GradableItems (Columns) by due date. Start dates will be persisted as starting at  00:00:00 on the submitted day.
     */
    private Instant start;

    /*
     * If start and end are set, and start is before end, these define temporal  coverage of grading period which may be used to associate GradableItems (Columns) by due date. End dates will be persisted as ending at  23:59:59 on the submitted day.
     */
    private Instant end;


    public enum DateMode {
        DoNotUseDates,
        UseDates
    }

    public String getId() {
        return id;
    }

    public GradingPeriod setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GradingPeriod setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GradingPeriod setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public GradingPeriod setPosition(int position) {
        this.position = position;
        return this;
    }

    public DateMode getDateMode() {
        return dateMode;
    }

    public GradingPeriod setDateMode(DateMode dateMode) {
        this.dateMode = dateMode;
        return this;
    }

    public Instant getStart() {
        return start;
    }

    public GradingPeriod setStart(Instant start) {
        this.start = start;
        return this;
    }

    public Instant getEnd() {
        return end;
    }

    public GradingPeriod setEnd(Instant end) {
        this.end = end;
        return this;
    }
}

