package org.jbsmit.blackboardRestClient.model;


public class Version {
    /*
     * The 'major' version of this product.  Typically changes for releases with significant new features or breaking API changes.
     */
    private int major;

    /*
     * The 'minor' version of this product.  Typically changes for releases with minor feature updates.
     */
    private int minor;

    /*
     * The 'patch' version of this product.  Typically changes for backwards-compatible hotfixes.
     */
    private int patch;

    /*
     * An internal identifier for the build artifact backing this version.
     */
    private String build;


    public int getMajor() {
        return major;
    }

    public Version setMajor(int major) {
        this.major = major;
        return this;
    }

    public int getMinor() {
        return minor;
    }

    public Version setMinor(int minor) {
        this.minor = minor;
        return this;
    }

    public int getPatch() {
        return patch;
    }

    public Version setPatch(int patch) {
        this.patch = patch;
        return this;
    }

    public String getBuild() {
        return build;
    }

    public Version setBuild(String build) {
        this.build = build;
        return this;
    }
}

