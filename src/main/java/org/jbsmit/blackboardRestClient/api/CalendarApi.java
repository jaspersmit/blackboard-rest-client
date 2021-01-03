package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Calendar;
import org.jbsmit.blackboardRestClient.model.CalendarItem;
import org.jbsmit.blackboardRestClient.model.CalendarItemRecurrence;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CalendarApi {
    /*
     * Get Calendars
     *
     * Get the list of calendars. This endpoint will return all calendars viewable by the user. All users can request a list of calendars viewable to them.
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<List<Calendar>> getCalendars() {
        return RestCallBuilder
            .start(new TypeToken<List<Calendar>>() {})
            .get()
            .url("/learn/api/public/v1/calendars")
            .build();
    }

    /*
     * Get Calendar Items
     *
     * Get the list of calendar items. This endpoint will return all types of CalendarItems viewable by the user unless a specific <code>type</code> is specified as a query parameter.
     *
     * If <code>since</code> and <code>since</code> are not provided this endpoint will default to the upcoming two week timeframe from now. </p>
     *
     * If only <code>since</code> is provided this endpoint will default the <code>until</code> parameter two weeks after <code>since</code>. </p>
     *
     * If only <code>until</code> is provided this endpoint will default the <code>since</code> parameter two prior to <code>until</code>. </p>
     *
     * Maximum timespan between <code>since</code> and <code>until</code> is 16 weeks. </p>
     *
     * CalendarItems of type <code>GradebookColumn</code> are a representation of a specific gradable item and therefore read-only. Modifications to GradebookColumn items performed via the Gradebook Column endpoints will be reflected in the CalendarItems endpoints. </p>
     *
     * The CalendarItem <code>id</code> can be used as the <code>columnId</code> on the Gradebook Column endpoints found here: <code>/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}</code>. </p> Example requests:
     *
     * - <code>GET ../items?since=2018-01-01T00:00:00.000Z&until2018-02-01T00:00:00.000Z // all calendar items for a given timeframe</code>
     * - <code>GET ../items?since=2018-01-01T00:00:00.000Z&until2018-02-01T00:00:00.000Z&courseId=_123_1 // all calendar items for a given course (including Course, OfficeHours, GradebookColumn types)</code>
     * - <code>GET ../items?since=2018-01-01T00:00:00.000Z&until2018-02-01T00:00:00.000Z&courseId=_123_1&type=GradebookColumn // all GradebookColumn items for a course</code>
     * - <code>GET ../items?since=2018-01-01T00:00:00.000Z&until2018-02-01T00:00:00.000Z&courseId=_123_1&type=OfficeHours // all OfficeHours for a course</code>
     * - <code>GET ../items?since=2018-01-01T00:00:00.000Z&until2018-02-01T00:00:00.000Z&type=GradebookColumn // all gradebook columns due within the given timeframe</code>
     * - <code>GET ../items?since=2018-01-01T00:00:00.000Z&until2018-02-01T00:00:00.000Z&type=OfficeHours // all OfficeHours available to current user for a given timeframe</code>
     * The following must be true in order to view the following calendar item types:
     *
     * - Institution
     * -
     *
     * - All users can view Institution calendar items
     *
     * - Personal
     * -
     *
     * - Any user may view their own calendar items, but not other user's calendar items
     *
     * - Course
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.VIEW' entitlement
     * - The course calendar must be enabled for the course the calendar item is associated with
     *
     * - GradebookColumn
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.VIEW' entitlement
     * - The course calendar must be enabled for the course the GradebookColumn is associated with
     *
     * - OfficeHours
     * -
     *
     * - If the OfficeHours are created for a course calendar (calendarId = a course id) the user must be enrolled in the course
     * - If the OfficeHours are created for a all courses (calendarId = PERSONAL) the user must be enrolled in any course that the user owning the OfficeHours is also enrolled in
     * - In either case above the course calendar must be enabled
     *
     * </p>
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<List<CalendarItem>> getCalendarItems(GetCalendarItemsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CalendarItem>>() {})
            .get()
            .url("/learn/api/public/v1/calendars/items")
            .options(options)
            .build();
    }

    public static class GetCalendarItemsOption extends RestCallOption {
        /*
         * Specifies only calendar items associated with 'courseId' are to be returned.
         *
         * **Since**: 3400.9.0
         */
        public static GetCalendarItemsOption courseId(String courseId) {
            return parameter("courseId", courseId, new GetCalendarItemsOption());
        }

        /*
         * Specifies only calendar items with the given type.
         *
         * **Since**: 3400.9.0
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
        public static GetCalendarItemsOption type(String type) {
            return parameter("type", type, new GetCalendarItemsOption());
        }

        /*
         * Specifies only calendar items after the 'since' date (inclusive) are to be returned. Maximum of 16 weeks after the 'since' date will be returned. ISO-8601 date-time format is expected: [yyyy-MM-dd|yyyyMMdd][T(hh:mm[:ss[.sss]]|hhmm[ss[.sss]])]?[Z|[+-]hh:mm]]
         *
         * **Since**: 3400.9.0
         */
        public static GetCalendarItemsOption since(Instant since) {
            return parameter("since", since, new GetCalendarItemsOption());
        }

        /*
         * Specifies only calendar items before the 'until' date (inclusive) are to be returned. Maximum of 16 weeks prior to the 'until' date will be returned. ISO-8601 date-time format is expected: [yyyy-MM-dd|yyyyMMdd][T(hh:mm[:ss[.sss]]|hhmm[ss[.sss]])]?[Z|[+-]hh:mm]]
         *
         * **Since**: 3400.9.0
         */
        public static GetCalendarItemsOption until(Instant until) {
            return parameter("until", until, new GetCalendarItemsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "title(desc),start" Supported fields are:
         *
         * - id
         * - calendarId
         * - title
         * - start
         * - end
         * - modified
         *
         * **Since**: 3400.9.0
         */
        public static GetCalendarItemsOption sort(String sort) {
            return parameter("sort", sort, new GetCalendarItemsOption());
        }
    }

    /*
     * Create Calendar Item
     *
     *
     *
     * Create a calendar item. Calendar items may be single or recurring. </p>
     *
     * CalendarItems of type <code>OfficeHours</code> will be assigned to the current user. </p> The following must be true in order to create a calendar item:
     *
     * - Institution
     * -
     *
     * - The user must have the 'system.calendar-item.EXECUTE' entitlement
     *
     * - Personal
     * -
     *
     * - Any user may create their own calendar items
     *
     * - Course
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.CREATE' entitlement
     * - The specified courseId must not be for an organization
     * - The course calendar must be enabled for the specified course
     *
     * - GradebookColumn
     * -
     *
     * - GradebookColumns must be created using the Gradebook API endpoint: <code>POST /learn/api/public/v2/courses/{courseId}/gradebook/columns</code>
     *
     * - OfficeHours
     * -
     *
     * - The user must have the 'course.calendar-entry.CREATE' entitlement
     * - If calendarId = a course id the user must be enrolled in the course and the calendar must be enabled
     * - Note: To create for all enrolled courses calendarId must be set to PERSONAL
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<CalendarItem> createCalendarItem(CreateCalendarItemBody input) {
        return RestCallBuilder
            .start(new TypeToken<CalendarItem>() {})
            .post()
            .url("/learn/api/public/v1/calendars/items")
            .body(input)
            .build();
    }

    public static class CreateCalendarItemBody {
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
         * Whether resizing of the calendar item should NOT be allowed.
         */
        private boolean disableResizing;

        /*
         * Extra calendar item properties if it is a GradebookColumn calendar item.
         */
        private DynamicCalendarItemProps dynamicCalendarItemProps;

        /*
         * Recurring definition if the calendar item is a repeatable calendar item. This object must be defined for <code>OfficeHours</code> type calendar items.
         */
        private CalendarItemRecurrence recurrence;

        public static CreateCalendarItemBody create() {
            return new CreateCalendarItemBody();
        }

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

            public DynamicCalendarItemProps setAttemptable(boolean attemptable) {
                this.attemptable = attemptable;
                return this;
            }

            public DynamicCalendarItemProps setCategoryId(String categoryId) {
                this.categoryId = categoryId;
                return this;
            }

            public DynamicCalendarItemProps setDateRangeLimited(boolean dateRangeLimited) {
                this.dateRangeLimited = dateRangeLimited;
                return this;
            }

            public DynamicCalendarItemProps setEventType(String eventType) {
                this.eventType = eventType;
                return this;
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

        public CreateCalendarItemBody setType(Type type) {
            this.type = type;
            return this;
        }

        public CreateCalendarItemBody setCalendarId(String calendarId) {
            this.calendarId = calendarId;
            return this;
        }

        public CreateCalendarItemBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateCalendarItemBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateCalendarItemBody setLocation(String location) {
            this.location = location;
            return this;
        }

        public CreateCalendarItemBody setStart(Instant start) {
            this.start = start;
            return this;
        }

        public CreateCalendarItemBody setEnd(Instant end) {
            this.end = end;
            return this;
        }

        public CreateCalendarItemBody setDisableResizing(boolean disableResizing) {
            this.disableResizing = disableResizing;
            return this;
        }

        public CreateCalendarItemBody setDynamicCalendarItemProps(DynamicCalendarItemProps dynamicCalendarItemProps) {
            this.dynamicCalendarItemProps = dynamicCalendarItemProps;
            return this;
        }

        public CreateCalendarItemBody setRecurrence(CalendarItemRecurrence recurrence) {
            this.recurrence = recurrence;
            return this;
        }
    }

    /*
     * Get Calendar Item
     *
     *
     *
     * Get a course calendar item. </p>
     *
     * CalendarItems of type <code>GradebookColumn</code> are a representation of a specific gradable item and therefore read-only. Modifications to GradebookColumn items performed via the Gradebook Column endpoints will be reflected in the CalendarItems endpoints. </p>
     *
     * The CalendarItem <code>id</code> can be used as the <code>columnId</code> on the Gradebook Column endpoints found here: <code>/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}</code>. </p> The following must be true in order to view the following calendar items types:
     *
     * - Institution
     * -
     *
     * - All users can view Institution calendar items
     *
     * - Personal
     * -
     *
     * - Any user may view their own calendar items, but not other user's calendar items
     *
     * - Course
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.VIEW' entitlement
     * - The course calendar must be enabled for the course the calendar item is associated with
     *
     * - GradebookColumn
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.VIEW' entitlement
     * - The course calendar must be enabled for the course the GradebookColumn is associated with
     *
     * - OfficeHours
     * -
     *
     * - If the OfficeHours are created for a course calendar (calendarId = a course id) the user must be enrolled in the course
     * - If the OfficeHours are created for a all courses (calendarId = PERSONAL) the user must be enrolled in any course that the user owning the OfficeHours is also enrolled in
     * - In either case above the course calendar must be enabled
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<CalendarItem> getCalendarItem(String calendarItemType, String calendarItemId) {
        return RestCallBuilder
            .start(new TypeToken<CalendarItem>() {})
            .get()
            .url("/learn/api/public/v1/calendars/items/{calendarItemType}/{calendarItemId}")
            .pathParam("calendarItemType", calendarItemType)
            .pathParam("calendarItemId", calendarItemId)
            .build();
    }

    /*
     * Delete Calendar Item
     *
     *
     *
     * Delete a calendar item or series. </p> The following must be true in order to delete a calendar item:
     *
     * - Institution
     * -
     *
     * - The user must have the 'system.calendar-item.EXECUTE' entitlement
     *
     * - Personal
     * -
     *
     * - Any user may delete their own calendar items
     *
     * - Course
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.MODIFY' entitlement
     * - The course calendar must be enabled for the specified course
     *
     * - GradebookColumn
     * -
     *
     * - GradebookColumns must be deleted using the Gradebook API endpoint: <code>DELETE /learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}</code>
     *
     * - OfficeHours
     * -
     *
     * - The user must have the 'course.calendar-entry.MODIFY' entitlement
     * - The user must own the calendarItem
     * - The calendar must be enabled if the calendarItem is associated with a course calendar.
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<Void> deleteCalendarItem(String calendarItemType, String calendarItemId, DeleteCalendarItemOption... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/calendars/items/{calendarItemType}/{calendarItemId}")
            .pathParam("calendarItemType", calendarItemType)
            .pathParam("calendarItemId", calendarItemId)
            .options(options)
            .build();
    }

    public static class DeleteCalendarItemOption extends RestCallOption {
        /*
         * delete the series calendar items or just one calendar item. true - delete the        series, false - delete one calendar item. Defaults to false.
         */
        public static DeleteCalendarItemOption deleteSeries(boolean deleteSeries) {
            return parameter("deleteSeries", deleteSeries, new DeleteCalendarItemOption());
        }
    }

    /*
     * Update Calendar Item
     *
     *
     *
     * Update a calendar item or series. </p>
     *
     * When updating the series the existing CalendarItems will be removed and a new set of CalendarItems will be created. This is the same behavior as experienced via the UI. </p> The following must be true in order to update a calendar item:
     *
     * - Institution
     * -
     *
     * - The user must have the 'system.calendar-item.EXECUTE' entitlement
     *
     * - Personal
     * -
     *
     * - Any user may update their own calendar items
     *
     * - Course
     * -
     *
     * - The user must be enrolled in the course
     * - The user must have the 'course.calendar-entry.MODIFY' entitlement
     * - The course calendar must be enabled for the specified course
     *
     * - GradebookColumn
     * -
     *
     * - GradebookColumns must be updated using the Gradebook API endpoint: <code>PATCH /learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}</code>
     *
     * - OfficeHours
     * -
     *
     * - The user must have the 'course.calendar-entry.MODIFY' entitlement
     * - If calendarId = a course id the user must be enrolled in the course and the calendar must be enabled
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<CalendarItem> updateCalendarItem(String calendarItemType, String calendarItemId, UpdateCalendarItemBody input, UpdateCalendarItemOption... options) {
        return RestCallBuilder
            .start(new TypeToken<CalendarItem>() {})
            .patch()
            .url("/learn/api/public/v1/calendars/items/{calendarItemType}/{calendarItemId}")
            .pathParam("calendarItemType", calendarItemType)
            .pathParam("calendarItemId", calendarItemId)
            .body(input)
            .options(options)
            .build();
    }

    public static class UpdateCalendarItemBody {
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
         * Whether resizing of the calendar item should NOT be allowed.
         */
        private boolean disableResizing;

        /*
         * Extra calendar item properties if it is a GradebookColumn calendar item.
         */
        private DynamicCalendarItemProps dynamicCalendarItemProps;

        /*
         * Recurring definition if the calendar item is a repeatable calendar item. This object must be defined for <code>OfficeHours</code> type calendar items.
         */
        private CalendarItemRecurrence recurrence;

        public static UpdateCalendarItemBody create() {
            return new UpdateCalendarItemBody();
        }

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

            public DynamicCalendarItemProps setAttemptable(boolean attemptable) {
                this.attemptable = attemptable;
                return this;
            }

            public DynamicCalendarItemProps setCategoryId(String categoryId) {
                this.categoryId = categoryId;
                return this;
            }

            public DynamicCalendarItemProps setDateRangeLimited(boolean dateRangeLimited) {
                this.dateRangeLimited = dateRangeLimited;
                return this;
            }

            public DynamicCalendarItemProps setEventType(String eventType) {
                this.eventType = eventType;
                return this;
            }

            public DynamicCalendarItemProps setGradable(boolean gradable) {
                this.gradable = gradable;
                return this;
            }
        }

        public UpdateCalendarItemBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateCalendarItemBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateCalendarItemBody setLocation(String location) {
            this.location = location;
            return this;
        }

        public UpdateCalendarItemBody setStart(Instant start) {
            this.start = start;
            return this;
        }

        public UpdateCalendarItemBody setEnd(Instant end) {
            this.end = end;
            return this;
        }

        public UpdateCalendarItemBody setDisableResizing(boolean disableResizing) {
            this.disableResizing = disableResizing;
            return this;
        }

        public UpdateCalendarItemBody setDynamicCalendarItemProps(DynamicCalendarItemProps dynamicCalendarItemProps) {
            this.dynamicCalendarItemProps = dynamicCalendarItemProps;
            return this;
        }

        public UpdateCalendarItemBody setRecurrence(CalendarItemRecurrence recurrence) {
            this.recurrence = recurrence;
            return this;
        }
    }

    public static class UpdateCalendarItemOption extends RestCallOption {
        /*
         * update the series calendar items or just one calendar item. true - update the        entire series, false - update a single calendar item. Defaults to false. When updating an entire series the full recurrence        object must be populated just as if creating a new calendar series. If updating a single calendar entry the recurrence        must not be specified.
         */
        public static UpdateCalendarItemOption updateSeries(boolean updateSeries) {
            return parameter("updateSeries", updateSeries, new UpdateCalendarItemOption());
        }
    }
}
