package org.jbsmit.blackboardRestClient.model;


public class InstitutionRole {
    /*
     * The id associated with this institution role.
     */
    private String id;

    /*
     * The String role key associated with this institution role.
     */
    private String roleId;

    /*
     * The title of this institution role.
     */
    private String name;

    /*
     * The description of this institution role.
     */
    private String description;

    /*
     * Indicates if this institution role is custom.
     */
    private boolean custom;


    public String getId() {
        return id;
    }

    public InstitutionRole setId(String id) {
        this.id = id;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public InstitutionRole setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getName() {
        return name;
    }

    public InstitutionRole setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InstitutionRole setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getCustom() {
        return custom;
    }

    public InstitutionRole setCustom(boolean custom) {
        this.custom = custom;
        return this;
    }
}

