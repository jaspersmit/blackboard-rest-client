package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.AttemptFile;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class CourseGradeAttemptsApi {
    /*
     * Get Attempt File Meta Data List
     *
     * Get the list of file metadata for a Student Submission associated to the course and attempt.
     *
     * - Id
     * - Name
     *
     * **Since**: 3400.6.0
     */
    public static RestCall<List<AttemptFile>> getAttemptFileMetaDataList(String courseId, String attemptId) {
        return RestCallBuilder
            .start(new TypeToken<List<AttemptFile>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/attempts/{attemptId}/files")
            .pathParam("courseId", courseId)
            .pathParam("attemptId", attemptId)
            .build();
    }

    /*
     * Attach File
     *
     *
     *
     * Attach a file to an Attempt for a Student Submission. Currently only supports Classic/9.1 Course Assignments. </p>
     *
     * **Since**: 3500.7.0
     */
    public static RestCall<AttemptFile> attachFile(String courseId, String attemptId, AttachFileBody attemptFileTOPubV1) {
        return RestCallBuilder
            .start(new TypeToken<AttemptFile>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/attempts/{attemptId}/files")
            .pathParam("courseId", courseId)
            .pathParam("attemptId", attemptId)
            .body(attemptFileTOPubV1)
            .build();
    }

    public static class AttachFileBody {
        /*
         * The name of the file which has been attached to an Attempt including the file extension.
         */
        private String name;

        private String uploadId;

        public static AttachFileBody create() {
            return new AttachFileBody();
        }

        public AttachFileBody setName(String name) {
            this.name = name;
            return this;
        }

        public AttachFileBody setUploadId(String uploadId) {
            this.uploadId = uploadId;
            return this;
        }
    }

    /*
     * Get Attempt File Meta Data
     *
     * Get the file metadata for a Student Submission associated to the course and attempt.
     *
     * - Id
     * - Name
     *
     * **Since**: 3400.6.0
     */
    public static RestCall<AttemptFile> getAttemptFileMetaData(String courseId, String attemptId, String attemptFileId) {
        return RestCallBuilder
            .start(new TypeToken<AttemptFile>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/attempts/{attemptId}/files/{attemptFileId}")
            .pathParam("courseId", courseId)
            .pathParam("attemptId", attemptId)
            .pathParam("attemptFileId", attemptFileId)
            .build();
    }

    /*
     * Delete Attachment
     *
     * Delete the file for a Student Submission associated to an attempt.
     *
     * The student who owns the file can delete it while the attempt is in progress.
     *
     * **Since**: 3500.2.0
     */
    public static RestCall<Void> deleteAttachment(String courseId, String attemptId, String attemptFileId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/attempts/{attemptId}/files/{attemptFileId}")
            .pathParam("courseId", courseId)
            .pathParam("attemptId", attemptId)
            .pathParam("attemptFileId", attemptFileId)
            .build();
    }

    /*
     * Download
     *
     * Download the contents of the file for a Student Submission.
     *
     * **Since**: 3400.6.0
     */
    public static RestCall<Void> download(String courseId, String attemptId, String attemptFileId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/gradebook/attempts/{attemptId}/files/{attemptFileId}/download")
            .pathParam("courseId", courseId)
            .pathParam("attemptId", attemptId)
            .pathParam("attemptFileId", attemptFileId)
            .build();
    }
}
