package org.jbsmit.blackboardRestClient.model;


public class GroupMembership {
    /*
     * The user Id associated with this GroupMembership. See [Group Membership](#group-membership--dependency)#`getUserId`
     */
    private String userId;


    public String getUserId() {
        return userId;
    }

    public GroupMembership setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}

