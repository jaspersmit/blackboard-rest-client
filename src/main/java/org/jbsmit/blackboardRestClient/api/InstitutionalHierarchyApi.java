package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.CourseHierarchyNode;
import org.jbsmit.blackboardRestClient.model.HierarchyNodeCourse;
import org.jbsmit.blackboardRestClient.model.Node;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class InstitutionalHierarchyApi {
    /*
     * Get Associated Nodes
     *
     * Obtains a list of nodes to which a given course is directly associated.
     *
     * Users with the 'system.multiinst.node.course.association.VIEW' entitlement and the 'system.multiinst.node.org.association.VIEW' system entitlement can access all node association information.
     *
     * **Since**: 3800.10.0
     */
    public static RestCall<List<CourseHierarchyNode>> getAssociatedNodes(String courseId, GetAssociatedNodesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseHierarchyNode>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/nodes")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetAssociatedNodesOption extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>node</li></ul>
         */
        public static GetAssociatedNodesOption expand(String expand) {
            return parameter("expand", expand, new GetAssociatedNodesOption());
        }
    }

    /*
     * Get Nodes
     *
     * Returns the Top-level institutional hierarhcy nodes
     *
     * Entitlement system.multiinst.hierarchy.manager.VIEW required
     *
     * Users with entitlement "system.multiinst.hierarchy.manager.VIEW" for Node management can view all fields.
     *
     * **Since**: 3800.10.0
     */
    public static RestCall<List<Node>> getNodes(GetNodesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Node>>() {})
            .get()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes")
            .options(options)
            .build();
    }

    public static class GetNodesOption extends RestCallOption {
        /*
         * Search Institutional Hierarchy Nodes recursively. If true, returns all descendant nodes of the specified Node. If false, only immediate children are returned (defualt: false)
         *
         * **Since**: 3800.14.0
         */
        public static GetNodesOption recursive(boolean recursive) {
            return parameter("recursive", recursive, new GetNodesOption());
        }
    }

    /*
     * Create Node
     *
     * Creates a new institutional hierarhcy node
     *
     * Entitlement system.multiinst.hierarchy.manager.CREATE required
     *
     * Users with entitlement "system.multiinst.hierarchy.manager.CREATE" for Node management can create a new Node.
     *
     * **Since**: 3800.15.0
     */
    public static RestCall<Node> createNode(CreateNodeBody input) {
        return RestCallBuilder
            .start(new TypeToken<Node>() {})
            .post()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes")
            .body(input)
            .build();
    }

    public static class CreateNodeBody {
        /*
         * Node unique identifier
         */
        private String externalId;

        /*
         * Node display name
         */
        private String title;

        /*
         * Node description
         */
        private String description;

        public static CreateNodeBody create() {
            return new CreateNodeBody();
        }

        public CreateNodeBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateNodeBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateNodeBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }

    /*
     * Get Node
     *
     * Returns the institutional hierarhcy node corresponding the provided ID
     *
     * Entitlement system.multiinst.hierarchy.manager.VIEW required
     *
     * Users with entitlement "system.multiinst.hierarchy.manager.VIEW" for Node management can view all fields.
     *
     * **Since**: 3800.10.0
     */
    public static RestCall<Node> getNode(String nodeId) {
        return RestCallBuilder
            .start(new TypeToken<Node>() {})
            .get()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}")
            .pathParam("nodeId", nodeId)
            .build();
    }

    /*
     * Delete Node
     *
     * Deletes an institutional hierarchy node. The root node cannot be deleted. This deletes orphan children in a cascading fashion.
     *
     * The 'system.multiinst.hierarchy.manager.DELETE' entitlement is required.
     *
     * **Since**: 3800.15.0
     */
    public static RestCall<Void> deleteNode(String nodeId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}")
            .pathParam("nodeId", nodeId)
            .build();
    }

    /*
     * Update Node
     *
     * Updates Institutional Hierarchy Node information.
     *
     * Entitlement system.multiinst.hierarchy.manager.MODIFY is required
     *
     * **Since**: 3800.15.0
     */
    public static RestCall<Node> updateNode(UpdateNodeBody input, String nodeId) {
        return RestCallBuilder
            .start(new TypeToken<Node>() {})
            .patch()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}")
            .body(input)
            .pathParam("nodeId", nodeId)
            .build();
    }

    public static class UpdateNodeBody {
        /*
         * Node unique identifier
         */
        private String externalId;

        /*
         * Node display name
         */
        private String title;

        /*
         * Node description
         */
        private String description;

        public static UpdateNodeBody create() {
            return new UpdateNodeBody();
        }

        public UpdateNodeBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public UpdateNodeBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateNodeBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }

    /*
     * Get Node Children
     *
     * Returns the children of the institutional hierarhcy node corresponding to the provided ID
     *
     * Entitlement system.multiinst.hierarchy.manager.VIEW required
     *
     * Users with entitlement "system.multiinst.hierarchy.manager.VIEW" for Node management can view all fields.
     *
     * **Since**: 3800.10.0
     */
    public static RestCall<List<Node>> getNodeChildren(String nodeId, GetNodeChildrenOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Node>>() {})
            .get()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}/children")
            .pathParam("nodeId", nodeId)
            .options(options)
            .build();
    }

    public static class GetNodeChildrenOption extends RestCallOption {
        /*
         * Search Institutional Hierarchy Nodes recursively. If true, returns all descendant nodes of the specified Node. If false, only immediate children are returned (defualt: false)
         *
         * **Since**: 3800.14.0
         */
        public static GetNodeChildrenOption recursive(boolean recursive) {
            return parameter("recursive", recursive, new GetNodeChildrenOption());
        }
    }

    /*
     * Create Child Node
     *
     * Create a new institutional hierarchy node whose parent corresponds to the supplied nodeId
     *
     * Entitlement system.multiinst.hierarchy.manager.CREATE required
     *
     * Users with entitlement "system.multiinst.hierarchy.manager.CREATE" for Node management can create a new Node.
     *
     * **Since**: 3800.15.0
     */
    public static RestCall<Node> createChildNode(CreateChildNodeBody input, String nodeId) {
        return RestCallBuilder
            .start(new TypeToken<Node>() {})
            .post()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}/children")
            .body(input)
            .pathParam("nodeId", nodeId)
            .build();
    }

    public static class CreateChildNodeBody {
        /*
         * Node unique identifier
         */
        private String externalId;

        /*
         * Node display name
         */
        private String title;

        /*
         * Node description
         */
        private String description;

        public static CreateChildNodeBody create() {
            return new CreateChildNodeBody();
        }

        public CreateChildNodeBody setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public CreateChildNodeBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateChildNodeBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }

    /*
     * Get Node Course Associations
     *
     * Returns a list of node-course relationships for the specified node.
     *
     * Users with the 'system.multiinst.node.course.association.VIEW' entitlement and the 'system.multiinst.node.org.association.VIEW' system entitlement can access all node association information.
     *
     * **Since**: 3800.10.0
     */
    public static RestCall<List<HierarchyNodeCourse>> getNodeCourseAssociations(String nodeId, GetNodeCourseAssociationsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<HierarchyNodeCourse>>() {})
            .get()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}/courses")
            .pathParam("nodeId", nodeId)
            .options(options)
            .build();
    }

    public static class GetNodeCourseAssociationsOption extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>course</li></ul>
         */
        public static GetNodeCourseAssociationsOption expand(String expand) {
            return parameter("expand", expand, new GetNodeCourseAssociationsOption());
        }
    }

    /*
     * Delete Node Course Association
     *
     * Deletes the association between a given Node and a Course
     *
     * Entitlement system.multiinst.node.course.association.DELETE required to delete Node-Course associations Entitlement system.multiinst.node.org.association.DELETE required to delete Node-Organization associations
     *
     * **Since**: 3800.17.0
     */
    public static RestCall<Void> deleteNodeCourseAssociation(String nodeId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}/courses/{courseId}")
            .pathParam("nodeId", nodeId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Create Node Course Association
     *
     * Creates a node-course relationship for the specified node and course.
     *
     * Users with the 'system.multiinst.node.course.association.CREATE' entitlement can create Course - Hierarchy Node associations. Users with the 'system.multiinst.node.org.association.CREATE' entitlement can create Organization - Hierarchy Node associations
     *
     * **Since**: 3800.17.0
     */
    public static RestCall<HierarchyNodeCourse> createNodeCourseAssociation(String nodeId, String courseId, CreateNodeCourseAssociationBody input) {
        return RestCallBuilder
            .start(new TypeToken<HierarchyNodeCourse>() {})
            .put()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}/courses/{courseId}")
            .pathParam("nodeId", nodeId)
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateNodeCourseAssociationBody {
        /*
         * Whether or not this association represents the primary node association of the course
         */
        private boolean isPrimary;

        public static CreateNodeCourseAssociationBody create() {
            return new CreateNodeCourseAssociationBody();
        }

        public CreateNodeCourseAssociationBody setIsPrimary(boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }
    }

    /*
     * Update Node Course Association
     *
     * Update a specified node-course association.
     *
     * Users with the 'system.multiinst.node.course.association.CREATE' entitlement can update Course - Hierarchy Node associations Users with the 'system.multiinst.node.org.association.CREATE' entitlement can update Organization - Hierarchy Node associations
     *
     * **Since**: 3800.17.0
     */
    public static RestCall<HierarchyNodeCourse> updateNodeCourseAssociation(String nodeId, String courseId, UpdateNodeCourseAssociationBody input) {
        return RestCallBuilder
            .start(new TypeToken<HierarchyNodeCourse>() {})
            .patch()
            .url("/learn/api/public/v1/institutionalHierarchy/nodes/{nodeId}/courses/{courseId}")
            .pathParam("nodeId", nodeId)
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class UpdateNodeCourseAssociationBody {
        /*
         * Whether or not this association represents the primary node association of the course
         */
        private boolean isPrimary;

        public static UpdateNodeCourseAssociationBody create() {
            return new UpdateNodeCourseAssociationBody();
        }

        public UpdateNodeCourseAssociationBody setIsPrimary(boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }
    }
}
