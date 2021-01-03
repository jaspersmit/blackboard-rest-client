package org.jbsmit.blackboardRestClient.model;

import java.util.List;

public class CreateAssignmentResult {
    /*
     * Id of the content created during the assignment creation.
     */
    private String contentId;

    /*
     * Id of the grade column created during the assignment creation.
     */
    private String gradeColumnId;

    /*
     * Id of the assessment created during the assignment creation.  This is only created for Ultra course assignments.
     */
    private String assessmentId;

    /*
     * Ids of the assessment questions created during the assignment creation.  This is only created for Ultra course assignments.
     */
    private List<String> questionIds;

    /*
     * Ids of the file attachments created during assignment creation.  This is only created for Classic course assignments
     */
    private List<String> attachmentIds;


    public String getContentId() {
        return contentId;
    }

    public CreateAssignmentResult setContentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    public String getGradeColumnId() {
        return gradeColumnId;
    }

    public CreateAssignmentResult setGradeColumnId(String gradeColumnId) {
        this.gradeColumnId = gradeColumnId;
        return this;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public CreateAssignmentResult setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
        return this;
    }

    public List<String> getQuestionIds() {
        return questionIds;
    }

    public CreateAssignmentResult setQuestionIds(List<String> questionIds) {
        this.questionIds = questionIds;
        return this;
    }

    public List<String> getAttachmentIds() {
        return attachmentIds;
    }

    public CreateAssignmentResult setAttachmentIds(List<String> attachmentIds) {
        this.attachmentIds = attachmentIds;
        return this;
    }
}

