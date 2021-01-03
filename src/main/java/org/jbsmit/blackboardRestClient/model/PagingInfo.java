package org.jbsmit.blackboardRestClient.model;


public class PagingInfo {
    /*
     * The URL to use to navigate to the next page of results.  This field may be omitted when there is no additional data available.
     */
    private String nextPage;


    public String getNextPage() {
        return nextPage;
    }

    public PagingInfo setNextPage(String nextPage) {
        this.nextPage = nextPage;
        return this;
    }
}

