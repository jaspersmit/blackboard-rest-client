package org.jbsmit.blackboardRestClient.model;


public class AttemptFile {
    /*
     * The primary key of the file attachment.
     */
    private String id;

    /*
     * The name of the file which has been attached to an Attempt including the file extension.
     */
    private String name;

    /*
     * If Learn has a registered viewer for the file, this will be a URL for that viewer to render the file. This may not be populated depending on multiple factors including but not limited to Learn configuration, file type, and viewer provider.
     */
    private String viewUrl;


    public String getId() {
        return id;
    }

    public AttemptFile setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AttemptFile setName(String name) {
        this.name = name;
        return this;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public AttemptFile setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
        return this;
    }
}

