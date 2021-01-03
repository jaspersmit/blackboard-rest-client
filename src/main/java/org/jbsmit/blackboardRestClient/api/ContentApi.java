package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.jbsmit.blackboardRestClient.model.Content;
import org.jbsmit.blackboardRestClient.model.ContentHandler;
import org.jbsmit.blackboardRestClient.model.CreateAssignmentResult;
import org.jbsmit.blackboardRestClient.model.OriginalityReportingTool;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class ContentApi {
    /*
     * Get Contents
     *
     * List top-level content items in a course.
     *
     * Users with at least one of the following entitlements may access any content item:
     *
     * - course.adaptiverelease.CREATE
     * - course.adaptiverelease.DELETE
     * - course.adaptiverelease.MODIFY
     * - course.adaptiverelease.VIEW
     * - course.configure-areas.EXECUTE
     * - course.content-item.copy.EXECUTE
     * - course.content.DELETE
     * - course.content.MODIFY
     * - course.learningstandards.alignment.CREATE
     * - course.performance.dashboard.VIEW
     * </p>
     *
     * For other users, permission to view the content item will depend on the availability settings of the course and  the content item.  The following fields will be filtered out:
     *
     * - availability.available
     * - availability.allowGuests
     * - availability.adaptiveRelease
     * </p>
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<List<Content>> getContents(String courseId, GetContentsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Content>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents")
            .pathParam("courseId", courseId)
            .options(options)
            .build();
    }

    public static class GetContentsOption extends RestCallOption {
        /*
         * Search for child content recursively.  A value of 'true' indicates that search results should include all content descendants within the hierarchy of the specified parent.  A value of 'false' indicates results should be limited to immediate children only.  Not setting this field defaults to 'false' behavior; only including immediate children.
         *
         * **Since**: 3100.2.0
         */
        public static GetContentsOption recursive(boolean recursive) {
            return parameter("recursive", recursive, new GetContentsOption());
        }

        /*
         * Search for the specific content handler.  Not setting this field will return all content handlers.
         *
         * **Since**: 3400.5.0
         */
        public static GetContentsOption contentHandler(String contentHandler) {
            return parameter("contentHandler", contentHandler, new GetContentsOption());
        }

        /*
         * Search for contents with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3700.1.0
         */
        public static GetContentsOption created(Instant created) {
            return parameter("created", created, new GetContentsOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3700.1.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetContentsOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetContentsOption());
        }

        /*
         * Search for contents with a modified date relative to this value.  'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3700.4.0
         */
        public static GetContentsOption modified(Instant modified) {
            return parameter("modified", modified, new GetContentsOption());
        }

        /*
         * Used alongside the 'modified' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3700.4.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetContentsOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetContentsOption());
        }

        /*
         * Search contents by whether they are reviewable or not.
         *
         * **Since**: 3700.15.0
         */
        public static GetContentsOption reviewable(boolean reviewable) {
            return parameter("reviewable", reviewable, new GetContentsOption());
        }
    }

    /*
     * Create Content
     *
     * Create a new top-level content item. Currently only folders may be created as top-level content items in a Classic course. For Ultra courses any content item is allowed and will be placed under the ROOT folder. Entitlement "course.content.CREATE" required to create Course Content.
     *
     * **Since**: 3000.7.0
     */
    public static RestCall<Content> createContent(String courseId, CreateContentBody input) {
        return RestCallBuilder
            .start(new TypeToken<Content>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/contents")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateContentBody {
        /*
         * The ID of the content's parent.  Note that top-level contents do not have parents. The 'parentId' field is a writable field as of the Bb Learn 3200.6.0 release.  Specifying a new value in PATCH requests allows the Content object to be moved from one parent to another.
         */
        private String parentId;

        /*
         * The title or name of this content. Typically shown as the main text to click in the course outline when accessing the content.
         */
        private String title;

        /*
         * The body text associated with this content. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * The short description of this content.
         *
         * This field is not used in Classic courses.  For Ultra courses this is used to show information directly on the course outline.
         */
        private String description;

        /*
         * The position of this content within its parent folder. Position values are zero-based (the first element has a position value of zero, not one). Default position is last in the list of child contents under the parent.
         */
        private int position;

        /*
         * Indicates whether the content is going to open in a new window.
         *
         * **Since**: 3800.10.0
         */
        private boolean launchInNewWindow;

        /*
         * Indicates whether Review Status is enabled for this content. Content items with review status enabled can be marked as reviewed by students. This can be used to track performance and in Adaptive Release rules to control the release of other content. Reviewable field is currently being used only in Classic courses.
         *
         * **Since**: 3700.15.0
         */
        private boolean reviewable;

        /*
         * Settings controlling availability of the content to students.
         */
        private Availability availability;

        /*
         * Extended settings specific to this content item's content handler.
         */
        private ContentHandler contentHandler;

        public static CreateContentBody create() {
            return new CreateContentBody();
        }

        public static class Availability {
            /*
             * Whether the content is currently available to students.  Instructors can always access the content.  If set to 'PartiallyVisible', the title will be available to students but the body will not.  Defaults to Yes.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes |  |
             * | No |  |
             * | PartiallyVisible |  |
             *
             */
            private Available available;

            /*
             * Whether this content is available to users with the 'guest' role. Defaults to true.
             */
            private boolean allowGuests;

            /*
             * Settings controlling adaptive release of the content to students.
             */
            private AdaptiveRelease adaptiveRelease;

            public static Availability create() {
                return new Availability();
            }

            public static class AdaptiveRelease {
                /*
                 * The date when this content will become available to students.
                 */
                private Instant start;

                /*
                 * The date when this content will no longer be available to students.
                 */
                private Instant end;

                public static AdaptiveRelease create() {
                    return new AdaptiveRelease();
                }

                public AdaptiveRelease setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public AdaptiveRelease setEnd(Instant end) {
                    this.end = end;
                    return this;
                }
            }

            public enum Available {
                Yes,
                No,
                PartiallyVisible
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }

            public Availability setAllowGuests(boolean allowGuests) {
                this.allowGuests = allowGuests;
                return this;
            }

            public Availability setAdaptiveRelease(AdaptiveRelease adaptiveRelease) {
                this.adaptiveRelease = adaptiveRelease;
                return this;
            }
        }

        public CreateContentBody setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public CreateContentBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateContentBody setBody(String body) {
            this.body = body;
            return this;
        }

        public CreateContentBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateContentBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public CreateContentBody setLaunchInNewWindow(boolean launchInNewWindow) {
            this.launchInNewWindow = launchInNewWindow;
            return this;
        }

        public CreateContentBody setReviewable(boolean reviewable) {
            this.reviewable = reviewable;
            return this;
        }

        public CreateContentBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateContentBody setContentHandler(ContentHandler contentHandler) {
            this.contentHandler = contentHandler;
            return this;
        }
    }

    /*
     * Create Assignment
     *
     * Create assignment content, grade column and file attachments in one POST. Any files specified with assignment creation must be previously uploaded using the uploads endpoint. Ultra courses supported since 3300.9.0 Classic courses supported since 3400.9.0 </p> For Ultra courses, this will create:
     *
     * - A content item with a contentHandler.id = resource/x-bb-asmt-test-link
     * - A gradebook column with contentId = id of the new content
     * - An assessment question with questionHandler.type = presentation that includes the instructions as the question text
     * - An assessment question with questionHandler.type = presentation for each given file attachment
     * </p> The following entitlements are required to create an Ultra assignment:
     *
     * - course.content.CREATE
     * - course.assessment.CREATE
     * - course.content.assessment.deploy.EXECUTE
     * - course.gradebook.MODIFY
     * - course.assessment.MODIFY, if instructions or files are specified
     * </p> For Classic courses, this will create:
     *
     * - A content item with contentHandler.id = resource/x-bb-assignment
     * - A gradebook column with contentId = id of the new content
     * - A file attachment for each given file attachment id
     * The following entitlements are required to create a Classic assignment:
     *
     * - course.content.CREATE
     * - course.gradebook.MODIFY
     * - course.content.MODIFY, if files are specified
     * </p>
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<CreateAssignmentResult> createAssignment(String courseId, CreateAssignmentBody input) {
        return RestCallBuilder
            .start(new TypeToken<CreateAssignmentResult>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/contents/createAssignment")
            .pathParam("courseId", courseId)
            .body(input)
            .build();
    }

    public static class CreateAssignmentBody {
        /*
         * The id of the parent content for the created assignment.
         */
        private String parentId;

        /*
         * The title used for the created assignment content and gradebook column. Typically shown as the main text to click in the course outline when accessing the assignment.
         */
        private String title;

        /*
         * The text instructions to use when creating the assignment content. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String instructions;

        /*
         * The description to use when creating the assignment content.
         */
        private String description;

        /*
         * The position of the created assignment within the other other content of its parent. Position values are zero-based (the first element has a position value of zero, not one). Default position is last in the list of child contents under the parent.
         */
        private int position;

        private List<String> fileUploadIds;

        private Availability availability;

        private Grading grading;

        private Score score;

        /*
         * The Originality Reporting Tool options to be used for the assignment content item.
         *
         * **Since**: 3800.16.0
         */
        private OriginalityReportingTool originalityReportingTool;

        public static CreateAssignmentBody create() {
            return new CreateAssignmentBody();
        }

        public static class Availability {
            /*
             * Whether the created assignment is available to students. Instructors can always access the created assignment. If set to 'PartiallyVisible', the title will be available to students but the body will not. Defaults to Yes.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes |  |
             * | No |  |
             * | PartiallyVisible |  |
             *
             */
            private Available available;

            /*
             * Whether the created assignment is available to users with the 'guest' role. Defaults to true.
             */
            private boolean allowGuests;

            /*
             * Settings controlling adaptive release of created assignment to students.
             */
            private AdaptiveRelease adaptiveRelease;

            public static Availability create() {
                return new Availability();
            }

            public static class AdaptiveRelease {
                /*
                 * The date when the created assignment will become available to students.
                 */
                private Instant start;

                /*
                 * The date when the created assignment will no longer be available to students.
                 */
                private Instant end;

                public static AdaptiveRelease create() {
                    return new AdaptiveRelease();
                }

                public AdaptiveRelease setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public AdaptiveRelease setEnd(Instant end) {
                    this.end = end;
                    return this;
                }
            }

            public enum Available {
                Yes,
                No,
                PartiallyVisible
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }

            public Availability setAllowGuests(boolean allowGuests) {
                this.allowGuests = allowGuests;
                return this;
            }

            public Availability setAdaptiveRelease(AdaptiveRelease adaptiveRelease) {
                this.adaptiveRelease = adaptiveRelease;
                return this;
            }
        }

        public static class Grading {
            /*
             * Date and time that the created assignment will be due. If not specified, this will default to the specified "availability.adaptiveRelease.end" date. If that is also not specified, due date defaults to null.
             */
            private Instant due;

            /*
             * The number of attempts allowed on the created assignment. Defaults to 1. Maximum allowed is 10 for an Ultra Assignment. Value will be ignored if isUnlimitedAttemptsAllowed is set to true.
             */
            private int attemptsAllowed;

            /*
             * The grading schema to use for the created assignment. Defaults to Score.
             */
            private String gradeSchemaId;

            /*
             * Determines if the assignment has unlimited number of attempts.
             *
             * **Since**: 3400.8.0
             */
            private boolean isUnlimitedAttemptsAllowed;

            public static Grading create() {
                return new Grading();
            }

            public Grading setDue(Instant due) {
                this.due = due;
                return this;
            }

            public Grading setAttemptsAllowed(int attemptsAllowed) {
                this.attemptsAllowed = attemptsAllowed;
                return this;
            }

            public Grading setGradeSchemaId(String gradeSchemaId) {
                this.gradeSchemaId = gradeSchemaId;
                return this;
            }

            public Grading setIsUnlimitedAttemptsAllowed(boolean isUnlimitedAttemptsAllowed) {
                this.isUnlimitedAttemptsAllowed = isUnlimitedAttemptsAllowed;
                return this;
            }
        }

        public static class Score {
            /*
             * The number of points possible for the created assignment. Defaults to 100.
             */
            private BigDecimal possible;

            public static Score create() {
                return new Score();
            }

            public Score setPossible(BigDecimal possible) {
                this.possible = possible;
                return this;
            }
        }

        public CreateAssignmentBody setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public CreateAssignmentBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateAssignmentBody setInstructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public CreateAssignmentBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateAssignmentBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public CreateAssignmentBody setFileUploadIds(List<String> fileUploadIds) {
            this.fileUploadIds = fileUploadIds;
            return this;
        }

        public CreateAssignmentBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateAssignmentBody setGrading(Grading grading) {
            this.grading = grading;
            return this;
        }

        public CreateAssignmentBody setScore(Score score) {
            this.score = score;
            return this;
        }

        public CreateAssignmentBody setOriginalityReportingTool(OriginalityReportingTool originalityReportingTool) {
            this.originalityReportingTool = originalityReportingTool;
            return this;
        }
    }

    /*
     * Get Content
     *
     * Load a specific content item from a course.
     *
     * Users with at least one of the following entitlements may access any content item:
     *
     * - course.adaptiverelease.CREATE
     * - course.adaptiverelease.DELETE
     * - course.adaptiverelease.MODIFY
     * - course.adaptiverelease.VIEW
     * - course.configure-areas.EXECUTE
     * - course.content-item.copy.EXECUTE
     * - course.content.DELETE
     * - course.content.MODIFY
     * - course.learningstandards.alignment.CREATE
     * - course.performance.dashboard.VIEW
     *
     * For other users, permission to view the content item will depend on the availability settings of the course and the content item.  The following fields will be filtered out:
     *
     * - availability.available
     * - availability.allowGuests
     * - availability.adaptiveRelease
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<Content> getContent(String courseId, String contentId) {
        return RestCallBuilder
            .start(new TypeToken<Content>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .build();
    }

    /*
     * Delete Content
     *
     * Delete a content item.
     *
     * The 'course.content.DELETE' entitlement is required.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<Void> deleteContent(String courseId, String contentId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .build();
    }

    /*
     * Update Content
     *
     * Update a content item.
     *
     * The 'course.content.MODIFY' entitlement is required.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<Content> updateContent(String courseId, String contentId, UpdateContentBody input) {
        return RestCallBuilder
            .start(new TypeToken<Content>() {})
            .patch()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .body(input)
            .build();
    }

    public static class UpdateContentBody {
        /*
         * The ID of the content's parent.  Note that top-level contents do not have parents. The 'parentId' field is a writable field as of the Bb Learn 3200.6.0 release.  Specifying a new value in PATCH requests allows the Content object to be moved from one parent to another.
         */
        private String parentId;

        /*
         * The title or name of this content. Typically shown as the main text to click in the course outline when accessing the content.
         */
        private String title;

        /*
         * The body text associated with this content. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * The short description of this content.
         *
         * This field is not used in Classic courses.  For Ultra courses this is used to show information directly on the course outline.
         */
        private String description;

        /*
         * The position of this content within its parent folder. Position values are zero-based (the first element has a position value of zero, not one). Default position is last in the list of child contents under the parent.
         */
        private int position;

        /*
         * Indicates whether the content is going to open in a new window.
         *
         * **Since**: 3800.10.0
         */
        private boolean launchInNewWindow;

        /*
         * Indicates whether Review Status is enabled for this content. Content items with review status enabled can be marked as reviewed by students. This can be used to track performance and in Adaptive Release rules to control the release of other content. Reviewable field is currently being used only in Classic courses.
         *
         * **Since**: 3700.15.0
         */
        private boolean reviewable;

        /*
         * Settings controlling availability of the content to students.
         */
        private Availability availability;

        /*
         * Extended settings specific to this content item's content handler.
         */
        private ContentHandler contentHandler;

        public static UpdateContentBody create() {
            return new UpdateContentBody();
        }

        public static class Availability {
            /*
             * Whether the content is currently available to students.  Instructors can always access the content.  If set to 'PartiallyVisible', the title will be available to students but the body will not.  Defaults to Yes.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes |  |
             * | No |  |
             * | PartiallyVisible |  |
             *
             */
            private Available available;

            /*
             * Whether this content is available to users with the 'guest' role. Defaults to true.
             */
            private boolean allowGuests;

            /*
             * Settings controlling adaptive release of the content to students.
             */
            private AdaptiveRelease adaptiveRelease;

            public static Availability create() {
                return new Availability();
            }

            public static class AdaptiveRelease {
                /*
                 * The date when this content will become available to students.
                 */
                private Instant start;

                /*
                 * The date when this content will no longer be available to students.
                 */
                private Instant end;

                public static AdaptiveRelease create() {
                    return new AdaptiveRelease();
                }

                public AdaptiveRelease setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public AdaptiveRelease setEnd(Instant end) {
                    this.end = end;
                    return this;
                }
            }

            public enum Available {
                Yes,
                No,
                PartiallyVisible
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }

            public Availability setAllowGuests(boolean allowGuests) {
                this.allowGuests = allowGuests;
                return this;
            }

            public Availability setAdaptiveRelease(AdaptiveRelease adaptiveRelease) {
                this.adaptiveRelease = adaptiveRelease;
                return this;
            }
        }

        public UpdateContentBody setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public UpdateContentBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateContentBody setBody(String body) {
            this.body = body;
            return this;
        }

        public UpdateContentBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateContentBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public UpdateContentBody setLaunchInNewWindow(boolean launchInNewWindow) {
            this.launchInNewWindow = launchInNewWindow;
            return this;
        }

        public UpdateContentBody setReviewable(boolean reviewable) {
            this.reviewable = reviewable;
            return this;
        }

        public UpdateContentBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdateContentBody setContentHandler(ContentHandler contentHandler) {
            this.contentHandler = contentHandler;
            return this;
        }
    }

    /*
     * Get Content Children
     *
     * List all child content items directly beneath another content item.  This is only valid for content items that are allowed to have children (e.g. Folders).
     *
     * Users with at least one of the following entitlements may access all child contents from a content item:
     *
     * - course.adaptiverelease.CREATE
     * - course.adaptiverelease.DELETE
     * - course.adaptiverelease.MODIFY
     * - course.adaptiverelease.VIEW
     * - course.configure-areas.EXECUTE
     * - course.content-item.copy.EXECUTE
     * - course.content.DELETE
     * - course.content.MODIFY
     * - course.learningstandards.alignment.CREATE
     * - course.performance.dashboard.VIEW
     * In any of the following cases, the user may also get the child contents from a content item.
     *
     * - The user has a role in the course other than guest or observer, and doesn't have any of the previously mentioned entitlements.
     * - The user has the role of observer, and both the course and the underlying content allow observer access.
     * - The user accesses the course as guest, both the course and the underlying content allow guest access, further, the course content menu allows guest access as well for the original courses.
     * For other users, permission to view the content item will depend on the availability settings of the course and  the content item. The following fields will be filtered out:
     *
     * - availability.available
     * - availability.allowGuests
     * - availability.adaptiveRelease
     * </p>
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<List<Content>> getContentChildren(String courseId, String contentId, GetContentChildrenOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<Content>>() {})
            .get()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/children")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .options(options)
            .build();
    }

    public static class GetContentChildrenOption extends RestCallOption {
        /*
         * Search for child content recursively.  A value of 'true' indicates that search results should include all content descendants within the hierarchy of the specified parent.  A value of 'false' indicates results should be limited to immediate children only.  Not setting this field defaults to 'false' behavior; only including immediate children.
         *
         * **Since**: 3100.2.0
         */
        public static GetContentChildrenOption recursive(boolean recursive) {
            return parameter("recursive", recursive, new GetContentChildrenOption());
        }

        /*
         * Search for the specific content handler.  Not setting this field will return all content handlers.
         *
         * **Since**: 3400.5.0
         */
        public static GetContentChildrenOption contentHandler(String contentHandler) {
            return parameter("contentHandler", contentHandler, new GetContentChildrenOption());
        }

        /*
         * Search for contents with a created date relative to this value.  'createdCompare' may also be sent to control search behavior.
         *
         * **Since**: 3700.1.0
         */
        public static GetContentChildrenOption created(Instant created) {
            return parameter("created", created, new GetContentChildrenOption());
        }

        /*
         * Used alongside the 'created' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3700.1.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetContentChildrenOption createdCompare(String createdCompare) {
            return parameter("createdCompare", createdCompare, new GetContentChildrenOption());
        }

        /*
         * Search for contents with a modified date relative to this value.  'modifiedCompare' may also be sent to control search behavior.
         *
         * **Since**: 3700.4.0
         */
        public static GetContentChildrenOption modified(Instant modified) {
            return parameter("modified", modified, new GetContentChildrenOption());
        }

        /*
         * Used alongside the 'modified' search parameter.  Supported values:
         *
         * - lessThan
         * - greaterOrEqual
         *
         * Defaults to greaterOrEqual if not specified.
         *
         * **Since**: 3700.4.0
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | lessThan |  |
         * | greaterOrEqual |  |
         *
         */
        public static GetContentChildrenOption modifiedCompare(String modifiedCompare) {
            return parameter("modifiedCompare", modifiedCompare, new GetContentChildrenOption());
        }

        /*
         * Search contents by whether they are reviewable or not.
         *
         * **Since**: 3700.15.0
         */
        public static GetContentChildrenOption reviewable(boolean reviewable) {
            return parameter("reviewable", reviewable, new GetContentChildrenOption());
        }
    }

    /*
     * Create Child
     *
     * Create a new child content item beneath an existing content item.  This is only valid for content items that are allowed to have children (e.g. Folders). Entitlement "course.content.CREATE" required to create Course Content.
     *
     * **Since**: 3000.1.0
     */
    public static RestCall<Content> createChild(String courseId, String contentId, CreateChildBody input) {
        return RestCallBuilder
            .start(new TypeToken<Content>() {})
            .post()
            .url("/learn/api/public/v1/courses/{courseId}/contents/{contentId}/children")
            .pathParam("courseId", courseId)
            .pathParam("contentId", contentId)
            .body(input)
            .build();
    }

    public static class CreateChildBody {
        /*
         * The ID of the content's parent.  Note that top-level contents do not have parents. The 'parentId' field is a writable field as of the Bb Learn 3200.6.0 release.  Specifying a new value in PATCH requests allows the Content object to be moved from one parent to another.
         */
        private String parentId;

        /*
         * The title or name of this content. Typically shown as the main text to click in the course outline when accessing the content.
         */
        private String title;

        /*
         * The body text associated with this content. This field supports BbML; see <a target='_blank' href='https://docs.blackboard.com/learn/REST/Blackboard%20Markup%20Language%20-%20BbML.html'>here</a> for more information.
         */
        private String body;

        /*
         * The short description of this content.
         *
         * This field is not used in Classic courses.  For Ultra courses this is used to show information directly on the course outline.
         */
        private String description;

        /*
         * The position of this content within its parent folder. Position values are zero-based (the first element has a position value of zero, not one). Default position is last in the list of child contents under the parent.
         */
        private int position;

        /*
         * Indicates whether the content is going to open in a new window.
         *
         * **Since**: 3800.10.0
         */
        private boolean launchInNewWindow;

        /*
         * Indicates whether Review Status is enabled for this content. Content items with review status enabled can be marked as reviewed by students. This can be used to track performance and in Adaptive Release rules to control the release of other content. Reviewable field is currently being used only in Classic courses.
         *
         * **Since**: 3700.15.0
         */
        private boolean reviewable;

        /*
         * Settings controlling availability of the content to students.
         */
        private Availability availability;

        /*
         * Extended settings specific to this content item's content handler.
         */
        private ContentHandler contentHandler;

        public static CreateChildBody create() {
            return new CreateChildBody();
        }

        public static class Availability {
            /*
             * Whether the content is currently available to students.  Instructors can always access the content.  If set to 'PartiallyVisible', the title will be available to students but the body will not.  Defaults to Yes.
             *
             *
             * | Type      | Description
             *  | --------- | --------- |
             * | Yes |  |
             * | No |  |
             * | PartiallyVisible |  |
             *
             */
            private Available available;

            /*
             * Whether this content is available to users with the 'guest' role. Defaults to true.
             */
            private boolean allowGuests;

            /*
             * Settings controlling adaptive release of the content to students.
             */
            private AdaptiveRelease adaptiveRelease;

            public static Availability create() {
                return new Availability();
            }

            public static class AdaptiveRelease {
                /*
                 * The date when this content will become available to students.
                 */
                private Instant start;

                /*
                 * The date when this content will no longer be available to students.
                 */
                private Instant end;

                public static AdaptiveRelease create() {
                    return new AdaptiveRelease();
                }

                public AdaptiveRelease setStart(Instant start) {
                    this.start = start;
                    return this;
                }

                public AdaptiveRelease setEnd(Instant end) {
                    this.end = end;
                    return this;
                }
            }

            public enum Available {
                Yes,
                No,
                PartiallyVisible
            }

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }

            public Availability setAllowGuests(boolean allowGuests) {
                this.allowGuests = allowGuests;
                return this;
            }

            public Availability setAdaptiveRelease(AdaptiveRelease adaptiveRelease) {
                this.adaptiveRelease = adaptiveRelease;
                return this;
            }
        }

        public CreateChildBody setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        public CreateChildBody setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateChildBody setBody(String body) {
            this.body = body;
            return this;
        }

        public CreateChildBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateChildBody setPosition(int position) {
            this.position = position;
            return this;
        }

        public CreateChildBody setLaunchInNewWindow(boolean launchInNewWindow) {
            this.launchInNewWindow = launchInNewWindow;
            return this;
        }

        public CreateChildBody setReviewable(boolean reviewable) {
            this.reviewable = reviewable;
            return this;
        }

        public CreateChildBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreateChildBody setContentHandler(ContentHandler contentHandler) {
            this.contentHandler = contentHandler;
            return this;
        }
    }
}
