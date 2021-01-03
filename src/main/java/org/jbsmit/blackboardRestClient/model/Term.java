package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class Term {
    /*
     * The primary ID of the term.
     */
    private String id;

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

            public Type getType() {
                return type;
            }

            public Duration setType(Type type) {
                this.type = type;
                return this;
            }

            public Instant getStart() {
                return start;
            }

            public Duration setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Instant getEnd() {
                return end;
            }

            public Duration setEnd(Instant end) {
                this.end = end;
                return this;
            }

            public int getDaysOfUse() {
                return daysOfUse;
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

        public Available getAvailable() {
            return available;
        }

        public Availability setAvailable(Available available) {
            this.available = available;
            return this;
        }

        public Duration getDuration() {
            return duration;
        }

        public Availability setDuration(Duration duration) {
            this.duration = duration;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public Term setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public Term setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public Term setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Term setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Term setDescription(String description) {
        this.description = description;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Term setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }
}

