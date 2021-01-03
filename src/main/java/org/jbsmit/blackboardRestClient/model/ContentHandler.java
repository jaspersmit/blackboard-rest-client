package org.jbsmit.blackboardRestClient.model;


public class ContentHandler {
    /*
     * The content handler's ID.
     *
     * Publicly supported handlers:
     *
     *  | ID                                 | Documentation                   | Since     |
     *  |------------------------------------|---------------------------------|-----------|
     *  | resource/x-bb-document             | ContentItemTOPubV1              |  3000.1.0 |
     *  | resource/x-bb-externallink         | ExternalLinkTOPubV1             |  3000.1.0 |
     *  | resource/x-bb-folder               | ContentFolderTOPubV1            |  3000.1.0 |
     *  | resource/x-bb-courselink           | CourseLinkTOPubV1               |  3100.5.0 |
     *  | resource/x-bb-forumlink            | DiscussionLinkTOPubV1           |  3100.6.0 |
     *  | resource/x-bb-blti-link            | BasicLTITOPubV1                 |  3200.6.0 |
     *  | resource/x-bb-file                 | ContentFileTOPubV1              |  3200.6.0 |
     *  | resource/x-bb-asmt-test-link       | TestLinkTOPubV1                 |  3300.5.0 |
     *  | resource/x-bb-assignment           | AssignmentTOPubV1               |  3400.9.0 |
     *  | resource/x-bb-blti-bltiplacement-* | BasicLTIPlacementContentTOPubV1 |  3600.0.0 |
     *
     *
     * For handlers that are not publicly supported yet, their ID will be shown here, and updates to common content attributes are allowed, but extended handler-specific attributes will not be visible.
     */
    private String id;


    public String getId() {
        return id;
    }

    public ContentHandler setId(String id) {
        this.id = id;
        return this;
    }
}

