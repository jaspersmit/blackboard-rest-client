package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.Term;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class TermsApi {
    /*
     * Get Terms
     *
     * Returns a list of terms.
     *
     * At least one of the entitlements 'system.term.VIEW' or 'system.term.MODIFY' are needed.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<List<Term>> getTerms(GetTermsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Term>>() {})
            .get()
            .url("/learn/api/public/v1/terms")
            .options(options)
            .build();
    }

    public static class GetTermsOption extends RestCallOption {
        /*
         * Search for term with externalId properties that contain this value.
         *
         * **Since**: 3100.6.0
         */
        public static GetTermsOption externalId(String externalId) {
            return parameter("externalId", externalId, new GetTermsOption());
        }

        /*
         * Search for term with this dataSourceId.
         *
         * **Since**: 3100.6.0
         */
        public static GetTermsOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetTermsOption());
        }

        /*
         * Search for users with availability.available properties that contain this value.
         *
         * **Since**: 3100.6.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Yes | Students may access the term and the courses it contains. |
         * | No | Students may not access the term or the courses it contains. |
         *
         */
        public static GetTermsOption availability_available(String availability_available) {
            return parameter("availability.available", availability_available, new GetTermsOption());
        }
    }

    /*
     * Create Term
     *
     * Creates a term.
     *
     * The 'system.term.MODIFY' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Term> createTerm(CreateTermBody input) {
        return RestCallBuilder
            .start(new TypeToken<Term>() {})
            .post()
            .url("/learn/api/public/v1/terms")
            .body(input)
            .build();
    }

    public static class CreateTermBody {
        /*
         * An externally-defined unique ID for the term.
         *
         * Formerly known as 'sourcedidId'.
         */
        private String externalId;

        /*
         * The ID of the data source associated with this term.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         */
        private String dataSourceId;

        /*
         * The name of the term.
         */
        private String name;

        /*
         * The description of the term. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the term to students.
         */
        private Availability availability;

        public static CreateTermBody create() {
            return new CreateTermBody();
        }

        public static class Availability {
            /*
             * Whether the term and the courses it contains are available to students.  Instructors can always access their courses.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the term and the courses it contains. |
             * | No | Students may not access the term or the courses it contains. |
             *
             */
            private Available available;

            /*
             * Settings controlling the length of time the term is available.
             */
            private Duration duration;

            public static Availability create() {
                return new Availability();
            }

            public static class Duration {
                /*
                 * The intended length of the term.  Possible values are:
                 *
                 *
                 * | Type      | Description
                 *  | --------- | --------- |
                 * | Continuous | The term is active on an ongoing basis. This is the default. |
                 * | DateRange | The term will only be available between specific date ranges. |
                 * | FixedNumDays | The term will only be available for a set number of days. |
                 *
                 */
                private Type type;

                /*
                 * The date this term starts.  May only be set if availability.duration.type is DateRange.
                 */
                private Instant start;

                /*
                 * The date this term ends.  May only be set if availability.duration.type is DateRange.
                 */
                private Instant end;

                /*
                 * The number of days courses within this term can be used.  May only be set if availability.duration.type is FixedNumDays.
                 */
                private int daysOfUse;

                public static Duration create() {
                    return new Duration();
                }

                public enum Type {
                    Continuous,
                    DateRange,
                    FixedNumDays
                }

                public Duration setType(Type type) {
                    this.type = type;
                    return this;
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
                }

                public Duration setDaysOfUse(int daysOfUse) {
                    this.daysOfUse = daysOfUse;
                    return this;
                }
            }

            public enum Available {
                Yes,
                No
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }

            public Availability setDuration(Duration duration) {
                this.duration = duration;
                return this;
            }
        }

        public CreateTermBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateTermBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public CreateTermBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreateTermBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateTermBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }
    }

    /*
     * Get Term
     *
     * Loads a term.
     *
     * The caller must be enrolled in a course contained within the term, or must have at least one of the entitlements 'system.term.VIEW' or 'system.term.MODIFY'.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Term> getTerm(String termId) {
        return RestCallBuilder
            .start(new TypeToken<Term>() {})
            .get()
            .url("/learn/api/public/v1/terms/{termId}")
            .pathParam("termId", termId)
            .build();
    }

    /*
     * Delete Term
     *
     * Deletes a term.
     *
     * The 'system.term.MODIFY' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Void> deleteTerm(String termId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/terms/{termId}")
            .pathParam("termId", termId)
            .build();
    }

    /*
     * Update Term
     *
     * Updates a term.
     *
     * The 'system.term.MODIFY' entitlement is needed.
     *
     * **Since**: 2015.11.0
     */
    public static RestCall<Term> updateTerm(String termId, UpdateTermBody input) {
        return RestCallBuilder
            .start(new TypeToken<Term>() {})
            .patch()
            .url("/learn/api/public/v1/terms/{termId}")
            .pathParam("termId", termId)
            .body(input)
            .build();
    }

    public static class UpdateTermBody {
        /*
         * An externally-defined unique ID for the term.
         *
         * Formerly known as 'sourcedidId'.
         */
        private String externalId;

        /*
         * The ID of the data source associated with this term.  This may optionally be the data source's externalId using the syntax "externalId:math101".
         */
        private String dataSourceId;

        /*
         * The name of the term.
         */
        private String name;

        /*
         * The description of the term. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String description;

        /*
         * Settings controlling availability of the term to students.
         */
        private Availability availability;

        public static UpdateTermBody create() {
            return new UpdateTermBody();
        }

        public static class Availability {
            /*
             * Whether the term and the courses it contains are available to students.  Instructors can always access their courses.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes | Students may access the term and the courses it contains. |
             * | No | Students may not access the term or the courses it contains. |
             *
             */
            private Available available;

            /*
             * Settings controlling the length of time the term is available.
             */
            private Duration duration;

            public static Availability create() {
                return new Availability();
            }

            public static class Duration {
                /*
                 * The intended length of the term.  Possible values are:
                 *
                 *
                 * | Type      | Description
                 *  | --------- | --------- |
                 * | Continuous | The term is active on an ongoing basis. This is the default. |
                 * | DateRange | The term will only be available between specific date ranges. |
                 * | FixedNumDays | The term will only be available for a set number of days. |
                 *
                 */
                private Type type;

                /*
                 * The date this term starts.  May only be set if availability.duration.type is DateRange.
                 */
                private Instant start;

                /*
                 * The date this term ends.  May only be set if availability.duration.type is DateRange.
                 */
                private Instant end;

                /*
                 * The number of days courses within this term can be used.  May only be set if availability.duration.type is FixedNumDays.
                 */
                private int daysOfUse;

                public static Duration create() {
                    return new Duration();
                }

                public enum Type {
                    Continuous,
                    DateRange,
                    FixedNumDays
                }

                public Duration setType(Type type) {
                    this.type = type;
                    return this;
                }

                public Duration setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public Duration setEnd(Instant end) {
                    this.end = end;
                    return this;
                }

                public Duration setDaysOfUse(int daysOfUse) {
                    this.daysOfUse = daysOfUse;
                    return this;
                }
            }

            public enum Available {
                Yes,
                No
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }

            public Availability setDuration(Duration duration) {
                this.duration = duration;
                return this;
            }
        }

        public UpdateTermBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateTermBody setDataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public UpdateTermBody setName(String name) {
            this.name = name;
            return this;
        }

        public UpdateTermBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateTermBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }
    }
}
