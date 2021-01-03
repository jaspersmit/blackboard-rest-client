package org.jbsmit.blackboardRestClient.model;

public class VersionInfo {
    /*
     * The version of the Learn platform.
     */
    private Version learn;


    public Version getLearn() {
        return learn;
    }

    public VersionInfo setLearn(Version learn) {
        this.learn = learn;
        return this;
    }
}

