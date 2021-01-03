package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class CourseChild {
    /*
     * The primary ID of the child course associated with this cross-listing.
     */
    private String id;

    /*
     * The primary ID of the parent course associated with this cross-listing.
     */
    private String parentId;

    /*
     * The ID of the data source associated with this course cross-listing.  This may optionally be the data source's externalId using the syntax "externalId:math101".
     */
    private String dataSourceId;

    /*
     * The date this course cross-listing was created.
     */
    private Instant created;

    /*
     * The child course associated with this cross-listing.
     */
    private Course childCourse;


    public String getId() {
        return id;
    }

    public CourseChild setId(String id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public CourseChild setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public CourseChild setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public CourseChild setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Course getChildCourse() {
        return childCourse;
    }

    public CourseChild setChildCourse(Course childCourse) {
        this.childCourse = childCourse;
        return this;
    }
}

