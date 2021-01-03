package nl.rug.learnclient.test;

import org.jbsmit.blackboardRestClient.api.Deprecated_CoursesApi;
import org.jbsmit.blackboardRestClient.api.UsersApi;
import org.jbsmit.blackboardRestClient.model.CourseV2;
import org.jbsmit.blackboardRestClient.model.User;
import org.jbsmit.blackboardRestClient.BlackboardAgent;

import java.util.UUID;

public class TestContext implements AutoCloseable {
    private final BlackboardAgent agent;
    private final CleanUpStack cleanUpStack;

    public TestContext() {
        this.agent = BlackboardAgentFactory.createAgent();
        this.cleanUpStack = new CleanUpStack();
    }

    public BlackboardAgent getAgent() {
        return agent;
    }

    public CourseV2 createTestCourse() {
        var courseId = "REST_TEST_" + UUID.randomUUID();

        cleanUpStack.addCleanUp(() ->
                agent.run(
                        Deprecated_CoursesApi.deleteCourseV2(
                                "courseId:" + courseId,
                                Deprecated_CoursesApi.DeleteCourseV2Option.removeFiles(true))));
        return agent.run(
                Deprecated_CoursesApi.createCourseV2(
                        Deprecated_CoursesApi.CreateCourseV2Body.create()
                                .setCourseId(courseId)
                                .setName("REST Test API Course")));
    }

    public User createTestUser() {
        var username = "rest_test_" + UUID.randomUUID();
        cleanUpStack.addCleanUp(() -> agent.run(UsersApi.deleteUser("userName:" + username)));

        var name = UsersApi.CreateUserBody.Name.create()
                .setGiven("REST Test")
                .setFamily("User");

        return agent.run(
                UsersApi.createUser(UsersApi.CreateUserBody.create()
                        .setUserName(username)
                        .setName(name)
                        .setPassword(UUID.randomUUID().toString())));
    }

    @Override
    public void close() {
        cleanUpStack.cleanUp();
    }
}
