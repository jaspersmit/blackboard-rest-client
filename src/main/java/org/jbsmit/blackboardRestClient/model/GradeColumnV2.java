package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;
import java.math.BigDecimal;

public class GradeColumnV2 {
    /*
     * The primary ID of the grade column.
     */
    private String id;

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
     * The date this grade column was created.
     */
    private Instant created;

    /*
     * For grade columns associated with a content item, the ID of the content item.
     *
     * **Since**: 3000.11.0
     */
    private String contentId;

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
     * The formula used for determining the value for the grade column, if it is a calculated column.
     *
     * **Since**: 3400.5.0
     */
    private GradingFormulaV2 formula;

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


    public static class Score {
        /*
         * The points possible for this grade column.
         */
        private BigDecimal possible;

        public static Score create() {
            return new Score();
        }

        public BigDecimal getPossible() {
            return possible;
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

        public Available getAvailable() {
            return available;
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

            public Type getType() {
                return type;
            }

            public AnonymousGrading setType(Type type) {
                this.type = type;
                return this;
            }

            public Instant getReleaseAfter() {
                return releaseAfter;
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

        public Type getType() {
            return type;
        }

        public Grading setType(Type type) {
            this.type = type;
            return this;
        }

        public Instant getDue() {
            return due;
        }

        public Grading setDue(Instant due) {
            this.due = due;
            return this;
        }

        public int getAttemptsAllowed() {
            return attemptsAllowed;
        }

        public Grading setAttemptsAllowed(int attemptsAllowed) {
            this.attemptsAllowed = attemptsAllowed;
            return this;
        }

        public ScoringModel getScoringModel() {
            return scoringModel;
        }

        public Grading setScoringModel(ScoringModel scoringModel) {
            this.scoringModel = scoringModel;
            return this;
        }

        public String getSchemaId() {
            return schemaId;
        }

        public Grading setSchemaId(String schemaId) {
            this.schemaId = schemaId;
            return this;
        }

        public AnonymousGrading getAnonymousGrading() {
            return anonymousGrading;
        }

        public Grading setAnonymousGrading(AnonymousGrading anonymousGrading) {
            this.anonymousGrading = anonymousGrading;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public GradeColumnV2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public GradeColumnV2 setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getExternalToolId() {
        return externalToolId;
    }

    public GradeColumnV2 setExternalToolId(String externalToolId) {
        this.externalToolId = externalToolId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GradeColumnV2 setName(String name) {
        this.name = name;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public GradeColumnV2 setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GradeColumnV2 setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getExternalGrade() {
        return externalGrade;
    }

    public GradeColumnV2 setExternalGrade(boolean externalGrade) {
        this.externalGrade = externalGrade;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public GradeColumnV2 setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public String getContentId() {
        return contentId;
    }

    public GradeColumnV2 setContentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public GradeColumnV2 setScore(Score score) {
        this.score = score;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public GradeColumnV2 setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Grading getGrading() {
        return grading;
    }

    public GradeColumnV2 setGrading(Grading grading) {
        this.grading = grading;
        return this;
    }

    public String getGradebookCategoryId() {
        return gradebookCategoryId;
    }

    public GradeColumnV2 setGradebookCategoryId(String gradebookCategoryId) {
        this.gradebookCategoryId = gradebookCategoryId;
        return this;
    }

    public GradingFormulaV2 getFormula() {
        return formula;
    }

    public GradeColumnV2 setFormula(GradingFormulaV2 formula) {
        this.formula = formula;
        return this;
    }

    public boolean getIncludeInCalculations() {
        return includeInCalculations;
    }

    public GradeColumnV2 setIncludeInCalculations(boolean includeInCalculations) {
        this.includeInCalculations = includeInCalculations;
        return this;
    }

    public boolean getShowStatisticsToStudents() {
        return showStatisticsToStudents;
    }

    public GradeColumnV2 setShowStatisticsToStudents(boolean showStatisticsToStudents) {
        this.showStatisticsToStudents = showStatisticsToStudents;
        return this;
    }
}

