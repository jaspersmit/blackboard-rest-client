package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.AttemptV2;
import org.jbsmit.blackboardRestClient.model.GradeColumnV2;
import org.jbsmit.blackboardRestClient.model.GradeSchema;
import org.jbsmit.blackboardRestClient.model.GradeSymbol;
import org.jbsmit.blackboardRestClient.model.GradeV2;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CourseGradesApi {
    /*
     * Get Grade Schemas
     *
     * Returns a list of grade schemas associated with the specified course.
     *
     * Users with entitlements 'course.gradebook.MODIFY' or 'course.user.grades.VIEW', or users enrolled in the specified course can retrieve grade schema details.
     *
     * A subset of the schema properties are available to enrolled users without the 'course.gradebook.MODIFY' entitlement:
     *
     * - id
     * - scaleType
     *
     * **Since**: 3300.2.0
     */
    public static RestCall<List<GradeSchema>> getGradeSchemas(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<GradeSchema>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/schemas")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Create Grade Schema
     *
     * Create a Tabular Grade Schema on this course. Currently only supports Classic/9.1 Courses.
     *
     * The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3300.2.0
     */
    public static RestCall<GradeSchema> createGradeSchema(String courseId, CreateGradeSchemaBody gradeSchemaTOPubV1) {
        return RestCallBuilder
            .start(new TypeToken<GradeSchema>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/schemas")
            .pathParam("courseId", courseId)
            .body(gradeSchemaTOPubV1)
            .build();
    }

    public static class CreateGradeSchemaBody {
        /*
         * The externalId associated with this grade schema.
         */
        private String externalId;

        /*
         * The title of this grade schema.
         */
        private String title;

        /*
         * The description of this grade schema.
         */
        private String description;

        /*
         * The scale type of this grade schema.
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
         * The list of grade symbols for this grade schema. Only returned for Tabular scaleType schemas.
         */
        private List<GradeSymbol> symbols;

        public static CreateGradeSchemaBody create() {
            return new CreateGradeSchemaBody();
        }

        public enum ScaleType {
            Percent,
            Score,
            Tabular,
            Text,
            CompleteIncomplete
        }

        public CreateGradeSchemaBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateGradeSchemaBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateGradeSchemaBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGradeSchemaBody setScaleType(ScaleType scaleType) {
            this.scaleType = scaleType;
            return this;
        }

        public CreateGradeSchemaBody setSymbols(List<GradeSymbol> symbols) {
            this.symbols = symbols;
            return this;
        }
    }

    /*
     * Get Grade Schema
     *
     * Loads the grade schema associated with the specified course and schema Id.
     *
     * Users with entitlements 'course.gradebook.MODIFY' or 'course.user.grades.VIEW', or users enrolled in the specified course can retrieve the grade schema details.
     *
     * A subset of the schema properties are available to enrolled users without the 'course.gradebook.MODIFY' entitlement:
     *
     * - id
     * - scaleType
     *
     * **Since**: 3300.2.0
     */
    public static RestCall<GradeSchema> getGradeSchema(String courseId, String schemaId) {
        return RestCallBuilder
            .start(new TypeToken<GradeSchema>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/schemas/{schemaId}")
            .pathParam("courseId", courseId)
            .pathParam("schemaId", schemaId)
            .build();
    }

    /*
     * Delete Grade Schema
     *
     * Deletes the grade schema associated with the specified course and schema Id.
     *
     * Requires entitlement 'course.gradebook.MODIFY'
     *
     * Grade schemas in Ultra courses may not be deleted
     *
     * A schema must be removable (not in-use, and either tabular or user-created) to be deleted
     *
     * **Since**: 3300.2.0
     */
    public static RestCall<Void> deleteGradeSchema(String courseId, String schemaId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/schemas/{schemaId}")
            .pathParam("courseId", courseId)
            .pathParam("schemaId", schemaId)
            .build();
    }

    /*
     * Update Grade Schema
     *
     *
     *
     * Updates the grade schema associated with the specified course and schema Id. </p>
     *
     * Requires entitlement 'course.gradebook.MODIFY' </p>
     *
     * A schema must have a scaleType of Tabular to be updated </p>
     *
     * If updating the symbols field, the following criteria must be true:
     *
     * - All symbols for the schema must be included. Any existing symbols not included in the patch will be deleted.
     * - There must be at least 1 symbol for schemas associated with Classic courses, and 2 for Ultra courses.
     * - When sorted descending by lowerBound, The lowerBound of a symbol must be equal to the upperBound of the following symbol.  In other words,      there should be no gaps or overlaps between the symbols.
     * - The lowerBound, upperBound and absoluteValue of all symbols must be nonnegative.
     * - The text field must be unique for each symbol in a schema.
     * - The lowerBound and upperBound fields must have a maximum of 3 digits after the decimal point.
     * - The absoluteValue field must have a maximum of 3 digits after the decimal point for Classic courses, and 4 for Ultra courses.-  -  </p>
     *
     * **Since**: 3300.2.0
     */
    public static RestCall<GradeSchema> updateGradeSchema(String courseId, String schemaId, UpdateGradeSchemaBody input) {
        return RestCallBuilder
            .start(new TypeToken<GradeSchema>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/schemas/{schemaId}")
            .pathParam("courseId", courseId)
            .pathParam("schemaId", schemaId)
            .body(input)
            .build();
    }

    public static class UpdateGradeSchemaBody {
        /*
         * The externalId associated with this grade schema.
         */
        private String externalId;

        /*
         * The title of this grade schema.
         */
        private String title;

        /*
         * The description of this grade schema.
         */
        private String description;

        /*
         * The list of grade symbols for this grade schema. Only returned for Tabular scaleType schemas.
         */
        private List<GradeSymbol> symbols;

        public static UpdateGradeSchemaBody create() {
            return new UpdateGradeSchemaBody();
        }

        public UpdateGradeSchemaBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateGradeSchemaBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateGradeSchemaBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateGradeSchemaBody setSymbols(List<GradeSymbol> symbols) {
            this.symbols = symbols;
            return this;
        }
    }

    /*
     * Get Grade Columns
     *
     * Returns a list of grade columns.
     *
     * The entitlement "course.gradebook.MODIFY" is needed. Alternatively, student users may view the grade columns if they are enrolled in the course, and the mygrade tool is available in the course, and the columns are visible to the student. Observers may view grade columns if course access is allowed for observers and the associated observee is a student that satisfies all conditions required by a student user to view grade columns.
     *
     * Student or observer users may view a limited subset of grade column fields:
     *
     * - id
     * - name
     * - displayName
     * - description
     * - externalGrade
     * - contentId
     * - score.possible
     * - grading.type
     * - grading.due
     * - grading.attemptsAllowed
     * - grading.scoringModel
     *
     * **Since**: 3200.10.0
     */
    public static RestCall<List<GradeColumnV2>> getGradeColumns(String courseId, GetGradeColumnsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GradeColumnV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetGradeColumnsOption extends RestCallOption {
        /*
         * Search for grade columns associated with this content item.
         *
         * **Since**: 3000.11.0
         */
        public static GetGradeColumnsOption contentId(String contentId) {
            return parameter("contentId", contentId, new GetGradeColumnsOption());
        }

        /*
         * The 'displayName' value to use as search criteria.
         *
         * Currently only supports 'contains' searches.
         *
         * **Since**: 3300.2.0
         */
        public static GetGradeColumnsOption displayName(String displayName) {
            return parameter("displayName", displayName, new GetGradeColumnsOption());
        }
    }

    /*
     * Create Grade Column
     *
     * Create a manual grade column. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3200.10.0
     */
    public static RestCall<GradeColumnV2> createGradeColumn(String courseId, CreateGradeColumnBody input) {
        return RestCallBuilder
            .start(new TypeToken<GradeColumnV2>() {})
            .post()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateGradeColumnBody {
        /*
         * The externalId for this grade column
         */
        private String externalId;

        /*
         * The externalId for this grade column
         *
         * **Since**: 3500.2.0
         */
        private String externalToolId;

        /*
         * The name of the grade column.
         */
        private String name;

        /*
         * The display name of the grade column. Only applicable for Classic courses. Ultra courses will simply use the `name` field.
         *
         * **Since**: 3300.2.0
         */
        private String displayName;

        /*
         * The description of the grade column.
         */
        private String description;

        /*
         * Whether this grade column is an external grade column.
         */
        private boolean externalGrade;

        /*
         * Settings controlling the numerical scoring of this grade column.
         */
        private Score score;

        /*
         * Settings controlling the availability/visibility of grade column data.
         */
        private Availability availability;

        /*
         * Settings controlling whether numerical and text grade values for this grade column are calculated, determined based on attempts, or manually entered.
         */
        private Grading grading;

        /*
         * The gradebook category ID for the grade column.
         *
         * **Since**: 3400.2.0
         */
        private String gradebookCategoryId;

        /*
         * Indicates whether or not this column is included in gradebook calculations. Cannot be set for Ultra courses. Default: true
         *
         * **Since**: 3800.4.0
         */
        private boolean includeInCalculations;

        /*
         * Indicates whether or not column statistics are shown to students. Read-only for Ultra courses. Default: false
         *
         * **Since**: 3800.4.0
         */
        private boolean showStatisticsToStudents;

        public static CreateGradeColumnBody create() {
            return new CreateGradeColumnBody();
        }

        public static class Score {
            /*
             * The points possible for this grade column.
             */
            private BigDecimal possible;

            public static Score create() {
                return new Score();
            }

            public Score setPossible(BigDecimal possible) {
                this.possible = possible;
                return this;
            }
        }

        public static class Availability {
            /*
             * Whether this grade column is available to students
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may view the grade column. |
             * | No | Students may not view the grade column. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Grading {
            /*
             * The type of Grading settings for this Grade Column.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Attempts | Indicates score and grade values are determined based on user attempts |
             * | Calculated | Indicates score and grade values are determined by applying a calculated formula. |
             * | Manual | Indicates score and grade values are manually entered. |
             *
             */
            private Type type;

            /*
             * The date on which attempts are due for the grade column.
             */
            private Instant due;

            /*
             * Number of attempts allowed for the grade column.
             */
            private int attemptsAllowed;

            /*
             * The scoring model for the submitted grade column attempts.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Last |  |
             * | Highest |  |
             * | Lowest |  |
             * | First |  |
             * | Average |  |
             *
             */
            private ScoringModel scoringModel;

            /*
             * The ID of the grade schema associated with this grade column. Mutable since 3400.2.0
             *
             * **Since**: 3200.13.0
             */
            private String schemaId;

            /*
             * Settings for anonymous grading
             */
            private AnonymousGrading anonymousGrading;

            public static Grading create() {
                return new Grading();
            }

            public static class AnonymousGrading {
                /*
                 * The type of AnonymousGrading settings for this Attempts based Grade Column.
                 *
                 *
                 * | Type      | Description
                 *  | --------- | --------- |
                 * | None | Indicates anonymous grading is not enabled. |
                 * | AfterAllGraded | Indicates anonymized grades are released after all attempts have been graded. |
                 * | Date | Indicates anonymized grades are released after a specified release date. |
                 *
                 */
                private Type type;

                /*
                 * Date after which grades are released from being anonymized, if AnonymousGrading type is 'Date'.
                 */
                private Instant releaseAfter;

                public static AnonymousGrading create() {
                    return new AnonymousGrading();
                }

                public enum Type {
                    None,
                    AfterAllGraded,
                    Date
                }

                public AnonymousGrading setType(Type type) {
                    this.type = type;
                    return this;
                }

                public AnonymousGrading setReleaseAfter(Instant releaseAfter) {
                    this.releaseAfter = releaseAfter;
                    return this;
                }
            }

            public enum Type {
                Attempts,
                Calculated,
                Manual
            }

            public enum ScoringModel {
                Last,
                Highest,
                Lowest,
                First,
                Average
            }

            public Grading setType(Type type) {
                this.type = type;
                return this;
            }

            public Grading setDue(Instant due) {
                this.due = due;
                return this;
            }

            public Grading setAttemptsAllowed(int attemptsAllowed) {
                this.attemptsAllowed = attemptsAllowed;
                return this;
            }

            public Grading setScoringModel(ScoringModel scoringModel) {
                this.scoringModel = scoringModel;
                return this;
            }

            public Grading setSchemaId(String schemaId) {
                this.schemaId = schemaId;
                return this;
            }

            public Grading setAnonymousGrading(AnonymousGrading anonymousGrading) {
                this.anonymousGrading = anonymousGrading;
                return this;
            }
        }

        public CreateGradeColumnBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateGradeColumnBody setExternalToolId(String externalToolId) {
            this.externalToolId = externalToolId;
            return this;
        }

        public CreateGradeColumnBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreateGradeColumnBody setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public CreateGradeColumnBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGradeColumnBody setExternalGrade(boolean externalGrade) {
            this.externalGrade = externalGrade;
            return this;
        }

        public CreateGradeColumnBody setScore(Score score) {
            this.score = score;
            return this;
        }

        public CreateGradeColumnBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateGradeColumnBody setGrading(Grading grading) {
            this.grading = grading;
            return this;
        }

        public CreateGradeColumnBody setGradebookCategoryId(String gradebookCategoryId) {
            this.gradebookCategoryId = gradebookCategoryId;
            return this;
        }

        public CreateGradeColumnBody setIncludeInCalculations(boolean includeInCalculations) {
            this.includeInCalculations = includeInCalculations;
            return this;
        }

        public CreateGradeColumnBody setShowStatisticsToStudents(boolean showStatisticsToStudents) {
            this.showStatisticsToStudents = showStatisticsToStudents;
            return this;
        }
    }

    /*
     * Get Grade Column
     *
     * Loads a specific grade column.
     *
     * The entitlement "course.gradebook.MODIFY" is needed. Alternatively, student users may view the grade column if they are enrolled in the course, and the mygrade tool is available in the course, and the column is visible to the student. Observers may view the grade column if course access is allowed for observers and the associated observee is a student that satisfies all conditions required by a student user to view grade columns.
     *
     * Student or observer users may view a limited subset of grade column fields:
     *
     * - id
     * - name
     * - description
     * - externalGrade
     * - contentId
     * - score.possible
     * - grading.type
     * - grading.due
     * - grading.attemptsAllowed
     * - grading.scoringModel
     *
     * **Since**: 3200.10.0
     */
    public static RestCall<GradeColumnV2> getGradeColumn(String courseId, String columnId) {
        return RestCallBuilder
            .start(new TypeToken<GradeColumnV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .build();
    }

    /*
     * Delete Grade Column
     *
     * Delete a specific grade column. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3200.10.0
     */
    public static RestCall<Void> deleteGradeColumn(String courseId, String columnId, DeleteGradeColumnOption... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .options(options)
            .build();
    }

    public static class DeleteGradeColumnOption extends RestCallOption {
        public static DeleteGradeColumnOption onlyIfEmpty(boolean onlyIfEmpty) {
            return parameter("onlyIfEmpty", onlyIfEmpty, new DeleteGradeColumnOption());
        }
    }

    /*
     * Update Grade Column
     *
     * Update a manual grade column. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3200.10.0
     */
    public static RestCall<GradeColumnV2> updateGradeColumn(String courseId, String columnId, UpdateGradeColumnBody input) {
        return RestCallBuilder
            .start(new TypeToken<GradeColumnV2>() {})
            .patch()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .body(input)
            .build();
    }

    public static class UpdateGradeColumnBody {
        /*
         * The externalId for this grade column
         */
        private String externalId;

        /*
         * The externalId for this grade column
         *
         * **Since**: 3500.2.0
         */
        private String externalToolId;

        /*
         * The name of the grade column.
         */
        private String name;

        /*
         * The display name of the grade column. Only applicable for Classic courses. Ultra courses will simply use the `name` field.
         *
         * **Since**: 3300.2.0
         */
        private String displayName;

        /*
         * The description of the grade column.
         */
        private String description;

        /*
         * Whether this grade column is an external grade column.
         */
        private boolean externalGrade;

        /*
         * Settings controlling the numerical scoring of this grade column.
         */
        private Score score;

        /*
         * Settings controlling the availability/visibility of grade column data.
         */
        private Availability availability;

        /*
         * Settings controlling whether numerical and text grade values for this grade column are calculated, determined based on attempts, or manually entered.
         */
        private Grading grading;

        /*
         * The gradebook category ID for the grade column.
         *
         * **Since**: 3400.2.0
         */
        private String gradebookCategoryId;

        /*
         * Indicates whether or not this column is included in gradebook calculations. Cannot be set for Ultra courses. Default: true
         *
         * **Since**: 3800.4.0
         */
        private boolean includeInCalculations;

        /*
         * Indicates whether or not column statistics are shown to students. Read-only for Ultra courses. Default: false
         *
         * **Since**: 3800.4.0
         */
        private boolean showStatisticsToStudents;

        public static UpdateGradeColumnBody create() {
            return new UpdateGradeColumnBody();
        }

        public static class Score {
            /*
             * The points possible for this grade column.
             */
            private BigDecimal possible;

            public static Score create() {
                return new Score();
            }

            public Score setPossible(BigDecimal possible) {
                this.possible = possible;
                return this;
            }
        }

        public static class Availability {
            /*
             * Whether this grade column is available to students
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may view the grade column. |
             * | No | Students may not view the grade column. |
             *
             */
            private Available available;

            public static Availability create() {
                return new Availability();
            }

            public enum Available {
                Yes,
                No
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public static class Grading {
            /*
             * The date on which attempts are due for the grade column.
             */
            private Instant due;

            /*
             * Number of attempts allowed for the grade column.
             */
            private int attemptsAllowed;

            /*
             * The scoring model for the submitted grade column attempts.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Last |  |
             * | Highest |  |
             * | Lowest |  |
             * | First |  |
             * | Average |  |
             *
             */
            private ScoringModel scoringModel;

            /*
             * The ID of the grade schema associated with this grade column. Mutable since 3400.2.0
             *
             * **Since**: 3200.13.0
             */
            private String schemaId;

            /*
             * Settings for anonymous grading
             */
            private AnonymousGrading anonymousGrading;

            public static Grading create() {
                return new Grading();
            }

            public static class AnonymousGrading {
                /*
                 * The type of AnonymousGrading settings for this Attempts based Grade Column.
                 *
                 *
                 * | Type      | Description
                 *  | --------- | --------- |
                 * | None | Indicates anonymous grading is not enabled. |
                 * | AfterAllGraded | Indicates anonymized grades are released after all attempts have been graded. |
                 * | Date | Indicates anonymized grades are released after a specified release date. |
                 *
                 */
                private Type type;

                /*
                 * Date after which grades are released from being anonymized, if AnonymousGrading type is 'Date'.
                 */
                private Instant releaseAfter;

                public static AnonymousGrading create() {
                    return new AnonymousGrading();
                }

                public enum Type {
                    None,
                    AfterAllGraded,
                    Date
                }

                public AnonymousGrading setType(Type type) {
                    this.type = type;
                    return this;
                }

                public AnonymousGrading setReleaseAfter(Instant releaseAfter) {
                    this.releaseAfter = releaseAfter;
                    return this;
                }
            }

            public enum ScoringModel {
                Last,
                Highest,
                Lowest,
                First,
                Average
            }

            public Grading setDue(Instant due) {
                this.due = due;
                return this;
            }

            public Grading setAttemptsAllowed(int attemptsAllowed) {
                this.attemptsAllowed = attemptsAllowed;
                return this;
            }

            public Grading setScoringModel(ScoringModel scoringModel) {
                this.scoringModel = scoringModel;
                return this;
            }

            public Grading setSchemaId(String schemaId) {
                this.schemaId = schemaId;
                return this;
            }

            public Grading setAnonymousGrading(AnonymousGrading anonymousGrading) {
                this.anonymousGrading = anonymousGrading;
                return this;
            }
        }

        public UpdateGradeColumnBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateGradeColumnBody setExternalToolId(String externalToolId) {
            this.externalToolId = externalToolId;
            return this;
        }

        public UpdateGradeColumnBody setName(String name) {
            this.name = name;
            return this;
        }

        public UpdateGradeColumnBody setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public UpdateGradeColumnBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateGradeColumnBody setExternalGrade(boolean externalGrade) {
            this.externalGrade = externalGrade;
            return this;
        }

        public UpdateGradeColumnBody setScore(Score score) {
            this.score = score;
            return this;
        }

        public UpdateGradeColumnBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateGradeColumnBody setGrading(Grading grading) {
            this.grading = grading;
            return this;
        }

        public UpdateGradeColumnBody setGradebookCategoryId(String gradebookCategoryId) {
            this.gradebookCategoryId = gradebookCategoryId;
            return this;
        }

        public UpdateGradeColumnBody setIncludeInCalculations(boolean includeInCalculations) {
            this.includeInCalculations = includeInCalculations;
            return this;
        }

        public UpdateGradeColumnBody setShowStatisticsToStudents(boolean showStatisticsToStudents) {
            this.showStatisticsToStudents = showStatisticsToStudents;
            return this;
        }
    }

    /*
     * Get Column Attempts
     *
     * Returns a list of attempts associated with the specified grade column.
     *
     * The 'course.gradebook.MODIFY' entitlement is needed to view column attempts. Alternatively, if the 'userId' query parameter is specified, and the user making the request matches the specified 'userId', then the user may view his/her own attempt.  When querying an anonymous grade column, if the release criteria has not yet been met, then the 'userId' attribute will not be populated for the returned column attempts.  If the release criteria has not been met and the 'userId' query parameter is specified, a 403 response is returned, unless the requesting user matches the specified 'userId' value.
     *
     * A subset of attempt properties are available to a student when requesting his or her own attempts:
     *
     * - id
     * - userId
     * - groupAttemptId
     * - status
     * - displayGrade.scaleType
     * - displayGrade.score
     * - displayGrade.text
     * - groupOverride
     * - feedback
     * - studentComments
     * - studentSubmission
     * - exempt
     * - created
     *
     * When this endpoint is called by the API Gateway User, the response will only contain attributes visible to a Grader. If an Attempt is InProgress, then a Student's submission & comments would not be visible to the API Gateway User. If an Attempt is NeedsGrading, then a Student's submission & comments are visible to the API Gateway User. </p> If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure taking is enabled, and the attempt status is InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure reviewing is enabled, and the attempt status is not InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<List<AttemptV2>> getColumnAttempts(String courseId, String columnId, GetColumnAttemptsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<AttemptV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/attempts")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .options(options)
            .build();
    }

    public static class GetColumnAttemptsOption extends RestCallOption {
        /*
         * Search for grade column attempts submitted by this user. This may be the primary ID, or any of the secondary IDs prefixed with the ID type.
         *
         *  | ID type    | Example                               |
         *  |------------|---------------------------------------|
         *  | primary    | _123_1                                |
         *  | externalId | externalId:jsmith                     |
         *  | userName   | userName:jsmith                       |
         *  | uuid       | uuid:915c7567d76d444abf1eed56aad3beb5 |
         *
         *
         * **Since**: 3100.4.0
         */
        public static GetColumnAttemptsOption userId(String userId) {
            return parameter("userId", userId, new GetColumnAttemptsOption());
        }

        /*
         * Search for grade column attempts with one of these statuses.
         *
         * **Since**: 3100.4.0
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
        public static GetColumnAttemptsOption attemptStatuses(String attemptStatuses) {
            return parameter("attemptStatuses", attemptStatuses, new GetColumnAttemptsOption());
        }

        /*
         * Search for attempts with created date relative to this value. 'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.0.0
         */
        public static GetColumnAttemptsOption created(Instant created) {
            return parameter("created", created, new GetColumnAttemptsOption());
        }

        /*
         * Used alongside the 'created' search parameter. Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetColumnAttemptsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetColumnAttemptsOption());
        }

        /*
         * Search for attempts with modified date relative to this value. 'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.0.0
         */
        public static GetColumnAttemptsOption modified(Instant modified) {
            return parameter("modified", modified, new GetColumnAttemptsOption());
        }

        /*
         * Used alongside the 'modified' search parameter. Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetColumnAttemptsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetColumnAttemptsOption());
        }

        /*
         * Search for attempts with attempt date relative to this value. 'attemptDateCompare' may also be sent to control search behavior.
         *
         * **Since**: 3800.0.0
         */
        public static GetColumnAttemptsOption attemptDate(Instant attemptDate) {
            return parameter("attemptDate", attemptDate, new GetColumnAttemptsOption());
        }

        /*
         * Used alongside the 'attemptDate' search parameter. Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3800.0.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetColumnAttemptsOption attemptDateCompare(String attemptDateCompare) {
            return parameter("attemptDateCompare", attemptDateCompare, new GetColumnAttemptsOption());
        }
    }

    /*
     * Create Column Attempt
     *
     * Create an Attempt on the specified Grade Column. Currently supports Classic and Ultra Course Assignments. Student attributes (studentSubmission & studentComments) can only be specified by Student Users. Grader attributes (text, score, notes & feedback, attemptDate) can only be specified by Grader Users. Graders must have the entitlement "course.gradebook.MODIFY" for the course.  Graders are allowed to create attempts that contain "studentSubmission" text on behalf of a student if the authenticated application for this request has the "course.attempt.nonowner.SUBMIT" entitlement and the attempt has a "status" of NeedsGrading. </p> If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure taking is enabled, then the caller must be in a secure browser in order to create the attempt.
     *
     * **Since**: 3300.12.0
     */
    public static RestCall<AttemptV2> createColumnAttempt(String columnId, String courseId, CreateColumnAttemptBody attemptInput) {
        return RestCallBuilder
            .start(new TypeToken<AttemptV2>() {})
            .post()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/attempts")
            .pathParam("columnId", columnId)
            .pathParam("courseId", courseId)
            .body(attemptInput)
            .build();
    }

    public static class CreateColumnAttemptBody {
        /*
         * The user ID associated with this attempt.  Defaults to the authenticated user on create.  Can be specified as a user other than the authenticated user if the authenticated user has the "course.gradebook.MODIFY" entitlement and the authenticated application has the "course.attempt.nonowner.SUBMIT" entitlement.
         */
        private String userId;

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
         * Return the attempt date associated with this attempt.
         */
        private Instant attemptDate;

        public static CreateColumnAttemptBody create() {
            return new CreateColumnAttemptBody();
        }

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

        public CreateColumnAttemptBody setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public CreateColumnAttemptBody setStatus(Status status) {
            this.status = status;
            return this;
        }

        public CreateColumnAttemptBody setText(String text) {
            this.text = text;
            return this;
        }

        public CreateColumnAttemptBody setScore(BigDecimal score) {
            this.score = score;
            return this;
        }

        public CreateColumnAttemptBody setReconciliationMode(ReconciliationMode reconciliationMode) {
            this.reconciliationMode = reconciliationMode;
            return this;
        }

        public CreateColumnAttemptBody setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public CreateColumnAttemptBody setFeedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public CreateColumnAttemptBody setStudentComments(String studentComments) {
            this.studentComments = studentComments;
            return this;
        }

        public CreateColumnAttemptBody setStudentSubmission(String studentSubmission) {
            this.studentSubmission = studentSubmission;
            return this;
        }

        public CreateColumnAttemptBody setExempt(boolean exempt) {
            this.exempt = exempt;
            return this;
        }

        public CreateColumnAttemptBody setAttemptDate(Instant attemptDate) {
            this.attemptDate = attemptDate;
            return this;
        }
    }

    /*
     * Get Column Attempt
     *
     * Loads the grade column attempt for the specified id.
     *
     * The 'course.gradebook.MODIFY' entitlement is needed to view an attempt. Alternatively, if the user making the request is also the user associated with the attempt grade, then the user may view his/her own attempt.  When accessing an anonymous grade column attempt, if the release criteria has not yet been met, then the 'userId' attribute will not be populated for the returned attempt.
     *
     * A subset of attempt properties are available to a student when requesting his or her own attempt:
     *
     * - id
     * - userId
     * - groupAttemptId
     * - status
     * - displayGrade.scaleType
     * - displayGrade.score
     * - displayGrade.text
     * - groupOverride
     * - feedback
     * - studentComments
     * - studentSubmission
     * - exempt
     * - created
     *
     * When this endpoint is called by the API Gateway User, the response will only contain attributes visible to a Grader. If an Attempt is InProgress, then a Student's submission & comments would not be visible to the API Gateway User. If an Attempt is NeedsGrading, then a Student's submission & comments are visible to the API Gateway User. </p> If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure taking is enabled, and the attempt status is InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure reviewing is enabled, and the attempt status is not InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<AttemptV2> getColumnAttempt(String courseId, String columnId, String attemptId) {
        return RestCallBuilder
            .start(new TypeToken<AttemptV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/attempts/{attemptId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .pathParam("attemptId", attemptId)
            .build();
    }

    /*
     * Update Column Attempt
     *
     * Update an existing Attempt on a Grade Column. </p> Students can only modify the studentSubmission, studentComments and status of their own attempt if the status is InProgress. The status can only be set to NeedsGrading.  Doing so is the equivalent of submitting the attempt. </p> Instructors can modify all mutable fields but studentSubmission and studentComments as long as the status is not InProgress. Setting the status to Complete is the equivalent of posting a graded attempt.  The "course.gradebook.MODIFY" entitlement is required to update score, text, notes, feedback and set the status to Complete. </p> If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure taking is enabled, then the caller must be in a secure browser in order to create the attempt. Classic course support since 3500.2.0
     *
     * **Since**: 3300.12.0
     */
    public static RestCall<AttemptV2> updateColumnAttempt(String columnId, String attemptId, String courseId, UpdateColumnAttemptBody attemptInput) {
        return RestCallBuilder
            .start(new TypeToken<AttemptV2>() {})
            .patch()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/attempts/{attemptId}")
            .pathParam("columnId", columnId)
            .pathParam("attemptId", attemptId)
            .pathParam("courseId", courseId)
            .body(attemptInput)
            .build();
    }

    public static class UpdateColumnAttemptBody {
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

        public static UpdateColumnAttemptBody create() {
            return new UpdateColumnAttemptBody();
        }

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

        public UpdateColumnAttemptBody setStatus(Status status) {
            this.status = status;
            return this;
        }

        public UpdateColumnAttemptBody setText(String text) {
            this.text = text;
            return this;
        }

        public UpdateColumnAttemptBody setScore(BigDecimal score) {
            this.score = score;
            return this;
        }

        public UpdateColumnAttemptBody setReconciliationMode(ReconciliationMode reconciliationMode) {
            this.reconciliationMode = reconciliationMode;
            return this;
        }

        public UpdateColumnAttemptBody setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public UpdateColumnAttemptBody setFeedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public UpdateColumnAttemptBody setStudentComments(String studentComments) {
            this.studentComments = studentComments;
            return this;
        }

        public UpdateColumnAttemptBody setStudentSubmission(String studentSubmission) {
            this.studentSubmission = studentSubmission;
            return this;
        }

        public UpdateColumnAttemptBody setExempt(boolean exempt) {
            this.exempt = exempt;
            return this;
        }
    }

    /*
     * Get Column Grades
     *
     * Returns a list of grades associated with the specified grade column.  By default this operation does not include 'ReadyToPost' grades when returning grade details for calculated grade columns. This can be changed by setting the query parameter "includeUnpostedGrades" to true. The columns considered as 'ReadyToPost' are those which have a grade associated but have the status NEEDS_GRADING.
     *
     * Users with entitlement 'course.gradebook.MODIFY' can retrieve grades for any or all enrolled users. Requests for grades in a columns whose attempts are not visible to instructors will return with a status of "403 - Forbidden."
     *
     * Enrolled users without the 'course.gradebook.MODIFY' entitlement may only view their own grade; such users cannot retrieve grades of other users.  A request for the grade in a columns that has been hidden from students in the gradebook will return with a status "403 - Forbidden.".  A subset of grade properties are available to a student when requesting his or her own grades:
     *
     * - userId
     * - columnId
     * - status
     * - displayGrade
     * - exempt
     * - feedback
     * - changeIndex
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<List<GradeV2>> getColumnGrades(String courseId, String columnId, GetColumnGradesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GradeV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/users")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .options(options)
            .build();
    }

    public static class GetColumnGradesOption extends RestCallOption {
        /*
         * Retrieve only items modified after the given change index.
         *
         * **Since**: 3300.4.0
         */
        public static GetColumnGradesOption changeIndex(long changeIndex) {
            return parameter("changeIndex", changeIndex, new GetColumnGradesOption());
        }

        /*
         * If true, calculated columns exposed in the response will be processed such that any unposted grades are included in their calculations. If false, only posted grades will be included in calculations. Entitlements course.gradebook-grades.VIEW, course.gradebook.MODIFY and course.gradebook-grades.EXECUTE are required to use this parameter.
         *
         * **Since**: 3800.4.0
         */
        public static GetColumnGradesOption includeUnpostedGrades(boolean includeUnpostedGrades) {
            return parameter("includeUnpostedGrades", includeUnpostedGrades, new GetColumnGradesOption());
        }
    }

    /*
     * Get Column Grade Last Changed
     *
     * Loads the grade column grade with the maximum change index. This change index can be used to determine the relative order in which the grades were created and/or updated. This operation does not include 'ReadyToPost' grades when determining the maximum change index grade.
     *
     * Users with entitlement 'course.gradebook.MODIFY' can retrieve grades for any or all enrolled users. Requests for grades in a columns whose attempts are not visible to instructors will return with a status of "403 - Forbidden."
     *
     * Enrolled users without the 'course.gradebook.MODIFY' entitlement may only view their own grade; such users cannot retrieve grades of other users. A request for the grade in a columns that has been hidden from students in the gradebook will return with a status "403 - Forbidden.".
     *
     * **Since**: 3300.4.0
     */
    public static RestCall<GradeV2> getColumnGradeLastChanged(String courseId, String columnId) {
        return RestCallBuilder
            .start(new TypeToken<GradeV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/users/lastChanged")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .build();
    }

    /*
     * Get Column Grade
     *
     * Loads the grade column grade for a specific user.  If grade details have yet to be entered for the specified user, then no grade details will be included in the returned grade object.  This operation does not include 'ReadyToPost' grades when returning grade details for calculated grade columns.
     *
     * Users with entitlement 'course.gradebook.MODIFY' can retrieve grades for any or all enrolled users. Requests for grades in a columns whose attempts are not visible to instructors will return with a status of "403 - Forbidden."
     *
     * Enrolled users without the 'course.gradebook.MODIFY' entitlement may only view their own grade; such users cannot retrieve grades of other users.  A request for the grade in a columns that has been hidden from students in the gradebook will return with a status "403 - Forbidden.".  A subset of grade properties are available to a student when requesting his or her own grades:
     *
     * - userId
     * - columnId
     * - status
     * - displayGrade
     * - exempt
     * - feedback
     * - changeIndex
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<GradeV2> getColumnGrade(String courseId, String columnId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<GradeV2>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .pathParam("userId", userId)
            .build();
    }

    /*
     * Update Column Grade
     *
     * Update the grade column grade for a specific user, including the text grade, score, instructor notes and feedback, and exempt status.  When updating text grade or score, the resulting grade is always marked as 'Posted'.  This end-point, currently, does not support marking the grade as 'ReadyToPost'.  Grade overrides may be cleared by either specifying the 'score' attribute as null, or the 'text'; attribute as null, '', or '-' in the body of the request. The entitlement 'course.gradebook.MODIFY' is required to perform this operation.
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<GradeV2> updateColumnGrade(String courseId, String columnId, String userId, UpdateColumnGradeBody input) {
        return RestCallBuilder
            .start(new TypeToken<GradeV2>() {})
            .patch()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/columns/{columnId}/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .pathParam("userId", userId)
            .body(input)
            .build();
    }

    public static class UpdateColumnGradeBody {
        /*
         * The text representation of this grade.
         */
        private String text;

        /*
         * The score associated with this grade.
         */
        private BigDecimal score;

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
         * The Id of a Grade Notation which can be optionally associated with this Grade. If a Grade Notation is specified for this Grade, then the DisplayGrade's Text attribute will contain the Grade Notation's Description.
         */
        private String gradeNotationId;

        public static UpdateColumnGradeBody create() {
            return new UpdateColumnGradeBody();
        }

        public UpdateColumnGradeBody setText(String text) {
            this.text = text;
            return this;
        }

        public UpdateColumnGradeBody setScore(BigDecimal score) {
            this.score = score;
            return this;
        }

        public UpdateColumnGradeBody setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public UpdateColumnGradeBody setFeedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public UpdateColumnGradeBody setExempt(boolean exempt) {
            this.exempt = exempt;
            return this;
        }

        public UpdateColumnGradeBody setGradeNotationId(String gradeNotationId) {
            this.gradeNotationId = gradeNotationId;
            return this;
        }
    }

    /*
     * Get User Grades
     *
     * Loads the course grades for a specific user.
     *
     * Users with entitlement "course.gradebook.MODIFY" have read access to all the properties of the collection results.
     *
     * Users without entitlement "course.gradebook.MODIFY" requesting grades for themselves (i.e., userId = current user id) have read access to a restricted subset of properties of the collections result. These are the properties available to a student when requesting his or her own grades:
     *
     * - userId
     * - columnId
     * - status
     * - text
     * - score
     * - exempt
     * - feedback
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<List<GradeV2>> getUserGrades(String courseId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<List<GradeV2>>() {})
            .get()
            .url("/learn/api/public/v2/courses/{courseId}/gradebook/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .build();
    }
}
