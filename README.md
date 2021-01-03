# Blackboard REST API Client

A Blackboard REST API Client for Java

See for examples the directory `src/test`

## Create a user 
```java
class CreateUserExample {
    void createUser() {
        var agent = new BlackboardAgent(
                new BlackboardConfig(
                        "https://....blackboard.com",
                        "*** SECRET TOKEN ***"));
        var name = UsersApi.CreateUserBody.Name.create()
                .setGiven("REST Test")
                .setFamily("User");

        var user = agent.run(
                UsersApi.createUser(UsersApi.CreateUserBody.create()
                        .setUserName(username)
                        .setName(name)
                        .setPassword(UUID.randomUUID().toString())));
    }
}
```

## Create a menu item with a content item
```java
class CreateCourseExample {
    void createCourse() {
        var course = getCourse();
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
    }
}

```

## REST API Documentation
Documentation can be found at https://developer.blackboard.com/portal/displayApi

## Getting a secret key
* Register your application at https://developer.blackboard.com
* Add your application to `REST API Integrations` in the System Admin panel of your blackboard instance