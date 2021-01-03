package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.CourseRole;
import org.jbsmit.blackboardRestClient.model.InstitutionRole;
import org.jbsmit.blackboardRestClient.model.SystemRole;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class RolesApi {
    /*
     * Get Course Roles
     *
     *
     *
     * Returns a list of course roles.  This list will contain all the course roles the context user has access to see. </p>
     *
     * If the context user has any of these entitlements, then the user can see all course roles:
     *
     * - system.courserole.CREATE
     * - system.enrollment.CREATE
     * - system.courserole.manager.VIEW
     * - system.courserole.DELETE
     * </p>
     *
     * Otherwise, these course role entitlements are checked for any courses the context user is enrolled in:
     *
     * - course.user-enroll.EXECUTE
     * - system.courserole.CREATE
     * - system.enrollment.CREATE
     * - system.courserole.manager.VIEW
     * - system.courserole.DELETE
     * - course.user-role.MODIFY
     * </p>
     *
     * If the logged in user has any of those course role entitlements for a Course where Course.organization = false, then the user can see course roles where Availability.Available = Course or CourseAndOrganization </p>
     *
     * If the logged in user has any of those course role entitlements for a Course where Course.organization = true, then the user can see course roles where Availability.Available = Organization or CourseAndOrganization </p>
     *
     * **Since**: 3300.5.0
     */
    public static RestCall<List<CourseRole>> getCourseRoles(GetCourseRolesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseRole>>() {})
            .get()
            .url("/learn/api/public/v1/courseRoles")
            .options(options)
            .build();
    }

    public static class GetCourseRolesOption extends RestCallOption {
        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name.family(desc),created"
         *
         * **Since**: 3100.0.0
         */
        public static GetCourseRolesOption sort(String sort) {
            return parameter("sort", sort, new GetCourseRolesOption());
        }

        /*
         * Search course roles by whether they are a custom or system generated course role.
         *
         * **Since**: 3300.5.0
         */
        public static GetCourseRolesOption custom(boolean custom) {
            return parameter("custom", custom, new GetCourseRolesOption());
        }

        /*
         * Search course roles using their roleId's.  Any course role with a roleId that contains the given string will be returned.  The search is case insensitive.
         *
         * **Since**: 3300.5.0
         */
        public static GetCourseRolesOption roleId(String roleId) {
            return parameter("roleId", roleId, new GetCourseRolesOption());
        }
    }

    /*
     * Get Course Role
     *
     *
     *
     * Returns a single course role.  The path id can be either the CourseRole.id field like "/courseRoles/_5_1" or the CourseRole.roleId field like "/courseRoles/roleId:Student". </p>
     *
     * A 403 (FORBIDDEN) status is returned if the context user does not have access to see the course role. </p>
     *
     * If the context user has any of these entitlements, then the user can see all course roles:
     *
     * - system.courserole.CREATE
     * - system.enrollment.CREATE
     * - system.courserole.manager.VIEW
     * - system.courserole.DELETE
     * </p>
     *
     * Otherwise, these course role entitlements are checked for any courses the context user is enrolled in:
     *
     * - course.user-enroll.EXECUTE
     * - system.courserole.CREATE
     * - system.enrollment.CREATE
     * - system.courserole.manager.VIEW
     * - system.courserole.DELETE
     * - course.user-role.MODIFY
     * </p>
     *
     * If the logged in user has any of those course role entitlements for a Course where Course.organization = false, then the user can see course roles where Availability.Available = Course or CourseAndOrganization </p>
     *
     * If the logged in user has any of those course role entitlements for a Course where Course.organization = true, then the user can see course roles where Availability.Available = Organization or CourseAndOrganization </p>
     *
     * **Since**: 3300.5.0
     */
    public static RestCall<CourseRole> getCourseRole(String roleId) {
        return RestCallBuilder
            .start(new TypeToken<CourseRole>() {})
            .get()
            .url("/learn/api/public/v1/courseRoles/{roleId}")
            .pathParam("roleId", roleId)
            .build();
    }

    /*
     * Get Institution Roles
     *
     * Returns a list of institution roles.
     *
     * Users must have the entitlement 'system.institutionrole.VIEW' to access this endpoint.
     *
     * **Since**: 3300.4.0
     */
    public static RestCall<List<InstitutionRole>> getInstitutionRoles(GetInstitutionRolesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<InstitutionRole>>() {})
            .get()
            .url("/learn/api/public/v1/institutionRoles")
            .options(options)
            .build();
    }

    public static class GetInstitutionRolesOption extends RestCallOption {
        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "roleId(desc)" Supported fields are:
         *
         * - roleId
         * - custom
         *
         * **Since**: 3300.4.0
         */
        public static GetInstitutionRolesOption sort(String sort) {
            return parameter("sort", sort, new GetInstitutionRolesOption());
        }

        /*
         * Search for institution roles with roleId properties that contain this value.
         *
         * **Since**: 3300.4.0
         */
        public static GetInstitutionRolesOption roleId(String roleId) {
            return parameter("roleId", roleId, new GetInstitutionRolesOption());
        }

        /*
         * Search for institution roles by custom flag.  A value of 'true' indicates that search results should be limited to only custom roles.  A value of 'false' indicates results should be limited to built-in roles.  Not setting this field indicates that all institution roles should be returned.
         *
         * **Since**: 3300.4.0
         */
        public static GetInstitutionRolesOption custom(boolean custom) {
            return parameter("custom", custom, new GetInstitutionRolesOption());
        }
    }

    /*
     * Get Institution Role
     *
     * Loads a specific institution role.
     *
     * Users must have the entitlement 'system.institutionrole.VIEW' to access this endpoint.
     *
     * **Since**: 3300.4.0
     */
    public static RestCall<InstitutionRole> getInstitutionRole(String roleId) {
        return RestCallBuilder
            .start(new TypeToken<InstitutionRole>() {})
            .get()
            .url("/learn/api/public/v1/institutionRoles/{roleId}")
            .pathParam("roleId", roleId)
            .build();
    }

    /*
     * Get System Roles
     *
     * Returns a list of system roles.
     *
     * Users must have the 'system.systemrole.manager.VIEW' entitlement to access this endpoint.
     *
     * **Since**: 3300.5.0
     */
    public static RestCall<List<SystemRole>> getSystemRoles(GetSystemRolesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<SystemRole>>() {})
            .get()
            .url("/learn/api/public/v1/systemRoles")
            .options(options)
            .build();
    }

    public static class GetSystemRolesOption extends RestCallOption {
        /*
         * Search for system roles with roleId
         *
         * **Since**: 3300.5.0
         */
        public static GetSystemRolesOption roleId(String roleId) {
            return parameter("roleId", roleId, new GetSystemRolesOption());
        }

        /*
         * Search for system roles by custom flag.  A value of 'true' indicates that search results should be limited to only custom roles.  A value of 'false' indicates results should be limited to built-in roles.  Not setting this field indicates that all system roles should be returned.
         *
         * **Since**: 3300.5.0
         */
        public static GetSystemRolesOption custom(boolean custom) {
            return parameter("custom", custom, new GetSystemRolesOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "roleId(desc)"
         *
         * Supported fields are:
         *
         * <ul - roleId
         * - custom
         *
         * **Since**: 3300.5.0
         */
        public static GetSystemRolesOption sort(String sort) {
            return parameter("sort", sort, new GetSystemRolesOption());
        }
    }

    /*
     * Get System Role
     *
     * Get a specific system role by roleId. See the roleId parameter for valid roleId formats.
     *
     * Users must have the 'system.systemrole.manager.VIEW' entitlement to access this endpoint.
     *
     * **Since**: 3300.5.0
     */
    public static RestCall<SystemRole> getSystemRole(String roleId) {
        return RestCallBuilder
            .start(new TypeToken<SystemRole>() {})
            .get()
            .url("/learn/api/public/v1/systemRoles/{roleId}")
            .pathParam("roleId", roleId)
            .build();
    }
}
