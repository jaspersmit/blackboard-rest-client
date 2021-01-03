package org.jbsmit.blackboardRestClient.model;


public class QuestionHandler {
    /*
     * Type of Question supported.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Presentation |   **Since**: 3300.9.0 |
     * | EitherOr | Read Only  **Since**: 3300.9.0 |
     * | Essay | Read Only  **Since**: 3300.9.0 |
     * | MultipleAnswer | Read Only  **Since**: 3400.4.0 |
     * | Numeric | Read Only  **Since**: 3400.4.0 |
     * | MultipleChoice | Read Only  **Since**: 3400.4.0 |
     * | Ordering | Read Only  **Since**: 3400.4.0 |
     * | Matching | Read Only  **Since**: 3400.4.0 |
     * | FillInTheBlank | Read Only  **Since**: 3400.4.0 |
     * | Calculated | Read Only  **Since**: 3400.4.0 |
     * | FileResponse | Read Only  **Since**: 3400.4.0 |
     * | LikertOpinionScale | Read Only  **Since**: 3400.4.0 |
     * | QuizBowl | Read Only  **Since**: 3400.4.0 |
     * | HotSpot | Read Only  **Since**: 3400.4.0 |
     * | JumbledSentence | Read Only  **Since**: 3400.4.0 |
     * | FillInTheBlankPlus | Read Only  **Since**: 3400.4.0 |
     * | QuestionBlock | Read Only  **Since**: 3700.2.0 |
     *
     */
    private Type type;


    public enum Type {
        Presentation,
        EitherOr,
        Essay,
        MultipleAnswer,
        Numeric,
        MultipleChoice,
        Ordering,
        Matching,
        FillInTheBlank,
        Calculated,
        FileResponse,
        LikertOpinionScale,
        QuizBowl,
        HotSpot,
        JumbledSentence,
        FillInTheBlankPlus,
        QuestionBlock
    }

    public Type getType() {
        return type;
    }

    public QuestionHandler setType(Type type) {
        this.type = type;
        return this;
    }
}

