package org.jbsmit.blackboardRestClient.model;

import java.util.Map;

public class LTIPlacement {
    /*
     * The ID associated with this placement.
     */
    private String id;

    /*
     * The name of the placement. Not required to be unique. Maximum length of 50 characters, BAD_REQUEST error with message is returned if greater than 50 characters.
     */
    private String name;

    /*
     * The description of the placement. Not required to be unique. Maximum length is 1000 characters, BAD_REQUEST error with message is returned if greater than 1000 characters.
     */
    private String description;

    /*
     * The URL of the icon for this placement, if any. Not required to be unique, must be a complete and valid URL. Maximum length is 255 characters, BAD_REQUEST error with message is returned if greater than 255 characters or incomplete URL.
     */
    private String iconUrl;

    /*
     * The handle that uniquely identifies this placement. Required to be unique. Maximum length is 32 characters, BAD_REQUEST error with message is returned if greater than 32 characters.
     */
    private String handle;

    /*
     * The type of placement.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Application | Application or Student Tool Placement |
     * | ContentHandler | Content Type placement |
     * | ContentItemMessage | Content-item Message placement (see IMSGlobal spec)  **Since**: 3300.5.0 |
     * | System | System-level Tools |
     * | Administrator | Administrator-level Tools  **Since**: 3400.1.0 |
     * | UltraUI | Ultra-UI Extensions  **Since**: 3700.6.0 |
     * | BaseNavigation | Base Navigation |
     * | CourseNavigation | Course Navigation |
     *
     */
    private Type type;

    /*
     * The URL of the tool provider. Not required to be unique, must be a complete and valid URL. Maximum length is 1024 characters, BAD_REQUEST error with message is returned if greater than 1024 characters or incomplete URL.
     */
    private String url;

    /*
     * Id of the creator of the placement
     *
     * **Deprecated**: since 3900.0 not used
     */
    private String authorId;

    /*
     * Whether an instructor created the placement or not (otherwise admin)
     *
     * **Deprecated**: since 3900.0 not used
     */
    private boolean instructorCreated;

    /*
     * Whether the course tool is visible by students, or only to non-students (e.g. instructors). Defaults to true, allowing students to see the tool.
     */
    private boolean allowStudents;

    /*
     * Whether this placement can accept grades from the tool provider and a grade column can be created for it. This only applies to Enum[Type]#`ContentHandler` types. All others don't support grading and will be set to false.
     */
    private boolean allowGrading;

    /*
     * Settings controlling availability of the placement.
     */
    private Availability availability;

    /*
     * Whether this placement link should be opened in a new window or not.
     */
    private boolean launchInNewWindow;

    /*
     * Generated launch link
     */
    private String launchLink;

    /*
     * Custom launch parameters for the tool.
     */
    private Map<String, String> customParameters;


    public static class Availability {
        /*
         * Whether the placement is available within the system.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Yes |  |
         * | No |  |
         *
         */
        private Available available;

        public static Availability create() {
            return new Availability();
        }

        public enum Available {
            Yes,
            No
        }

        public Available getAvailable() {
            return available;
        }

        public Availability setAvailable(Available available) {
            this.available = available;
            return this;
        }
    }

    public enum Type {
        Application,
        ContentHandler,
        ContentItemMessage,
        System,
        Administrator,
        UltraUI,
        BaseNavigation,
        CourseNavigation
    }

    public String getId() {
        return id;
    }

    public LTIPlacement setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LTIPlacement setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LTIPlacement setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public LTIPlacement setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getHandle() {
        return handle;
    }

    public LTIPlacement setHandle(String handle) {
        this.handle = handle;
        return this;
    }

    public Type getType() {
        return type;
    }

    public LTIPlacement setType(Type type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LTIPlacement setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public LTIPlacement setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public boolean getInstructorCreated() {
        return instructorCreated;
    }

    public LTIPlacement setInstructorCreated(boolean instructorCreated) {
        this.instructorCreated = instructorCreated;
        return this;
    }

    public boolean getAllowStudents() {
        return allowStudents;
    }

    public LTIPlacement setAllowStudents(boolean allowStudents) {
        this.allowStudents = allowStudents;
        return this;
    }

    public boolean getAllowGrading() {
        return allowGrading;
    }

    public LTIPlacement setAllowGrading(boolean allowGrading) {
        this.allowGrading = allowGrading;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public LTIPlacement setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public boolean getLaunchInNewWindow() {
        return launchInNewWindow;
    }

    public LTIPlacement setLaunchInNewWindow(boolean launchInNewWindow) {
        this.launchInNewWindow = launchInNewWindow;
        return this;
    }

    public String getLaunchLink() {
        return launchLink;
    }

    public LTIPlacement setLaunchLink(String launchLink) {
        this.launchLink = launchLink;
        return this;
    }

    public Map<String, String> getCustomParameters() {
        return customParameters;
    }

    public LTIPlacement setCustomParameters(Map<String, String> customParameters) {
        this.customParameters = customParameters;
        return this;
    }
}

