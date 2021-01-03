package org.jbsmit.blackboardRestClient.agentsupport;

public interface RestCallDecorator {
    void decorate(RestCall<?> restCall);
}
