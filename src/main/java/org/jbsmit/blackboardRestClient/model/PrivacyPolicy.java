package org.jbsmit.blackboardRestClient.model;


public class PrivacyPolicy {
    /*
     * Set the URL of the Blackboard privacy policy
     */
    private String blackboard;

    /*
     * Set the institution's privacy policy URL
     */
    private String institution;


    public String getBlackboard() {
        return blackboard;
    }

    public PrivacyPolicy setBlackboard(String blackboard) {
        this.blackboard = blackboard;
        return this;
    }

    public String getInstitution() {
        return institution;
    }

    public PrivacyPolicy setInstitution(String institution) {
        this.institution = institution;
        return this;
    }
}

