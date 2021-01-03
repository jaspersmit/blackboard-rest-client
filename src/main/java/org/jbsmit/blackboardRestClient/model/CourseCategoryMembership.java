package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CourseCategoryMembership {
    /*
     * The category ID.
     */
    private String categoryId;

    /*
     * The category type.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Course |  |
     * | Organization |  |
     *
     */
    private CategoryType categoryType;

    /*
     * The category detailed information.
     *
     * **Since**: 3700.7.0
     */
    private Category category;

    /*
     * The course ID.
     */
    private String courseId;

    /*
     * The data source ID.
     */
    private String dataSourceId;

    /*
     * The date this membership was created.
     */
    private Instant created;


    public enum CategoryType {
        Course,
        Organization
    }

    public String getCategoryId() {
        return categoryId;
    }

    public CourseCategoryMembership setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public CourseCategoryMembership setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public CourseCategoryMembership setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public CourseCategoryMembership setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public CourseCategoryMembership setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public CourseCategoryMembership setCreated(Instant created) {
        this.created = created;
        return this;
    }
}

