package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CourseTask {
    /*
     * The ID of this task.
     */
    private String id;

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

    public CourseTask setId(String id) {
        this.id = id;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public CourseTask setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getPercentComplete() {
        return percentComplete;
    }

    public CourseTask setPercentComplete(int percentComplete) {
        this.percentComplete = percentComplete;
        return this;
    }

    public Instant getStarted() {
        return started;
    }

    public CourseTask setStarted(Instant started) {
        this.started = started;
        return this;
    }
}

