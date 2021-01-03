package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;
import java.math.BigDecimal;

public class GradeColumn {
    /*
     * The primary ID of the grade column.
     */
    private String id;

    /*
     * The externalId for this grade column
     */
    private String externalId;

    /*
     * The name of the grade column.
     */
    private String name;

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


    public static class Score {
        /*
         * The points possible for this grade column.
         */
        private BigDecimal possible;

        /*
         * Decimal place precision used to display scores for this grade column.
         *
         * **Deprecated**: since 3200.10.0; no alternative exists since this field never fully functioned as described.
         */
        private int decimalPlaces;

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

        public int getDecimalPlaces() {
            return decimalPlaces;
        }

        public Score setDecimalPlaces(int decimalPlaces) {
            this.decimalPlaces = decimalPlaces;
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

    public GradeColumn setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public GradeColumn setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GradeColumn setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GradeColumn setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getExternalGrade() {
        return externalGrade;
    }

    public GradeColumn setExternalGrade(boolean externalGrade) {
        this.externalGrade = externalGrade;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public GradeColumn setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public String getContentId() {
        return contentId;
    }

    public GradeColumn setContentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public GradeColumn setScore(Score score) {
        this.score = score;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public GradeColumn setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public Grading getGrading() {
        return grading;
    }

    public GradeColumn setGrading(Grading grading) {
        this.grading = grading;
        return this;
    }
}

