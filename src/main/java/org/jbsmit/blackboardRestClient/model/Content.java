package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;
import java.util.List;

public class Content {
    /*
     * The ID of the content.
     */
    private String id;

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
     * The date this content was created.
     */
    private Instant created;

    /*
     * The date this content was modified.
     *
     * **Since**: 3700.4.0
     */
    private Instant modified;

    /*
     * The position of this content within its parent folder. Position values are zero-based (the first element has a position value of zero, not one). Default position is last in the list of child contents under the parent.
     */
    private int position;

    /*
     * Indicates whether this content is allowed to have child content items.
     */
    private boolean hasChildren;

    /*
     * Indicates whether this content item has one or more gradebook columns.
     *
     * Associated gradebook columns can be accessed via /learn/api/public/v1/courses/$courseId/gradebook/columns?contentId=$contentId
     *
     * **Since**: 3000.11.0
     */
    private boolean hasGradebookColumns;

    /*
     * Indicates whether this content item has one or more associated groups.
     *
     * Associated groups can be accessed via /learn/api/public/v1/courses/$courseId/contents/$contentId/groups
     *
     * **Since**: 3100.4.0
     */
    private boolean hasAssociatedGroups;

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

    /*
     * A list of links to resources related to this content item. Supported relation types include:
     *
     * - alternate
     *
     * **Since**: 3900.0.0
     */
    private List<Link> links;


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

            public Instant getStart() {
                return start;
            }

            public AdaptiveRelease setStart(Instant start) {
                this.start = start;
                return this;
            }

            public Instant getEnd() {
                return end;
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

        public Available getAvailable() {
            return available;
        }

        public Availability setAvailable(Available available) {
            this.available = available;
            return this;
        }

        public boolean getAllowGuests() {
            return allowGuests;
        }

        public Availability setAllowGuests(boolean allowGuests) {
            this.allowGuests = allowGuests;
            return this;
        }

        public AdaptiveRelease getAdaptiveRelease() {
            return adaptiveRelease;
        }

        public Availability setAdaptiveRelease(AdaptiveRelease adaptiveRelease) {
            this.adaptiveRelease = adaptiveRelease;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public Content setId(String id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Content setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Content setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Content setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Content setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Content setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public Content setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Content setPosition(int position) {
        this.position = position;
        return this;
    }

    public boolean getHasChildren() {
        return hasChildren;
    }

    public Content setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
        return this;
    }

    public boolean getHasGradebookColumns() {
        return hasGradebookColumns;
    }

    public Content setHasGradebookColumns(boolean hasGradebookColumns) {
        this.hasGradebookColumns = hasGradebookColumns;
        return this;
    }

    public boolean getHasAssociatedGroups() {
        return hasAssociatedGroups;
    }

    public Content setHasAssociatedGroups(boolean hasAssociatedGroups) {
        this.hasAssociatedGroups = hasAssociatedGroups;
        return this;
    }

    public boolean getLaunchInNewWindow() {
        return launchInNewWindow;
    }

    public Content setLaunchInNewWindow(boolean launchInNewWindow) {
        this.launchInNewWindow = launchInNewWindow;
        return this;
    }

    public boolean getReviewable() {
        return reviewable;
    }

    public Content setReviewable(boolean reviewable) {
        this.reviewable = reviewable;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Content setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public ContentHandler getContentHandler() {
        return contentHandler;
    }

    public Content setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
        return this;
    }

    public List<Link> getLinks() {
        return links;
    }

    public Content setLinks(List<Link> links) {
        this.links = links;
        return this;
    }
}

