package org.jbsmit.blackboardRestClient.model;


public class DataSource {
    /*
     * The primary ID of the data source.
     */
    private String id;

    /*
     * An externally-defined unique ID for the data source.
     *
     * Formerly known as 'batchUid'.
     */
    private String externalId;

    /*
     * The description of the data source.
     */
    private String description;


    public String getId() {
        return id;
    }

    public DataSource setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public DataSource setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DataSource setDescription(String description) {
        this.description = description;
        return this;
    }
}

