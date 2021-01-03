package org.jbsmit.blackboardRestClient.model;


public class AggregateReviewStatus {
    /*
     * The ID of the course.
     *
     * **Since**: 3700.15.0
     */
    private String courseId;

    /*
     * The ID of the User.
     *
     * **Since**: 3700.15.0
     */
    private String userId;

    /*
     * The number of content items the user has reviewed.
     *
     * **Since**: 3700.15.0
     */
    private int reviewedCount;

    /*
     * The number of content items that can be reviewed in the given course.
     *
     * **Since**: 3700.15.0
     */
    private int reviewableCount;


    public String getCourseId() {
        return courseId;
    }

    public AggregateReviewStatus setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AggregateReviewStatus setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getReviewedCount() {
        return reviewedCount;
    }

    public AggregateReviewStatus setReviewedCount(int reviewedCount) {
        this.reviewedCount = reviewedCount;
        return this;
    }

    public int getReviewableCount() {
        return reviewableCount;
    }

    public AggregateReviewStatus setReviewableCount(int reviewableCount) {
        this.reviewableCount = reviewableCount;
        return this;
    }
}

