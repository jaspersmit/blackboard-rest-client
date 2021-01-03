package org.jbsmit.blackboardRestClient.model;


public class SystemRole {
    /*
     * The id associated with this system role.
     */
    private String id;

    /*
     * The identifier used to assign the system role.
     *
     * For system generated roles, this value will be one of AccountAdmin, CourseCreator, CourseSupport, Guest, Integration, Observer, Portal, SystemAdmin, SystemSupport, or User
     *
     * For custom system roles, this will be the roleId entered during the creation of the role. Allowed characters for the custom roleId's are any letter, number, period, underscore and dash.
     */
    private String roleId;

    private String name;

    /*
     * The description of this system role.
     */
    private String description;

    /*
     * Indicates if this system role is custom.
     */
    private boolean custom;


    public String getId() {
        return id;
    }

    public SystemRole setId(String id) {
        this.id = id;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public SystemRole setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SystemRole setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SystemRole setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getCustom() {
        return custom;
    }

    public SystemRole setCustom(boolean custom) {
        this.custom = custom;
        return this;
    }
}

