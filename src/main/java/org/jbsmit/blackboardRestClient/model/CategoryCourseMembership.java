package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CategoryCourseMembership {
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
     * The course ID.
     */
    private String courseId;

    /*
     * The course detailed information.
     *
     * **Since**: 3700.5.0
     */
    private CourseV2 course;

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

    public CategoryCourseMembership setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public CategoryCourseMembership setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public CategoryCourseMembership setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public CourseV2 getCourse() {
        return course;
    }

    public CategoryCourseMembership setCourse(CourseV2 course) {
        this.course = course;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public CategoryCourseMembership setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public CategoryCourseMembership setCreated(Instant created) {
        this.created = created;
        return this;
    }
}

