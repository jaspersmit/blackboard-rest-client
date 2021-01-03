package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class Resource {
    /*
     * The primary ID the Resource.
     */
    private String id;

    /*
     * The name of the Resource.
     */
    private String name;

    /*
     * The type of the Resource; 'File' or 'Folder'
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | File |  |
     * | Folder |  |
     *
     */
    private Type type;

    /*
     * The size of the Resource in bytes.
     */
    private long size;

    /*
     * Whether the Resource has associated Course Content links.
     */
    private boolean hasLinks;

    /*
     * The Id of the of the Resource's parent folder.
     */
    private String parentId;

    /*
     * The Id of the User who created the Resource.
     */
    private String creatorId;

    /*
     * The date this Resource was created.
     */
    private Instant created;

    /*
     * The date this Resource was last modified.
     */
    private Instant modified;

    /*
     * The mime-type for this Resource; only set if the Resource is of type 'File'
     */
    private String mimeType;

    /*
     * The version number for this Resource; only set if the Resource is of type 'File' and is versioned.
     */
    private int version;

    /*
     * The downloadUrl for this Resource; only set if the Resource is of type 'File'.
     */
    private String downloadUrl;


    public enum Type {
        File,
        Folder
    }

    public String getId() {
        return id;
    }

    public Resource setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Resource setName(String name) {
        this.name = name;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Resource setType(Type type) {
        this.type = type;
        return this;
    }

    public long getSize() {
        return size;
    }

    public Resource setSize(long size) {
        this.size = size;
        return this;
    }

    public boolean getHasLinks() {
        return hasLinks;
    }

    public Resource setHasLinks(boolean hasLinks) {
        this.hasLinks = hasLinks;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Resource setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public Resource setCreatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Resource setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public Resource setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Resource setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public Resource setVersion(int version) {
        this.version = version;
        return this;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public Resource setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }
}

