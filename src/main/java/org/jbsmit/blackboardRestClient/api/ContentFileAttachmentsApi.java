package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.FileAttachment;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class ContentFileAttachmentsApi {
    /*
     * Get File Attachments
     *
     * Get the file attachment meta data associated to the Content Item
     *
     * Supported Content Item Types: Content File (resource/x-bb-file), Document (resource/x-bb-document), Classic Assignment (resource/x-bb-assignment) (Since 3400.9.0) for a Classic Course
     *
     * **Since**: 3200.8.0
     */
    public static RestCall<List<FileAttachment>> getFileAttachments(String courseId, String contentId) {
        return RestCallBuilder
            .start(new TypeToken<List<FileAttachment>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/attachments")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .build();
    }

    /*
     * Create File Attachment
     *
     * Attach an uploaded file to a Content item.
     *
     * Supported Content Item Types: Content File (resource/x-bb-file), Document (resource/x-bb-document), Classic Assignment (resource/x-bb-assignment) for a Classic Course
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<FileAttachment> createFileAttachment(String courseId, String contentId, CreateFileAttachmentBody inputFileAttachment) {
        return RestCallBuilder
            .start(new TypeToken<FileAttachment>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/attachments")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .body(inputFileAttachment)
            .build();
    }

    public static class CreateFileAttachmentBody { }
    /*
     * Get File Attachment
     *
     * Get the file attachment meta data by an attachment ID
     *
     * Supported Content Item Types: Content File (resource/x-bb-file), Document (resource/x-bb-document), Classic Assignment(resource/x-bb-assignment) (Since 3400.9.0) for a Classic Course
     *
     * **Since**: 3200.8.0
     */
    public static RestCall<FileAttachment> getFileAttachment(String courseId, String contentId, String attachmentId) {
        return RestCallBuilder
            .start(new TypeToken<FileAttachment>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/attachments/{attachmentId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("attachmentId", attachmentId)
            .build();
    }

    /*
     * Delete File Attachment
     *
     * Delete file attachment meta data by attachment ID
     *
     * Supported Content Item Types: Content File (resource/x-bb-file), Document (resource/x-bb-document), Classic Assignment(resource/x-bb-assignment) for a Classic Course
     *
     * **Since**: 3400.9.0
     */
    public static RestCall<Void> deleteFileAttachment(String courseId, String contentId, String attachmentId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/attachments/{attachmentId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("attachmentId", attachmentId)
            .build();
    }

    /*
     * Download
     *
     * Download the contents of a Content Item.
     *
     * Supported Content Item Types: Content File (resource/x-bb-file), Document (resource/x-bb-document), Classic Assignment (resource/x-bb-assignment) (Since 3400.9.0) for a Classic Course
     *
     * **Since**: 3200.8.0
     */
    public static RestCall<Void> download(String courseId, String contentId, String attachmentId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/attachments/{attachmentId}/download")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .pathParam("attachmentId", attachmentId)
            .build();
    }
}
