package org.jbsmit.blackboardRestClient.model;


public class Link {
    /*
     * Contains a target Internationalized Resource Identifiers (IRIs)
     */
    private String href;

    /*
     * Describes how the current context is related to the target resource.
     *
     * Supported values:
     *
     *  | Relation Type | Media Type  | Functionality                                | Since    |
     *  |---------------|-------------|----------------------------------------------|----------|
     *  | "alternate"   |  text/html  | Links to the UI representation of a resource | 3900.0.0 |
     *
     */
    private String rel;

    /*
     * Title attributes for the target IRI
     */
    private String title;

    /*
     * Format attributes for the target IRI
     */
    private String type;


    public String getHref() {
        return href;
    }

    public Link setHref(String href) {
        this.href = href;
        return this;
    }

    public String getRel() {
        return rel;
    }

    public Link setRel(String rel) {
        this.rel = rel;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Link setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public Link setType(String type) {
        this.type = type;
        return this;
    }
}

