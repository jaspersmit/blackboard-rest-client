package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Category;
import org.jbsmit.blackboardRestClient.model.CategoryCourseMembership;
import org.jbsmit.blackboardRestClient.model.CourseCategoryMembership;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class CourseCategoriesApi {
    /*
     * Get Categories
     *
     * Returns a list of categories of the provided type (course or organization)
     *
     * Entitlement system.course-categories.VIEW required
     *
     * Users with entitlement "system.course.categories.MODIFY" for course categories, or "system.org.categories.MODIFY" for organization categories can view all fields and all categories.
     *
     * Users with system.course-categories.VIEW but not the corresponding MODIFY entitlements have read access to all properties except:
     *
     * - restricted
     * - institutionRoleIds
     * In addition, users without the corresponding MODIFY entitlement have access to a restricted category only if their institution role matches one of the roles in the institutionRoleIds list for that category.
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<List<Category>> getCategories(String categoryType, GetCategoriesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Category>>() {})
            .get()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}")
            .pathParam("categoryType", categoryType)
            .options(options)
            .build();
    }

    public static class GetCategoriesOption extends RestCallOption {
        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "title(desc),start" Supported fields are:
         *
         * - id
         * - categoryId
         * - title
         * - available
         * - created
         *
         * **Since**: 3700.6.0
         */
        public static GetCategoriesOption sort(String sort) {
            return parameter("sort", sort, new GetCategoriesOption());
        }

        /*
         * Search for categories with titles that contain this value.
         *
         * **Since**: 3700.8.0
         */
        public static GetCategoriesOption title(String title) {
            return parameter("title", title, new GetCategoriesOption());
        }

        /*
         * Search for categories with category IDs that contain this value.
         *
         * **Since**: 3700.8.0
         */
        public static GetCategoriesOption categoryId(String categoryId) {
            return parameter("categoryId", categoryId, new GetCategoriesOption());
        }

        /*
         * Search for categories with a created date relative to this value.
         *
         * **Since**: 3700.8.0
         */
        public static GetCategoriesOption created(Instant created) {
            return parameter("created", created, new GetCategoriesOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3700.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetCategoriesOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetCategoriesOption());
        }

        /*
         * Search for categories with a data source id matching this value.
         *
         * **Since**: 3700.9.0
         */
        public static GetCategoriesOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetCategoriesOption());
        }

        /*
         * Search for categories with a front page indicator matching this value.
         *
         * **Since**: 3700.9.0
         */
        public static GetCategoriesOption frontPage(boolean frontPage) {
            return parameter("frontPage", frontPage, new GetCategoriesOption());
        }

        /*
         * Search for categories with availability matching this value.
         *
         * **Since**: 3700.9.0
         */
        public static GetCategoriesOption available(boolean available) {
            return parameter("available", available, new GetCategoriesOption());
        }
    }

    /*
     * Create Category
     *
     * Creates a new category of the provided type as defined in the request body
     *
     * Entitlement system.course.categories.MODIFY required to create course categories Entitlement system.org.categories.MODIFY required to create organization categories
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<Category> createCategory(String categoryType, CreateCategoryBody category) {
        return RestCallBuilder
            .start(new TypeToken<Category>() {})
            .post()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}")
            .pathParam("categoryType", categoryType)
            .body(category)
            .build();
    }

    public static class CreateCategoryBody {
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

        public static CreateCategoryBody create() {
            return new CreateCategoryBody();
        }

        public CreateCategoryBody setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public CreateCategoryBody setCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public CreateCategoryBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateCategoryBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateCategoryBody setFrontPage(boolean frontPage) {
            this.frontPage = frontPage;
            return this;
        }

        public CreateCategoryBody setAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public CreateCategoryBody setRestricted(boolean restricted) {
            this.restricted = restricted;
            return this;
        }

        public CreateCategoryBody setInstitutionRoleIds(List<String> institutionRoleIds) {
            this.institutionRoleIds = institutionRoleIds;
            return this;
        }
    }

    /*
     * Get Category
     *
     * Returns the category corresponding the provided type (course or organization) and ID
     *
     * Entitlement system.course-categories.VIEW required
     *
     * Users with entitlement "system.course.categories.MODIFY" for course categories, or "system.org.categories.MODIFY" for organization categories can view all fields and all categories.
     *
     * Users with system.course-categories.VIEW but not the corresponding MODIFY entitlements have read access to all properties except:
     *
     * - restricted
     * - institutionRoleIds
     * In addition, users without the corresponding MODIFY entitlement have access to a restricted category only if their institution role matches one of the roles in the institutionRoleIds list for that category.
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<Category> getCategory(String categoryType, String categoryId) {
        return RestCallBuilder
            .start(new TypeToken<Category>() {})
            .get()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{categoryId}")
            .pathParam("categoryType", categoryType)
            .pathParam("categoryId", categoryId)
            .build();
    }

    /*
     * Delete Category
     *
     * Deletes the category corresponding to the provided type and id
     *
     * Entitlement system.course.categories.MODIFY required to delete a course category Entitlement system.org.categories.MODIFY required to delete an organization category
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<Void> deleteCategory(String categoryType, String categoryId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{categoryId}")
            .pathParam("categoryType", categoryType)
            .pathParam("categoryId", categoryId)
            .build();
    }

    /*
     * Update Category
     *
     * Updates the category corresponding to the provided type and id.
     *
     * Entitlement system.course.categories.MODIFY required to modify course categories Entitlement system.org.categories.MODIFY required to modify organization categories
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<Category> updateCategory(String categoryType, String categoryId, UpdateCategoryBody category) {
        return RestCallBuilder
            .start(new TypeToken<Category>() {})
            .patch()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{categoryId}")
            .pathParam("categoryType", categoryType)
            .pathParam("categoryId", categoryId)
            .body(category)
            .build();
    }

    public static class UpdateCategoryBody {
        /*
         * The title of category
         */
        private String title;

        /*
         * The description of the category
         */
        private String description;

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

        public static UpdateCategoryBody create() {
            return new UpdateCategoryBody();
        }

        public UpdateCategoryBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateCategoryBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateCategoryBody setFrontPage(boolean frontPage) {
            this.frontPage = frontPage;
            return this;
        }

        public UpdateCategoryBody setAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public UpdateCategoryBody setRestricted(boolean restricted) {
            this.restricted = restricted;
            return this;
        }

        public UpdateCategoryBody setInstitutionRoleIds(List<String> institutionRoleIds) {
            this.institutionRoleIds = institutionRoleIds;
            return this;
        }
    }

    /*
     * Get Memberships
     *
     * Get courses associated with the provided category. Entitlement system.course-categories.VIEW required
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<List<CategoryCourseMembership>> getMemberships(String categoryType, String categoryId, GetMembershipsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CategoryCourseMembership>>() {})
            .get()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{categoryId}/courses")
            .pathParam("categoryType", categoryType)
            .pathParam("categoryId", categoryId)
            .options(options)
            .build();
    }

    public static class GetMembershipsOption extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>course</li></ul>
         */
        public static GetMembershipsOption expand(String expand) {
            return parameter("expand", expand, new GetMembershipsOption());
        }
    }

    /*
     * Delete Membership
     *
     * Deletes a category/course association
     *
     * The 'admin.course.categorize.MODIFY' entitlement is needed for course associations The 'admin.org.categorize.MODIFY' entitlement is needed for organization associations
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<Void> deleteMembership(String categoryType, String categoryId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{categoryId}/courses/{courseId}")
            .pathParam("categoryType", categoryType)
            .pathParam("categoryId", categoryId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Create Membership
     *
     * Creates a category/course association. The course defined by courseId must match the categoryType.
     *
     * The 'admin.course.categorize.MODIFY' entitlement is needed for course associations The 'admin.org.categorize.MODIFY' entitlement is needed for organization associations
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<CategoryCourseMembership> createMembership(String categoryType, String categoryId, String courseId) {
        return RestCallBuilder
            .start(new TypeToken<CategoryCourseMembership>() {})
            .put()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{categoryId}/courses/{courseId}")
            .pathParam("categoryType", categoryType)
            .pathParam("categoryId", categoryId)
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Get Child Categories
     *
     * Returns a list of categories which are children of the category corresponding to the provided type (course or organization) and Id
     *
     * Entitlement system.course-categories.VIEW required
     *
     * Users with entitlement "system.course.categories.MODIFY" for course categories, or "system.org.categories.MODIFY" for organization categories can view all fields and all categories.
     *
     * Users with system.course-categories.VIEW but not the corresponding MODIFY entitlements have read access to all properties except:
     *
     * - restricted
     * - institutionRoleIds
     * In addition, users without the corresponding MODIFY entitlement have access to a restricted category only if their institution role matches one of the roles in the institutionRoleIds list for that category.
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<List<Category>> getChildCategories(String categoryType, String parentId, GetChildCategoriesOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Category>>() {})
            .get()
            .url("/learn/api/public/v1/catalog/categories/{categoryType}/{parentId}/children")
            .pathParam("categoryType", categoryType)
            .pathParam("parentId", parentId)
            .options(options)
            .build();
    }

    public static class GetChildCategoriesOption extends RestCallOption {
        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "title(desc),start" Supported fields are:
         *
         * - id
         * - categoryId
         * - title
         * - available
         * - created
         *
         * **Since**: 3700.6.0
         */
        public static GetChildCategoriesOption sort(String sort) {
            return parameter("sort", sort, new GetChildCategoriesOption());
        }

        /*
         * Search for categories with titles that contain this value.
         *
         * **Since**: 3700.8.0
         */
        public static GetChildCategoriesOption title(String title) {
            return parameter("title", title, new GetChildCategoriesOption());
        }

        /*
         * Search for categories with category IDs that contain this value.
         *
         * **Since**: 3700.8.0
         */
        public static GetChildCategoriesOption categoryId(String categoryId) {
            return parameter("categoryId", categoryId, new GetChildCategoriesOption());
        }

        /*
         * Search for categories with a created date relative to this value.
         *
         * **Since**: 3700.8.0
         */
        public static GetChildCategoriesOption created(Instant created) {
            return parameter("created", created, new GetChildCategoriesOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3700.8.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetChildCategoriesOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetChildCategoriesOption());
        }

        /*
         * Search for categories with a data source id matching this value.
         *
         * **Since**: 3700.9.0
         */
        public static GetChildCategoriesOption dataSourceId(String dataSourceId) {
            return parameter("dataSourceId", dataSourceId, new GetChildCategoriesOption());
        }

        /*
         * Search for categories with a front page indicator matching this value.
         *
         * **Since**: 3700.9.0
         */
        public static GetChildCategoriesOption frontPage(boolean frontPage) {
            return parameter("frontPage", frontPage, new GetChildCategoriesOption());
        }

        /*
         * Search for categories with availability matching this value.
         *
         * **Since**: 3700.9.0
         */
        public static GetChildCategoriesOption available(boolean available) {
            return parameter("available", available, new GetChildCategoriesOption());
        }
    }

    /*
     * Get Memberships
     *
     * Get categories associated with the provided course. Entitlement system.course-categories.VIEW required
     *
     * **Since**: 3600.0.0
     */
    public static RestCall<List<CourseCategoryMembership>> getMembershipsV1(String courseId, GetMembershipsV1Option... options) {
        return RestCallBuilder
            .start(new TypeToken<List<CourseCategoryMembership>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/categories")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetMembershipsV1Option extends RestCallOption {
        /*
         * A comma-delimited list of fields to expand as part of the response. Expanded fields may cause additional load time. Supported fields are:<br><ul><li>category</li></ul>
         */
        public static GetMembershipsV1Option expand(String expand) {
            return parameter("expand", expand, new GetMembershipsV1Option());
        }
    }
}
