package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.util.List;

import org.jbsmit.blackboardRestClient.model.Question;
import org.jbsmit.blackboardRestClient.model.QuestionHandler;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class CourseAssessmentsApi {
    /*
     * Get Questions
     *
     * Get the list of questions for an Ultra Assessment.
     *
     * Either 'course.assessment.CREATE' or 'course.assessment.MODIFY' entitlement is needed to view questions. If the assessment has the external submissions setting enabled, then either the 'course.assessment.VIEW' or 'course.assessment.EXECUTE' entitlement is needed to view questions, and only presentation questions are returned.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<List<Question>> getQuestions(String courseId, String assessmentId) {
        return RestCallBuilder
            .start(new TypeToken<List<Question>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/assessments/{assessmentId}/questions")
            .pathParam("courseId", courseId)
            .pathParam("assessmentId", assessmentId)
            .build();
    }

    /*
     * Create Question
     *
     * Creates a question for an Ultra Assessment.
     *
     * The 'course.assessment.MODIFY' entitlement is needed to create a question.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<Question> createQuestion(String courseId, String assessmentId, CreateQuestionBody input) {
        return RestCallBuilder
            .start(new TypeToken<Question>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/assessments/{assessmentId}/questions")
            .pathParam("courseId", courseId)
            .pathParam("assessmentId", assessmentId)
            .body(input)
            .build();
    }

    public static class CreateQuestionBody {
        /*
         * The title of the question.
         */
        private String title;

        /*
         * The main text content for the question. It may include plain and formatted text, and all kinds of content supported by the full text editor.
         */
        private String text;

        /*
         * Position of the Question on the Assessment Canvas.
         */
        private int position;

        /*
         * The point value for the question.
         */
        private BigDecimal points;

        /*
         * Feedback displayed to students when their submitted response is correct.
         */
        private String correctResponseFeedback;

        /*
         * Feedback displayed to students when their submitted response is incorrect.
         */
        private String incorrectResponseFeedback;

        /*
         * Text added to the question as a note for the instructor. It is not intended to be displayed to students.
         */
        private String instructorNotes;

        private QuestionHandler questionHandler;

        public static CreateQuestionBody create() {
            return new CreateQuestionBody();
        }

        public CreateQuestionBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateQuestionBody setText(String text) {
            this.text = text;
            return this;
        }

        public CreateQuestionBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public CreateQuestionBody setPoints(BigDecimal points) {
            this.points = points;
            return this;
        }

        public CreateQuestionBody setCorrectResponseFeedback(String correctResponseFeedback) {
            this.correctResponseFeedback = correctResponseFeedback;
            return this;
        }

        public CreateQuestionBody setIncorrectResponseFeedback(String incorrectResponseFeedback) {
            this.incorrectResponseFeedback = incorrectResponseFeedback;
            return this;
        }

        public CreateQuestionBody setInstructorNotes(String instructorNotes) {
            this.instructorNotes = instructorNotes;
            return this;
        }

        public CreateQuestionBody setQuestionHandler(QuestionHandler questionHandler) {
            this.questionHandler = questionHandler;
            return this;
        }
    }

    /*
     * Get Question By Id
     *
     * Get a question by Id from an Ultra Assessment.
     *
     * Either 'course.assessment.CREATE' or 'course.assessment.MODIFY' entitlement is needed to view a question.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<Question> getQuestionById(String courseId, String assessmentId, String questionId) {
        return RestCallBuilder
            .start(new TypeToken<Question>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/assessments/{assessmentId}/questions/{questionId}")
            .pathParam("courseId", courseId)
            .pathParam("assessmentId", assessmentId)
            .pathParam("questionId", questionId)
            .build();
    }

    /*
     * Delete Question
     *
     * Delete a question, specified by Id, from an Ultra Assessment.
     *
     * The 'course.assessment.DELETE' entitlement is needed to perform the operation.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<Void> deleteQuestion(String courseId, String assessmentId, String questionId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/assessments/{assessmentId}/questions/{questionId}")
            .pathParam("courseId", courseId)
            .pathParam("assessmentId", assessmentId)
            .pathParam("questionId", questionId)
            .build();
    }

    /*
     * Update Question
     *
     * Update a question, specified by Id, from an Ultra Assessment.
     *
     * The 'course.assessment.MODIFY' entitlement is needed to perform the operation.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<Question> updateQuestion(String courseId, String assessmentId, String questionId, UpdateQuestionBody input) {
        return RestCallBuilder
            .start(new TypeToken<Question>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/assessments/{assessmentId}/questions/{questionId}")
            .pathParam("courseId", courseId)
            .pathParam("assessmentId", assessmentId)
            .pathParam("questionId", questionId)
            .body(input)
            .build();
    }

    public static class UpdateQuestionBody {
        /*
         * The title of the question.
         */
        private String title;

        /*
         * The main text content for the question. It may include plain and formatted text, and all kinds of content supported by the full text editor.
         */
        private String text;

        /*
         * Position of the Question on the Assessment Canvas.
         */
        private int position;

        /*
         * The point value for the question.
         */
        private BigDecimal points;

        /*
         * Feedback displayed to students when their submitted response is correct.
         */
        private String correctResponseFeedback;

        /*
         * Feedback displayed to students when their submitted response is incorrect.
         */
        private String incorrectResponseFeedback;

        /*
         * Text added to the question as a note for the instructor. It is not intended to be displayed to students.
         */
        private String instructorNotes;

        private QuestionHandler questionHandler;

        public static UpdateQuestionBody create() {
            return new UpdateQuestionBody();
        }

        public UpdateQuestionBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateQuestionBody setText(String text) {
            this.text = text;
            return this;
        }

        public UpdateQuestionBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public UpdateQuestionBody setPoints(BigDecimal points) {
            this.points = points;
            return this;
        }

        public UpdateQuestionBody setCorrectResponseFeedback(String correctResponseFeedback) {
            this.correctResponseFeedback = correctResponseFeedback;
            return this;
        }

        public UpdateQuestionBody setIncorrectResponseFeedback(String incorrectResponseFeedback) {
            this.incorrectResponseFeedback = incorrectResponseFeedback;
            return this;
        }

        public UpdateQuestionBody setInstructorNotes(String instructorNotes) {
            this.instructorNotes = instructorNotes;
            return this;
        }

        public UpdateQuestionBody setQuestionHandler(QuestionHandler questionHandler) {
            this.questionHandler = questionHandler;
            return this;
        }
    }
}
