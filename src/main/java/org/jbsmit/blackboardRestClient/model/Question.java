package org.jbsmit.blackboardRestClient.model;

import java.math.BigDecimal;

public class Question {
    /*
     * The id of the question.
     */
    private String id;

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


    public String getId() {
        return id;
    }

    public Question setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Question setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Question setText(String text) {
        this.text = text;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Question setPosition(int position) {
        this.position = position;
        return this;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public Question setPoints(BigDecimal points) {
        this.points = points;
        return this;
    }

    public String getCorrectResponseFeedback() {
        return correctResponseFeedback;
    }

    public Question setCorrectResponseFeedback(String correctResponseFeedback) {
        this.correctResponseFeedback = correctResponseFeedback;
        return this;
    }

    public String getIncorrectResponseFeedback() {
        return incorrectResponseFeedback;
    }

    public Question setIncorrectResponseFeedback(String incorrectResponseFeedback) {
        this.incorrectResponseFeedback = incorrectResponseFeedback;
        return this;
    }

    public String getInstructorNotes() {
        return instructorNotes;
    }

    public Question setInstructorNotes(String instructorNotes) {
        this.instructorNotes = instructorNotes;
        return this;
    }

    public QuestionHandler getQuestionHandler() {
        return questionHandler;
    }

    public Question setQuestionHandler(QuestionHandler questionHandler) {
        this.questionHandler = questionHandler;
        return this;
    }
}

