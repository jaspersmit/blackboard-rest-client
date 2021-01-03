package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Attempt;
import org.jbsmit.blackboardRestClient.model.Grade;
import org.jbsmit.blackboardRestClient.model.GradeColumn;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class Deprecated_CourseGradesApi {
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
     * - description
     * - externalGrade
     * - contentId
     * - score.possible
     * - grading.type
     * - grading.due
     * - grading.attemptsAllowed
     * - grading.scoringModel
     *
     * **Since**: 3000.3.0
     *
     * **Deprecated**: since 3200.10.0; use the v2 end-point instead
     */
    public static RestCall<List<GradeColumn>> getGradeColumns(String courseId, GetGradeColumnsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<GradeColumn>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns")
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
    }

    /*
     * Create Grade Column
     *
     * Create a manual grade column. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3000.7.0
     *
     * **Deprecated**: since 3200.10.0; use the v2 end-point instead
     */
    public static RestCall<GradeColumn> createGradeColumn(String courseId, CreateGradeColumnBody input) {
        return RestCallBuilder
            .start(new TypeToken<GradeColumn>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns")
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

        public static CreateGradeColumnBody create() {
            return new CreateGradeColumnBody();
        }

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

            public Score setPossible(BigDecimal possible) {
                this.possible = possible;
                return this;
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

            public Grading setAnonymousGrading(AnonymousGrading anonymousGrading) {
                this.anonymousGrading = anonymousGrading;
                return this;
            }
        }

        public CreateGradeColumnBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateGradeColumnBody setName(String name) {
            this.name = name;
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
     * **Since**: 3000.3.0
     *
     * **Deprecated**: since 3200.10.0; use the v2 end-point instead
     */
    public static RestCall<GradeColumn> getGradeColumn(String courseId, String columnId) {
        return RestCallBuilder
            .start(new TypeToken<GradeColumn>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .build();
    }

    /*
     * Delete Grade Column
     *
     * Delete a specific grade column. The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3000.7.0
     *
     * **Deprecated**: since 3200.10.0; use the v2 end-point instead
     */
    public static RestCall<Void> deleteGradeColumn(String courseId, String columnId, DeleteGradeColumnOption... options) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}")
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
     * **Since**: 3000.7.0
     *
     * **Deprecated**: since 3200.10.0; use the v2 end-point instead
     */
    public static RestCall<GradeColumn> updateGradeColumn(String courseId, String columnId, UpdateGradeColumnBody input) {
        return RestCallBuilder
            .start(new TypeToken<GradeColumn>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}")
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

        public static UpdateGradeColumnBody create() {
            return new UpdateGradeColumnBody();
        }

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

            public Score setPossible(BigDecimal possible) {
                this.possible = possible;
                return this;
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

            public Grading setAnonymousGrading(AnonymousGrading anonymousGrading) {
                this.anonymousGrading = anonymousGrading;
                return this;
            }
        }

        public UpdateGradeColumnBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateGradeColumnBody setName(String name) {
            this.name = name;
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
     * - text
     * - score
     * - groupOverride
     * - feedback
     * - studentComments
     * - studentSubmission
     * - exempt
     * - created
     * When this endpoint is called by the API Gateway User, the response will only contain attributes visible to a Grader. If an Attempt is InProgress, then a Student's submission & comments would not be visible to the API Gateway User. If an Attempt is NeedsGrading, then a Student's submission & comments are visible to the API Gateway User.
     *
     * If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure taking is enabled, and the attempt status is InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure reviewing is enabled, and the attempt status is not InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * **Since**: 3100.4.0
     *
     * **Deprecated**: since 3300.0.0; use the v2 end-point instead
     */
    public static RestCall<List<Attempt>> getColumnAttempts(String courseId, String columnId, GetColumnAttemptsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Attempt>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}/attempts")
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
     * - text
     * - score
     * - groupOverride
     * - feedback
     * - studentComments
     * - studentSubmission
     * - exempt
     * - created
     * When this endpoint is called by the API Gateway User, the response will only contain attributes visible to a Grader. If an Attempt is InProgress, then a Student's submission & comments would not be visible to the API Gateway User. If an Attempt is NeedsGrading, then a Student's submission & comments are visible to the API Gateway User. </p> If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure taking is enabled, and the attempt status is InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * If the caller has the course.assessment.EXECUTE entitlement, and the attempt is associated with an assessment where the flag to require secure reviewing is enabled, and the attempt status is not InProgress, then the studentSubmission is omitted unless the call comes from a secure browser.
     *
     * **Since**: 3100.4.0
     *
     * **Deprecated**: since 3300.0.0; use the v2 end-point instead
     */
    public static RestCall<Attempt> getColumnAttempt(String courseId, String columnId, String attemptId) {
        return RestCallBuilder
            .start(new TypeToken<Attempt>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}/attempts/{attemptId}")
            .pathParam("courseId", courseId)
            .pathParam("columnId", columnId)
            .pathParam("attemptId", attemptId)
            .build();
    }

    /*
     * Get Column Grades
     *
     * Returns a list of grades associated with the specified grade column.  This operation does not include 'ReadyToPost' grades when returning grade details for calculated grade columns.
     *
     * Users with entitlement 'course.gradebook.MODIFY' can retrieve grades for any or all enrolled users. Requests for grades in a columns whose attempts are not visible to instructors will return with a status of "403 - Forbidden."
     *
     * Enrolled users without the 'course.gradebook.MODIFY' entitlement may only view their own grade; such users cannot retrieve grades of other users.  A request for the grade in a columns that has been hidden from students in the gradebook will return with a status "403 - Forbidden.".  A subset of grade properties are available to a student when requesting his or her own grades:
     *
     * - userId
     * - columnId
     * - status
     * - text
     * - score
     * - exempt
     * - feedback
     *
     * **Since**: 3000.3.0
     *
     * **Deprecated**: since 3300.0.0; use the v2 end-point instead
     */
    public static RestCall<List<Grade>> getColumnGrades(String courseId, String columnId) {
        return RestCallBuilder
            .start(new TypeToken<List<Grade>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}/users")
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
     * - text
     * - score
     * - exempt
     * - feedback
     *
     * **Since**: 3000.3.0
     *
     * **Deprecated**: since 3300.0.0; use the v2 end-point instead
     */
    public static RestCall<Grade> getColumnGrade(String courseId, String columnId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<Grade>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}/users/{userId}")
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
     * **Since**: 3000.5.0
     *
     * **Deprecated**: since 3300.0.0; use the v2 end-point instead
     */
    public static RestCall<Grade> updateColumnGrade(String courseId, String columnId, String userId, UpdateColumnGradeBody input) {
        return RestCallBuilder
            .start(new TypeToken<Grade>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/columns/{columnId}/users/{userId}")
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
     * **Since**: 3000.3.0
     *
     * **Deprecated**: since 3300.0.0; use the v2 end-point instead
     */
    public static RestCall<List<Grade>> getUserGrades(String courseId, String userId) {
        return RestCallBuilder
            .start(new TypeToken<List<Grade>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/users/{userId}")
            .pathParam("courseId", courseId)
            .pathParam("userId", userId)
            .build();
    }
}
