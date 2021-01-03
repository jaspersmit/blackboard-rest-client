package org.jbsmit.blackboardRestClient.api;

import nl.rug.learnclient.test.TestContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseMembershipsApiTest {
    @Test
    public void testCourseMembershipsApi() {
        try (var context = new TestContext()) {
            var agent = context.getAgent();
            var course = context.createTestCourse();
            var user = context.createTestUser();

            var body = CourseMembershipsApi.CreateMembershipBody.create()
                    .setCourseRoleId(
                            CourseMembershipsApi.CreateMembershipBody.CourseRoleId.Instructor);
            agent.run(
                    CourseMembershipsApi.createMembership(
                            course.getId(),
                            user.getId(),
                            body));

            var courseMembership = agent.run(
                    CourseMembershipsApi.getMembership(
                            course.getId(),
                            user.getId(),
                            CourseMembershipsApi.GetMembershipOption.expand("user")));

            assertEquals("Rest Test", courseMembership.getUser().getName().getGiven());
        }
    }
}