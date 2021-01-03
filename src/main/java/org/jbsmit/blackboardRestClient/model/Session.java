package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class Session {
    /*
     * Unique identifier of the session.
     */
    private String id;

    /*
     * Time when the session started.
     */
    private Instant created;

    /*
     * Time when the session was last accessed.
     */
    private Instant lastAccess;

    /*
     * Indicates whether this is a mobile session.
     */
    private boolean mobile;

    /*
     * Id of the logged in user.
     */
    private String userId;

    /*
     * Full information of the logged user. This is only set if the caller requests to expand the user information.
     */
    private User user;


    public String getId() {
        return id;
    }

    public Session setId(String id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Session setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getLastAccess() {
        return lastAccess;
    }

    public Session setLastAccess(Instant lastAccess) {
        this.lastAccess = lastAccess;
        return this;
    }

    public boolean getMobile() {
        return mobile;
    }

    public Session setMobile(boolean mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Session setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Session setUser(User user) {
        this.user = user;
        return this;
    }
}

