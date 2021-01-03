package org.jbsmit.blackboardRestClient.model;

import java.time.Instant;

public class ReviewStatus {
    /*
     * The ID of the content.
     *
     * **Since**: 3700.16.0
     */
    private String contentId;

    /*
     * The ID of the user.
     *
     * **Since**: 3700.16.0
     */
    private String userId;

    /*
     * The current status of the content's 'reviewed' attribute.
     *
     * **Since**: 3700.16.0
     */
    private boolean reviewed;

    /*
     * The date that the user marked the content as reviewed
     *
     * **Since**: 3700.16.0
     */
    private Instant reviewDate;


    public String getContentId() {
        return contentId;
    }

    public ReviewStatus setContentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ReviewStatus setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public boolean getReviewed() {
        return reviewed;
    }

    public ReviewStatus setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
        return this;
    }

    public Instant getReviewDate() {
        return reviewDate;
    }

    public ReviewStatus setReviewDate(Instant reviewDate) {
        this.reviewDate = reviewDate;
        return this;
    }
}

