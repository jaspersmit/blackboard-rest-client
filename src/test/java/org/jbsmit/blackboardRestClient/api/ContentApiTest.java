package org.jbsmit.blackboardRestClient.api;

import org.jbsmit.blackboardRestClient.model.ContentHandler;
import nl.rug.learnclient.test.TestContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentApiTest {
    @Test
    public void testContentApi() {
        try (var testContext = new TestContext()) {
            var agent = testContext.getAgent();
            var course = testContext.createTestCourse();
            var folder = agent.run(ContentApi
                    .createContent(
                            course.getId(),
                            ContentApi.CreateContentBody.create()
                                    .setContentHandler((new ContentHandler()).setId("resource/x-bb-folder"))
                                    .setTitle("Folder")
                                    .setBody("Folder")));

            var content = agent.run(ContentApi
                    .createChild(
                            course.getId(),
                            folder.getId(),
                            ContentApi.CreateChildBody.create()
                                    .setContentHandler((new ContentHandler())
                                            .setId("resource/x-bb-document"))
                                    .setTitle("Content Item")
                                    .setBody("Content Item Body")));

            assertEquals(content.getTitle(), "Content Item");
            assertEquals(content.getBody(), "Content Item Body");
        }
    }
}