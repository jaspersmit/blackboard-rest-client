package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class SISLogEntry {
    /*
     * Id of the log message
     */
    private String id;

    /*
     * log message created date
     */
    private Instant created;

    /*
     * An enumerated value of LogLevel describing log verbosity level
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Debug |  |
     * | Information |  |
     * | Warning |  |
     * | Error |  |
     *
     */
    private Level level;

    private String message;


    public enum Level {
        Debug,
        Information,
        Warning,
        Error
    }

    public String getId() {
        return id;
    }

    public SISLogEntry setId(String id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public SISLogEntry setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public SISLogEntry setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SISLogEntry setMessage(String message) {
        this.message = message;
        return this;
    }
}

