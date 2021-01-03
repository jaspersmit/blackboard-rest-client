package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.GradebookCategory;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class CourseGradebookCategoriesApi {
    /*
     * Get Gradebook Categories
     *
     * Returns a list of gradebook categories in a particular course.
     *
     * Users with entitlements 'course.gradebook.MODIFY' or 'course.user.grades.VIEW', or users enrolled in the specified course can retrieve the list of gradebook categories.
     *
     * **Since**: 3400.2.0
     */
    public static RestCall<List<GradebookCategory>> getGradebookCategories(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<GradebookCategory>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/categories")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Get Gradebook Category
     *
     * Returns the details of a gradebook category
     *
     * Users with entitlements 'course.gradebook.MODIFY' or 'course.user.grades.VIEW', or users enrolled in the specified course can retrieve gradebook category details.
     *
     * **Since**: 3400.2.0
     */
    public static RestCall<GradebookCategory> getGradebookCategory(String courseId, String categoryId) {
        return RestCallBuilder
            .start(new TypeToken<GradebookCategory>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/categories/{categoryId}")
            .pathParam("courseId", courseId)
            .pathParam("categoryId", categoryId)
            .build();
    }
}
