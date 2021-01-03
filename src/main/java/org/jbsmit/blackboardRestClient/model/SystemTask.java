package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class SystemTask {
    /*
     * The ID of this task.
     */
    private String id;

    /*
     * The type value associated with the task.
     */
    private String type;

    /*
     * The status of the task.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Queued | initial state of a task |
     * | Assigned |  |
     * | Running |  |
     * | Complete |  |
     * | CompleteWithErrors |  |
     * | Incomplete |  |
     *
     */
    private Status status;

    /*
     * Task progress, with 0 representing not started and 100 representing done.
     */
    private int percentComplete;

    /*
     * The date the task was started.
     */
    private Instant started;

    /*
     * The date the task was completed.
     */
    private Instant ended;

    /*
     * The results of the task execution. This may be null if execution is not yet complete or no results were saved.
     */
    private SystemTaskResult results;


    public enum Status {
        Queued,
        Assigned,
        Running,
        Complete,
        CompleteWithErrors,
        Incomplete
    }

    public String getId() {
        return id;
    }

    public SystemTask setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public SystemTask setType(String type) {
        this.type = type;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public SystemTask setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getPercentComplete() {
        return percentComplete;
    }

    public SystemTask setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
        return this;
    }

    public Instant getStarted() {
        return started;
    }

    public SystemTask setStarted(Instant started) {
        this.started = started;
        return this;
    }

    public Instant getEnded() {
        return ended;
    }

    public SystemTask setEnded(Instant ended) {
        this.ended = ended;
        return this;
    }

    public SystemTaskResult getResults() {
        return results;
    }

    public SystemTask setResults(SystemTaskResult results) {
        this.results = results;
        return this;
    }
}

