package org.jbsmit.blackboardRestClient.model;


public class Node {
    /*
     * The primary ID of the Node in the database
     */
    private String id;

    /*
     * Node unique identifier
     */
    private String externalId;

    /*
     * Node display name
     */
    private String title;

    /*
     * Node description
     */
    private String description;

    /*
     * The ID of the Node parent in the database
     */
    private String parentId;


    public String getId() {
        return id;
    }

    public Node setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public Node setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Node setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Node setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Node setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
}

