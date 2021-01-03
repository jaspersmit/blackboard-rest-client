package org.jbsmit.blackboardRestClient.api;

import nl.rug.learnclient.test.TestContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoursesApiTest {
    @Test
    public void testCoursesApi() {
        try(var context = new TestContext()) {
            var agent = context.getAgent();
            var course = context.createTestCourse();

            var newName = "This is a new title";
            var input = new Deprecated_CoursesApi.UpdateCourseV2Body().setName(newName);
            course = agent.run(Deprecated_CoursesApi.updateCourseV2(course.getId(), input));
            assertEquals(newName, course.getName());
        }
    }
}