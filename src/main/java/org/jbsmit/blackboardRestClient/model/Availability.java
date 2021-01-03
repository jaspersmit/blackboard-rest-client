package org.jbsmit.blackboardRestClient.model;


public class Availability {
    /*
     * null
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Yes |  |
     * | No |  |
     * | Disabled |   **Since**: 3100.0.0 |
     *
     */
    private Available available;


    public enum Available {
        Yes,
        No,
        Disabled
    }

    public Available getAvailable() {
        return available;
    }

    public Availability setAvailable(Available available) {
        this.available = available;
        return this;
    }
}

