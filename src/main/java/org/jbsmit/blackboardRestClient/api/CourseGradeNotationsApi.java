package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.GradeNotation;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class CourseGradeNotationsApi {
    /*
     * Get Grade Notations
     *
     * Returns a list of grade notations.
     *
     * The entitlement "course.user.grades.VIEW" is needed.
     *
     * **Since**: 3200.13.0
     */
    public static RestCall<List<GradeNotation>> getGradeNotations(String courseId) {
        return RestCallBuilder
            .start(new TypeToken<List<GradeNotation>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/gradeNotations")
            .pathParam("courseId", courseId)
            .build();
    }

    /*
     * Create Grade Notation
     *
     * Create a grade notation on this course.
     *
     * The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3200.13.0
     */
    public static RestCall<GradeNotation> createGradeNotation(String courseId, CreateGradeNotationBody gradeNotationInput) {
        return RestCallBuilder
            .start(new TypeToken<GradeNotation>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/gradeNotations")
            .pathParam("courseId", courseId)
            .body(gradeNotationInput)
            .build();
    }

    public static class CreateGradeNotationBody {
        /*
         * The performance code associated with the grade notation.
         */
        private String code;

        /*
         * The description of the grade notation.
         */
        private String description;

        public static CreateGradeNotationBody create() {
            return new CreateGradeNotationBody();
        }

        public CreateGradeNotationBody setCode(String code) {
            this.code = code;
            return this;
        }

        public CreateGradeNotationBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }

    /*
     * Get Grade Notation
     *
     * Returns a specific grade notation.
     *
     * The entitlement "course.user.grades.VIEW" is needed.
     *
     * **Since**: 3200.13.0
     */
    public static RestCall<GradeNotation> getGradeNotation(String courseId, String gradeNotationId) {
        return RestCallBuilder
            .start(new TypeToken<GradeNotation>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/gradeNotations/{gradeNotationId}")
            .pathParam("courseId", courseId)
            .pathParam("gradeNotationId", gradeNotationId)
            .build();
    }

    /*
     * Delete Grade Notation
     *
     * Delete a specific grade notation.
     *
     * The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3200.13.0
     */
    public static RestCall<Void> deleteGradeNotation(String courseId, String gradeNotationId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/gradeNotations/{gradeNotationId}")
            .pathParam("courseId", courseId)
            .pathParam("gradeNotationId", gradeNotationId)
            .build();
    }

    /*
     * Update Grade Notation
     *
     * Update a grade notation on this course.
     *
     * The entitlement "course.gradebook.MODIFY" is needed.
     *
     * **Since**: 3200.14.0
     */
    public static RestCall<GradeNotation> updateGradeNotation(String courseId, String gradeNotationId, UpdateGradeNotationBody gradeNotationInput) {
        return RestCallBuilder
            .start(new TypeToken<GradeNotation>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/gradeNotations/{gradeNotationId}")
            .pathParam("courseId", courseId)
            .pathParam("gradeNotationId", gradeNotationId)
            .body(gradeNotationInput)
            .build();
    }

    public static class UpdateGradeNotationBody {
        /*
         * The performance code associated with the grade notation.
         */
        private String code;

        /*
         * The description of the grade notation.
         */
        private String description;

        public static UpdateGradeNotationBody create() {
            return new UpdateGradeNotationBody();
        }

        public UpdateGradeNotationBody setCode(String code) {
            this.code = code;
            return this;
        }

        public UpdateGradeNotationBody setDescription(String description) {
            this.description = description;
            return this;
        }
    }
}
