package org.jbsmit.blackboardRestClient.model;

import java.util.List;
import java.time.Instant;

public class Category {
    private String id;

    /*
     * The ID of the data source of the category
     */
    private String dataSourceId;

    /*
     * The ID of this category's parent category
     */
    private String parentId;

    /*
     * The human-readable id of the category
     */
    private String categoryId;

    /*
     * The title of category
     */
    private String title;

    /*
     * The description of the category
     */
    private String description;

    /*
     * Type of category
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Course |  |
     * | Organization |  |
     *
     */
    private Type type;

    /*
     * Boolean indicating whether or not the category should appear on the catalog front page
     */
    private boolean frontPage;

    /*
     * Boolean indicating whether or not the category is available
     */
    private boolean available;

    /*
     * Boolean indicating whether or not category is available to all roles, or restricted to a specific set of roles.
     */
    private boolean restricted;

    /*
     * The roles for which this category is available, if category is set to restricted. Not populated for lists of categories, only for individual category
     */
    private List<String> institutionRoleIds;

    /*
     * The date and time at which the category was created
     */
    private Instant created;


    public enum Type {
        Course,
        Organization
    }

    public String getId() {
        return id;
    }

    public Category setId(String id) {
        this.id = id;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public Category setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Category setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Category setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Category setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Category setType(Type type) {
        this.type = type;
        return this;
    }

    public boolean getFrontPage() {
        return frontPage;
    }

    public Category setFrontPage(boolean frontPage) {
        this.frontPage = frontPage;
        return this;
    }

    public boolean getAvailable() {
        return available;
    }

    public Category setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public boolean getRestricted() {
        return restricted;
    }

    public Category setRestricted(boolean restricted) {
        this.restricted = restricted;
        return this;
    }

    public List<String> getInstitutionRoleIds() {
        return institutionRoleIds;
    }

    public Category setInstitutionRoleIds(List<String> institutionRoleIds) {
        this.institutionRoleIds = institutionRoleIds;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Category setCreated(Instant created) {
        this.created = created;
        return this;
    }
}

