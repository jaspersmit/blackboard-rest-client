package org.jbsmit.blackboardRestClient.model;


public class ContentGroup {
    /*
     * The ID of the associated content.
     */
    private String contentId;

    /*
     * The ID of the association of content and group.
     */
    private String groupId;


    public String getContentId() {
        return contentId;
    }

    public ContentGroup setContentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public ContentGroup setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }
}

