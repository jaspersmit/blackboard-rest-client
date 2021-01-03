package org.jbsmit.blackboardRestClient.api;

import nl.rug.learnclient.test.TestContext;
import org.jbsmit.blackboardRestClient.BlackboardAgent;
import nl.smit.lib.imspackage.Content;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseGradesApiTest {
    @Test
    public void testCourseGradesApi() {
        try (var testContext = new TestContext()) {
            var agent = testContext.getAgent();
            var course = testContext.createTestCourse();
            var student = testContext.createTestUser();
            var instructor = testContext.createTestUser();

            enroll(agent, course.getId(), student.getId(), CourseMembershipsApi.CreateMembershipBody.CourseRoleId.Student);
            enroll(agent, course.getId(), instructor.getId(), CourseMembershipsApi.CreateMembershipBody.CourseRoleId.Instructor);

            var column = agent.run(
                    CourseGradesApi.createGradeColumn(
                            course.getId(),
                            CourseGradesApi.CreateGradeColumnBody.create()
                                    .setName("Column 1")
                                    .setDisplayName("Column 1")
                                    .setScore(
                                            CourseGradesApi.CreateGradeColumnBody.Score.create()
                                                    .setPossible(new BigDecimal("100")))));

            var grade = agent.run(
                    CourseGradesApi.updateColumnGrade(
                            course.getId(),
                            column.getId(),
                            student.getId(),
                            CourseGradesApi.UpdateColumnGradeBody.create()
                                    .setScore(new BigDecimal("87"))
                                    .setNotes("Example Notes")));

            assertTrue(
                    new BigDecimal("87").subtract(grade.getScore()).abs().compareTo(new BigDecimal("0.01")) < 0);
            assertEquals("Example Notes", grade.getNotes());
        }
    }

    private void enroll(
            BlackboardAgent agent,
            String courseId,
            String userId,
            CourseMembershipsApi.CreateMembershipBody.CourseRoleId courseRoleId) {
        agent.run(
                CourseMembershipsApi.createMembership(
                        courseId,
                        userId,
                        CourseMembershipsApi
                                .CreateMembershipBody.create()
                                .setCourseRoleId(courseRoleId)));
    }
}