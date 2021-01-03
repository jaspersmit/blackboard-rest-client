package org.jbsmit.blackboardRestClient.api;

import nl.rug.learnclient.test.TestContext;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTest {
    @Test
    public void printAllUsers() {
        try(var testContext = new TestContext()) {
            var agent = testContext.getAgent();
            var users = agent.run(UsersApi.getUsers());
            for (var user : users) {
                System.out.println(users.size() + " users found");
                System.out.println(
                        MessageFormat.format("{0} {1} {2}",
                                user.getUserName(),
                                user.getName().getGiven(),
                                user.getName().getFamily()));
            }
        }
    }

    @Test
    public void testCreateUser() {
        try(var testContext = new TestContext()) {
            var user = testContext.createTestUser();
            assertEquals("User", user.getName().getFamily());
        }
    }
}
