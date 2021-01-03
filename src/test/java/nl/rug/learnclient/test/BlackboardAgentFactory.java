package nl.rug.learnclient.test;

import org.jbsmit.blackboardRestClient.BlackboardAgent;
import org.jbsmit.blackboardRestClient.agentsupport.BlackboardConfig;

public class BlackboardAgentFactory {
    public static BlackboardAgent createAgent() {
        return new BlackboardAgent(
                new BlackboardConfig(
                        "https://....blackboard.com",
                            "*** SECRET TOKEN ***"));
    }
}
