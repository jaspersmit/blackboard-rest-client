package org.jbsmit.blackboardRestClient.model;


public class Calendar {
    /*
     * Calendar id. Valid ids are: "PERSONAL", "INSTITUTION", and course id in the format of "_3_1".
     */
    private String id;

    /*
     * Calendar name.
     */
    private String name;


    public String getId() {
        return id;
    }

    public Calendar setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Calendar setName(String name) {
        this.name = name;
        return this;
    }
}

