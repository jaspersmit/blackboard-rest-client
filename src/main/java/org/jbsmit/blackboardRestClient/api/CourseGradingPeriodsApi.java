package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.GradingPeriod;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CourseGradingPeriodsApi {
    /*
     * Get Grading Periods
     *
     * Returns a list of grading periods.
     *
     * The entitlement "course.gradebook.MODIFY" or "course.gradebook-metadata.VIEW" is needed. Note that grading period Ids may be visible on GradableItems based on GradableItem (column / assignment) entitlement restrictions.
     *
     * This endpoint supports paging, sorting, and the filtering of fields returned on result object.
     *
     * **Since**: 3300.3.0
     */
    public static RestCall<List<GradingPeriod>> getGradingPeriods(String courseId, GetGradingPeriodsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GradingPeriod>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/periods")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetGradingPeriodsOption extends RestCallOption {
        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties,  with an optional "(desc)" or "(asc)" suffix to request an ascending or descending sort for that property. e.g. "title(desc),description" Supported fields are:
         *
         * - id
         * - title
         * - position
         * - dateMode
         * - description
         *
         * **Since**: 3300.2.0
         */
        public static GetGradingPeriodsOption sort(String sort) {
            return parameter("sort", sort, new GetGradingPeriodsOption());
        }
    }

    /*
     * Create Grading Period
     *
     * Create a grading period.
     *
     * The entitlement "course.gradebook.MODIFY" is needed.
     *
     * This endpoint supports the filtering of fields returned on result object.
     *
     * This endpoint has an optional request parameter "associate", which will default false. If associate=true, then when the period is updated all assignments in this course  with a due date within the bounds of the grading period's start and end dates (if set)  will associate themselves to the updated grading period.
     *
     * **Since**: 3300.3.0
     */
    public static RestCall<GradingPeriod> createGradingPeriod(String courseId, CreateGradingPeriodBody input, CreateGradingPeriodOption... options) {
        return RestCallBuilder
            .start(new TypeToken<GradingPeriod>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/periods")
            .pathParam("courseId", courseId)
            .body(input)
            .options(options)
            .build();
    }

    public static class CreateGradingPeriodBody {
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

        public static CreateGradingPeriodBody create() {
            return new CreateGradingPeriodBody();
        }

        public enum DateMode {
            DoNotUseDates,
            UseDates
        }

        public CreateGradingPeriodBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateGradingPeriodBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGradingPeriodBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public CreateGradingPeriodBody setDateMode(DateMode dateMode) {
            this.dateMode = dateMode;
            return this;
        }

        public CreateGradingPeriodBody setStart(Instant start) {
            this.start = start;
            return this;
        }

        public CreateGradingPeriodBody setEnd(Instant end) {
            this.end = end;
            return this;
        }
    }

    public static class CreateGradingPeriodOption extends RestCallOption {
        public static CreateGradingPeriodOption associate(boolean associate) {
            return parameter("associate", associate, new CreateGradingPeriodOption());
        }
    }

    /*
     * Get Grading Period
     *
     * Returns a specific grading period.
     *
     * The entitlement "course.gradebook.MODIFY" or "course.gradebook-metadata.VIEW" is needed. Note that grading period Ids may be visible on GradableItems based on GradableItem (column / assignment) entitlement restrictions.
     *
     * This endpoint supports the filtering of fields returned on result object.
     *
     * **Since**: 3300.3.0
     */
    public static RestCall<GradingPeriod> getGradingPeriod(String courseId, String periodId) {
        return RestCallBuilder
            .start(new TypeToken<GradingPeriod>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/periods/{periodId}")
            .pathParam("courseId", courseId)
            .pathParam("periodId", periodId)
            .build();
    }

    /*
     * Delete Grading Period
     *
     * Delete a specific grading period. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3300.3.0
     */
    public static RestCall<Void> deleteGradingPeriod(String courseId, String periodId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/periods/{periodId}")
            .pathParam("courseId", courseId)
            .pathParam("periodId", periodId)
            .build();
    }

    /*
     * Update Grading Period
     *
     * Update a grading period. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * This endpoint supports the filtering of fields returned on result object.
     *
     * This endpoint has an optional request parameter "associate", which will default false. If associate=true, then when the period is updated all assignments in this course  with a due date within the bounds of the grading period's start and end dates (if set)  will associate themselves to the updated grading period.
     *
     * **Since**: 3300.3.0
     */
    public static RestCall<GradingPeriod> updateGradingPeriod(String courseId, String periodId, UpdateGradingPeriodBody input, UpdateGradingPeriodOption... options) {
        return RestCallBuilder
            .start(new TypeToken<GradingPeriod>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/periods/{periodId}")
            .pathParam("courseId", courseId)
            .pathParam("periodId", periodId)
            .body(input)
            .options(options)
            .build();
    }

    public static class UpdateGradingPeriodBody {
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

        public static UpdateGradingPeriodBody create() {
            return new UpdateGradingPeriodBody();
        }

        public enum DateMode {
            DoNotUseDates,
            UseDates
        }

        public UpdateGradingPeriodBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateGradingPeriodBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateGradingPeriodBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public UpdateGradingPeriodBody setDateMode(DateMode dateMode) {
            this.dateMode = dateMode;
            return this;
        }

        public UpdateGradingPeriodBody setStart(Instant start) {
            this.start = start;
            return this;
        }

        public UpdateGradingPeriodBody setEnd(Instant end) {
            this.end = end;
            return this;
        }
    }

    public static class UpdateGradingPeriodOption extends RestCallOption {
        public static UpdateGradingPeriodOption associate(boolean associate) {
            return parameter("associate", associate, new UpdateGradingPeriodOption());
        }
    }
}
