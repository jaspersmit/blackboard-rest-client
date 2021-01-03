package org.jbsmit.blackboardRestClient.model;

public class HierarchyNodeCourse {
    /*
     * The primary ID of the Hierarchy Node
     */
    private String nodeId;

    /*
     * The primary ID of the Course
     */
    private String courseId;

    private CourseV2 course;

    /*
     * Whether or not this association represents the primary node association of the course
     */
    private boolean isPrimary;


    public String getNodeId() {
        return nodeId;
    }

    public HierarchyNodeCourse setNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public HierarchyNodeCourse setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public CourseV2 getCourse() {
        return course;
    }

    public HierarchyNodeCourse setCourse(CourseV2 course) {
        this.course = course;
        return this;
    }

    public boolean getIsPrimary() {
        return isPrimary;
    }

    public HierarchyNodeCourse setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }
}

