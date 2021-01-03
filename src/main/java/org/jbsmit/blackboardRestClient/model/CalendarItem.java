package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CalendarItem {
    /*
     * Calendar item identifier that indicates the id of the calendar item source which the item was created from. (Ex. '_417_1')
     */
    private String id;

    /*
     * The type of this Calendar Item.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Course |  |
     * | GradebookColumn | Read only. |
     * | Institution |  |
     * | OfficeHours |  |
     * | Personal |  |
     *
     */
    private Type type;

    /*
     * Calendar source identifier which indicates the calendar on which the calendar item was created. Examples of possible values : "PERSONAL", "INSTITUTION", and course id in the format of "_3_1".
     */
    private String calendarId;

    /*
     * Calendar source label/display name.
     */
    private String calendarName;

    /*
     * Title of the calendar item. Title length cannot exceed 255 characters.
     */
    private String title;

    /*
     * Description of the calendar item.
     */
    private String description;

    /*
     * Location of the calendar item and it cannot exceed 1024 characters.
     */
    private String location;

    /*
     * Start date of the calendar item either in the past if the calendar item is for an event that's already started OR in the future if it's for an event to start in the future. This is always set and should occur before the end date.
     */
    private Instant start;

    /*
     * End date of the calendar item either in the past if the calendar item is for an event that's already end OR in the future if it's for an event to end in the future. This is always set and should occur after the start date.
     */
    private Instant end;

    /*
     * Date when the calendar item was last modified.
     */
    private Instant modified;

    /*
     * Color to use for the calendar item. It's a shared setting for all calendar items with the same calendar source identifier.
     */
    private String color;

    /*
     * Whether resizing of the calendar item should NOT be allowed.
     */
    private boolean disableResizing;

    /*
     * Get the user who created this calendar item. This will be null for non-personal events when the creator has been deleted.
     */
    private String createdByUserId;

    /*
     * Extra calendar item properties if it is a GradebookColumn calendar item.
     */
    private DynamicCalendarItemProps dynamicCalendarItemProps;

    /*
     * Recurring definition if the calendar item is a repeatable calendar item. This object must be defined for <code>OfficeHours</code> type calendar items.
     */
    private CalendarItemRecurrence recurrence;


    public static class DynamicCalendarItemProps {
        /*
         * The dynamic calendar item can be attempted (can have attempts made against it) and the current user (in context) has permission/entitlement to grade attempts for the object represented by this calendar item.
         */
        private boolean attemptable;

        /*
         * Returns the gradeableItem categoryId value .it is only set if the calendar event is dynamically created based on a single grade book column
         */
        private String categoryId;

        /*
         * The dynamic calendar item is only visible during a specific windows of time.
         */
        private boolean dateRangeLimited;

        /*
         * Returns a human readable string describing the type of calendar item represented (e.g. assignment, test, etc.).
         */
        private String eventType;

        /*
         * The dynamic calendar item can be graded and the current user (in context) has permission/entitlement to grade attempts for the object represented by this calendar item.
         */
        private boolean gradable;

        public static DynamicCalendarItemProps create() {
            return new DynamicCalendarItemProps();
        }

        public boolean getAttemptable() {
            return attemptable;
        }

        public DynamicCalendarItemProps setAttemptable(boolean attemptable) {
            this.attemptable = attemptable;
            return this;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public DynamicCalendarItemProps setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public boolean getDateRangeLimited() {
            return dateRangeLimited;
        }

        public DynamicCalendarItemProps setDateRangeLimited(boolean dateRangeLimited) {
            this.dateRangeLimited = dateRangeLimited;
            return this;
        }

        public String getEventType() {
            return eventType;
        }

        public DynamicCalendarItemProps setEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public boolean getGradable() {
            return gradable;
        }

        public DynamicCalendarItemProps setGradable(boolean gradable) {
            this.gradable = gradable;
            return this;
        }
    }

    public enum Type {
        Course,
        GradebookColumn,
        Institution,
        OfficeHours,
        Personal
    }

    public String getId() {
        return id;
    }

    public CalendarItem setId(String id) {
        this.id = id;
        return this;
    }

    public Type getType() {
        return type;
    }

    public CalendarItem setType(Type type) {
        this.type = type;
        return this;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public CalendarItem setCalendarId(String calendarId) {
        this.calendarId = calendarId;
        return this;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public CalendarItem setCalendarName(String calendarName) {
        this.calendarName = calendarName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CalendarItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CalendarItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public CalendarItem setLocation(String location) {
        this.location = location;
        return this;
    }

    public Instant getStart() {
        return start;
    }

    public CalendarItem setStart(Instant start) {
        this.start = start;
        return this;
    }

    public Instant getEnd() {
        return end;
    }

    public CalendarItem setEnd(Instant end) {
        this.end = end;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public CalendarItem setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getColor() {
        return color;
    }

    public CalendarItem setColor(String color) {
        this.color = color;
        return this;
    }

    public boolean getDisableResizing() {
        return disableResizing;
    }

    public CalendarItem setDisableResizing(boolean disableResizing) {
        this.disableResizing = disableResizing;
        return this;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public CalendarItem setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
        return this;
    }

    public DynamicCalendarItemProps getDynamicCalendarItemProps() {
        return dynamicCalendarItemProps;
    }

    public CalendarItem setDynamicCalendarItemProps(DynamicCalendarItemProps dynamicCalendarItemProps) {
        this.dynamicCalendarItemProps = dynamicCalendarItemProps;
        return this;
    }

    public CalendarItemRecurrence getRecurrence() {
        return recurrence;
    }

    public CalendarItem setRecurrence(CalendarItemRecurrence recurrence) {
        this.recurrence = recurrence;
        return this;
    }
}

