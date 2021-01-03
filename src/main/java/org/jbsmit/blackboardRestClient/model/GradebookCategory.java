package org.jbsmit.blackboardRestClient.model;


public class GradebookCategory {
    /*
     * The ID of this gradebook category
     *
     * **Since**: 3400.2.0
     */
    private String id;

    /*
     * The title of this gradebook category, localized if applicable
     *
     * **Since**: 3400.2.0
     */
    private String title;


    public String getId() {
        return id;
    }

    public GradebookCategory setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GradebookCategory setTitle(String title) {
        this.title = title;
        return this;
    }
}

