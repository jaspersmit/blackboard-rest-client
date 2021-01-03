package org.jbsmit.blackboardRestClient.agentsupport;

public class PagedResult<T> {
    T results;
    Paging paging;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
