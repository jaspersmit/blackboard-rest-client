package org.jbsmit.blackboardRestClient.model;

public class CourseHierarchyNode {
    /*
     * The primary ID of the Hierarchy Node
     */
    private String nodeId;

    /*
     * The hierarchy node of the node/course association.
     *
     * Shown when adding the query parameter: "expand=node"
     */
    private Node node;

    /*
     * The primary ID of the Course
     */
    private String courseId;

    /*
     * Whether or not this association represents the primary node association of the course
     */
    private boolean isPrimary;


    public String getNodeId() {
        return nodeId;
    }

    public CourseHierarchyNode setNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public Node getNode() {
        return node;
    }

    public CourseHierarchyNode setNode(Node node) {
        this.node = node;
        return this;
    }

    public String getCourseId() {
        return courseId;
    }

    public CourseHierarchyNode setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public boolean getIsPrimary() {
        return isPrimary;
    }

    public CourseHierarchyNode setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }
}

