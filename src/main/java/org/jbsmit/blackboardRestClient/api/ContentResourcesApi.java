package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.Resource;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class ContentResourcesApi {
    /*
     * Get Top Level Course Resources
     *
     * Returns a list of the top-level course resources.
     *
     * Users with the 'bbcms.cs.fileSystem.REST.VIEW' entitlement can view all resources.
     *
     * All other users can view resources for which they have been granted the 'Read' permission.
     *
     * **Since**: 3700.12.0
     */
    public static RestCall<List<Resource>> getTopLevelCourseResources(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<Resource>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/resources")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Get Course Resource
     *
     * Loads a Course Resource by Id.
     *
     * Users with the 'bbcms.cs.fileSystem.REST.VIEW' entitlement can view all resources.
     *
     * All other users can view resources for which they have been granted the 'Read' permission.
     *
     * **Since**: 3700.13.0
     */
    public static RestCall<Resource> getCourseResource(String courseId, String resourceId) {
        return RestCallBuilder
            .start(new TypeToken<Resource>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/resources/{resourceId}")
            .pathParam("courseId", courseId)
            .pathParam("resourceId", resourceId)
            .build();
    }

    /*
     * Get Course Resource Children
     *
     * Returns a list of Course Resources that are children of the specified Resource.
     *
     * Users with the 'bbcms.cs.fileSystem.REST.VIEW' entitlement can view all resources.
     *
     * All other users can view resources for which they have been granted the 'Read' permission.
     *
     * **Since**: 3700.13.0
     */
    public static RestCall<List<Resource>> getCourseResourceChildren(String courseId, String resourceId) {
        return RestCallBuilder
            .start(new TypeToken<List<Resource>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/resources/{resourceId}/children")
            .pathParam("courseId", courseId)
            .pathParam("resourceId", resourceId)
            .build();
    }
}
