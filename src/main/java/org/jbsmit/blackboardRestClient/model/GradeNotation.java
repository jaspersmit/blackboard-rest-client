package org.jbsmit.blackboardRestClient.model;


public class GradeNotation {
    /*
     * The primary key of the grade notation.
     */
    private String id;

    /*
     * The performance code associated with the grade notation.
     */
    private String code;

    /*
     * The description of the grade notation.
     */
    private String description;


    public String getId() {
        return id;
    }

    public GradeNotation setId(String id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GradeNotation setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GradeNotation setDescription(String description) {
        this.description = description;
        return this;
    }
}

