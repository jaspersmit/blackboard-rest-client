package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import org.jbsmit.blackboardRestClient.model.LTIDomainConfig;
import org.jbsmit.blackboardRestClient.model.LTIPlacement;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallOption;

public class LtiApi {
    /*
     * Get Placements
     *
     * Returns a list of LTI placements
     *
     * Supports the standard paging and sorting query parameters, with a maximum page size of 1000.
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<List<LTIPlacement>> getPlacements(GetPlacementsOption... options) {
        return RestCallBuilder
            .start(new TypeToken<List<LTIPlacement>>() {})
            .get()
            .url("/learn/api/public/v1/lti/placements")
            .options(options)
            .build();
    }

    public static class GetPlacementsOption extends RestCallOption {
        /*
         * Search for placements with handle properties that contain this value.
         *
         * **Since**: 3200.12.0
         */
        public static GetPlacementsOption handle(String handle) {
            return parameter("handle", handle, new GetPlacementsOption());
        }

        /*
         * Search for placements with name properties that contain this value.
         *
         * **Since**: 3200.12.0
         */
        public static GetPlacementsOption name(String name) {
            return parameter("name", name, new GetPlacementsOption());
        }

        /*
         * Search for placements with type properties that contain this value.
         *
         * **Since**: 3200.12.0
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
        public static GetPlacementsOption type(String type) {
            return parameter("type", type, new GetPlacementsOption());
        }

        /*
         * Search for placements with author ID properties that contain this value.
         *
         * **Since**: 3200.12.0
         *
         * **Deprecated**: since 3900.0.0; Field was never used and has been removed
         */
        public static GetPlacementsOption authorId(String authorId) {
            return parameter("authorId", authorId, new GetPlacementsOption());
        }

        /*
         * Search for LTI placements that are available for this course. Note this only applies to Application, ContentHandler, and ContentItemMessage types currently
         *
         * **Since**: 3900.0.0
         */
        public static GetPlacementsOption courseId(String courseId) {
            return parameter("courseId", courseId, new GetPlacementsOption());
        }

        /*
         * Properties to sort by. This is a comma-delimited list of JSON properties, with an optional "(desc)" suffix to request a descending sort for that property. e.g. "name.family(desc),created"
         *
         * **Since**: 3100.0.0
         */
        public static GetPlacementsOption sort(String sort) {
            return parameter("sort", sort, new GetPlacementsOption());
        }
    }

    /*
     * Create Placement
     *
     * Creates an LTI placement
     *
     * The 'system.administration.VIEW' entitlement is required to create placements
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<LTIPlacement> createPlacement(CreatePlacementBody input) {
        return RestCallBuilder
            .start(new TypeToken<LTIPlacement>() {})
            .post()
            .url("/learn/api/public/v1/lti/placements")
            .body(input)
            .build();
    }

    public static class CreatePlacementBody {
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

        private String key;

        private String secret;

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
         * Custom launch parameters for the tool.
         */
        private Map<String, String> customParameters;

        public static CreatePlacementBody create() {
            return new CreatePlacementBody();
        }

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

        public CreatePlacementBody setName(String name) {
            this.name = name;
            return this;
        }

        public CreatePlacementBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreatePlacementBody setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public CreatePlacementBody setHandle(String handle) {
            this.handle = handle;
            return this;
        }

        public CreatePlacementBody setType(Type type) {
            this.type = type;
            return this;
        }

        public CreatePlacementBody setUrl(String url) {
            this.url = url;
            return this;
        }

        public CreatePlacementBody setKey(String key) {
            this.key = key;
            return this;
        }

        public CreatePlacementBody setSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public CreatePlacementBody setAuthorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        public CreatePlacementBody setInstructorCreated(boolean instructorCreated) {
            this.instructorCreated = instructorCreated;
            return this;
        }

        public CreatePlacementBody setAllowStudents(boolean allowStudents) {
            this.allowStudents = allowStudents;
            return this;
        }

        public CreatePlacementBody setAllowGrading(boolean allowGrading) {
            this.allowGrading = allowGrading;
            return this;
        }

        public CreatePlacementBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public CreatePlacementBody setLaunchInNewWindow(boolean launchInNewWindow) {
            this.launchInNewWindow = launchInNewWindow;
            return this;
        }

        public CreatePlacementBody setCustomParameters(Map<String, String> customParameters) {
            this.customParameters = customParameters;
            return this;
        }
    }

    /*
     * Get Placement
     *
     * Returns the LTI placement with the specified Id
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<LTIPlacement> getPlacement(String placementId) {
        return RestCallBuilder
            .start(new TypeToken<LTIPlacement>() {})
            .get()
            .url("/learn/api/public/v1/lti/placements/{placementId}")
            .pathParam("placementId", placementId)
            .build();
    }

    /*
     * Delete Placement
     *
     * Deletes an LTI placement with the specified Id
     *
     * The 'system.administration.VIEW' entitlement is required to delete placements
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<Void> deletePlacement(String placementId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/api/public/v1/lti/placements/{placementId}")
            .pathParam("placementId", placementId)
            .build();
    }

    /*
     * Update Placement
     *
     * Updates an LTI placement with the given Id
     *
     * The 'system.administration.VIEW' entitlement is required to update placements
     *
     * **Since**: 3300.0.0
     */
    public static RestCall<LTIPlacement> updatePlacement(String placementId, UpdatePlacementBody input) {
        return RestCallBuilder
            .start(new TypeToken<LTIPlacement>() {})
            .patch()
            .url("/learn/api/public/v1/lti/placements/{placementId}")
            .pathParam("placementId", placementId)
            .body(input)
            .build();
    }

    public static class UpdatePlacementBody {
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
         * The URL of the tool provider. Not required to be unique, must be a complete and valid URL. Maximum length is 1024 characters, BAD_REQUEST error with message is returned if greater than 1024 characters or incomplete URL.
         */
        private String url;

        private String key;

        private String secret;

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
         * Custom launch parameters for the tool.
         */
        private Map<String, String> customParameters;

        public static UpdatePlacementBody create() {
            return new UpdatePlacementBody();
        }

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

            public Availability setAvailable(Available available) {
                this.available = available;
                return this;
            }
        }

        public UpdatePlacementBody setName(String name) {
            this.name = name;
            return this;
        }

        public UpdatePlacementBody setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdatePlacementBody setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public UpdatePlacementBody setUrl(String url) {
            this.url = url;
            return this;
        }

        public UpdatePlacementBody setKey(String key) {
            this.key = key;
            return this;
        }

        public UpdatePlacementBody setSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public UpdatePlacementBody setAuthorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        public UpdatePlacementBody setInstructorCreated(boolean instructorCreated) {
            this.instructorCreated = instructorCreated;
            return this;
        }

        public UpdatePlacementBody setAllowStudents(boolean allowStudents) {
            this.allowStudents = allowStudents;
            return this;
        }

        public UpdatePlacementBody setAllowGrading(boolean allowGrading) {
            this.allowGrading = allowGrading;
            return this;
        }

        public UpdatePlacementBody setAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public UpdatePlacementBody setLaunchInNewWindow(boolean launchInNewWindow) {
            this.launchInNewWindow = launchInNewWindow;
            return this;
        }

        public UpdatePlacementBody setCustomParameters(Map<String, String> customParameters) {
            this.customParameters = customParameters;
            return this;
        }
    }

    /*
     * Get Domain Configs
     *
     * This endpoint returns the list of LTI domain configs
     *
     * The 'system.administration.VIEW' entitlement is needed to list domains.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<List<LTIDomainConfig>> getDomainConfigs() {
        return RestCallBuilder
            .start(new TypeToken<List<LTIDomainConfig>>() {})
            .get()
            .url("/learn/apipublic/v1/lti/domains")
            .build();
    }

    /*
     * Create Domain Config
     *
     * Creates an LTI Domain Config.
     *
     * The 'system.administration.VIEW' entitlement is needed to create a domain.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<LTIDomainConfig> createDomainConfig(CreateDomainConfigBody input) {
        return RestCallBuilder
            .start(new TypeToken<LTIDomainConfig>() {})
            .post()
            .url("/learn/apipublic/v1/lti/domains")
            .body(input)
            .build();
    }

    public static class CreateDomainConfigBody {
        /*
         * The primary domain name associated with this configuration.
         */
        private String primaryDomain;

        /*
         * The client id associated with this configuration. Only applicable for LTI versions 1.3+, excluding 2.0
         *
         * **Since**: 3600.0.0
         */
        private String clientId;

        private String key;

        private String secret;

        /*
         * Enum that indicates if the set of domains associated with this config can or cannot be linked to.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Approved |  |
         * | Excluded |  |
         * | NeedsApproval |   **Since**: 3300.9.0 |
         *
         */
        private Status status;

        /*
         * Enum indicating when user data can be sent to the LTI tool provider.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Never |  |
         * | Sslonly |  |
         * | Always |   **Since**: 3300.9.0 |
         *
         */
        private SendUserDataType sendUserDataType;

        /*
         * Whether the user's role can be sent to the LTI tool provider.
         */
        private boolean sendRole;

        /*
         * Whether the user's name can be sent to the LTI tool provider.
         */
        private boolean sendName;

        /*
         * Whether the user's email address can be sent to the LTI tool provider.
         */
        private boolean sendEmail;

        /*
         * Whether a splash screen is shown before launching the LTI link.
         *
         * Cannot be set to true if allowMembershipService is true.
         */
        private boolean useSplashScreen;

        /*
         * Whether the Tool is allowed to call the LTI Names and Roles service and get the course memberships.
         */
        private boolean allowMembershipService;

        /*
         * Whether the Tool is allowed to call the LTI Assignment and Grades service and manage line items and grades.
         *
         * **Since**: 3600.0.0
         */
        private boolean allowGradesService;

        /*
         * The public key of the tool, if specified. It is optional and can be null
         *
         * **Since**: 3800.17.0
         */
        private String publicKey;

        /*
         * The JWKS URL of the tool, if specified. It is optional and can be null
         *
         * **Since**: 3800.17.0
         */
        private String jwksUrl;

        /*
         * The custom parameters for the given domain.
         */
        private Map<String, String> customParameters;

        public static CreateDomainConfigBody create() {
            return new CreateDomainConfigBody();
        }

        public enum Status {
            Approved,
            Excluded,
            NeedsApproval
        }

        public enum SendUserDataType {
            Never,
            Sslonly,
            Always
        }

        public CreateDomainConfigBody setPrimaryDomain(String primaryDomain) {
            this.primaryDomain = primaryDomain;
            return this;
        }

        public CreateDomainConfigBody setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public CreateDomainConfigBody setKey(String key) {
            this.key = key;
            return this;
        }

        public CreateDomainConfigBody setSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public CreateDomainConfigBody setStatus(Status status) {
            this.status = status;
            return this;
        }

        public CreateDomainConfigBody setSendUserDataType(SendUserDataType sendUserDataType) {
            this.sendUserDataType = sendUserDataType;
            return this;
        }

        public CreateDomainConfigBody setSendRole(boolean sendRole) {
            this.sendRole = sendRole;
            return this;
        }

        public CreateDomainConfigBody setSendName(boolean sendName) {
            this.sendName = sendName;
            return this;
        }

        public CreateDomainConfigBody setSendEmail(boolean sendEmail) {
            this.sendEmail = sendEmail;
            return this;
        }

        public CreateDomainConfigBody setUseSplashScreen(boolean useSplashScreen) {
            this.useSplashScreen = useSplashScreen;
            return this;
        }

        public CreateDomainConfigBody setAllowMembershipService(boolean allowMembershipService) {
            this.allowMembershipService = allowMembershipService;
            return this;
        }

        public CreateDomainConfigBody setAllowGradesService(boolean allowGradesService) {
            this.allowGradesService = allowGradesService;
            return this;
        }

        public CreateDomainConfigBody setPublicKey(String publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public CreateDomainConfigBody setJwksUrl(String jwksUrl) {
            this.jwksUrl = jwksUrl;
            return this;
        }

        public CreateDomainConfigBody setCustomParameters(Map<String, String> customParameters) {
            this.customParameters = customParameters;
            return this;
        }
    }

    /*
     * Get Domain Config
     *
     * This endpoint returns the LTI domain config with the specified Id
     *
     * The 'system.administration.VIEW' entitlement is needed to get a domain.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<LTIDomainConfig> getDomainConfig(String domainId) {
        return RestCallBuilder
            .start(new TypeToken<LTIDomainConfig>() {})
            .get()
            .url("/learn/apipublic/v1/lti/domains/{domainId}")
            .pathParam("domainId", domainId)
            .build();
    }

    /*
     * Delete Domain Config
     *
     * Deletes an LTI Domain Config.
     *
     * The 'system.administration.VIEW' entitlement is needed to delete a domain.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<Void> deleteDomainConfig(String domainId) {
        return RestCallBuilder
            .start(new TypeToken<Void>() {})
            .delete()
            .url("/learn/apipublic/v1/lti/domains/{domainId}")
            .pathParam("domainId", domainId)
            .build();
    }

    /*
     * Update Domain Config
     *
     * Updates an LTI Domain Config.
     *
     * The 'system.administration.VIEW' entitlement is needed to update a domain.
     *
     * **Since**: 3300.9.0
     */
    public static RestCall<LTIDomainConfig> updateDomainConfig(String domainId, UpdateDomainConfigBody input) {
        return RestCallBuilder
            .start(new TypeToken<LTIDomainConfig>() {})
            .patch()
            .url("/learn/apipublic/v1/lti/domains/{domainId}")
            .pathParam("domainId", domainId)
            .body(input)
            .build();
    }

    public static class UpdateDomainConfigBody {
        /*
         * The primary domain name associated with this configuration.
         */
        private String primaryDomain;

        /*
         * The client id associated with this configuration. Only applicable for LTI versions 1.3+, excluding 2.0
         *
         * **Since**: 3600.0.0
         */
        private String clientId;

        private String key;

        private String secret;

        /*
         * Enum that indicates if the set of domains associated with this config can or cannot be linked to.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Approved |  |
         * | Excluded |  |
         * | NeedsApproval |   **Since**: 3300.9.0 |
         *
         */
        private Status status;

        /*
         * Enum indicating when user data can be sent to the LTI tool provider.
         *
         *
         * | Type      | Description
         *  | --------- | --------- |
         * | Never |  |
         * | Sslonly |  |
         * | Always |   **Since**: 3300.9.0 |
         *
         */
        private SendUserDataType sendUserDataType;

        /*
         * Whether the user's role can be sent to the LTI tool provider.
         */
        private boolean sendRole;

        /*
         * Whether the user's name can be sent to the LTI tool provider.
         */
        private boolean sendName;

        /*
         * Whether the user's email address can be sent to the LTI tool provider.
         */
        private boolean sendEmail;

        /*
         * Whether a splash screen is shown before launching the LTI link.
         *
         * Cannot be set to true if allowMembershipService is true.
         */
        private boolean useSplashScreen;

        /*
         * Whether the Tool is allowed to call the LTI Names and Roles service and get the course memberships.
         */
        private boolean allowMembershipService;

        /*
         * Whether the Tool is allowed to call the LTI Assignment and Grades service and manage line items and grades.
         *
         * **Since**: 3600.0.0
         */
        private boolean allowGradesService;

        /*
         * The public key of the tool, if specified. It is optional and can be null
         *
         * **Since**: 3800.17.0
         */
        private String publicKey;

        /*
         * The JWKS URL of the tool, if specified. It is optional and can be null
         *
         * **Since**: 3800.17.0
         */
        private String jwksUrl;

        /*
         * The custom parameters for the given domain.
         */
        private Map<String, String> customParameters;

        public static UpdateDomainConfigBody create() {
            return new UpdateDomainConfigBody();
        }

        public enum Status {
            Approved,
            Excluded,
            NeedsApproval
        }

        public enum SendUserDataType {
            Never,
            Sslonly,
            Always
        }

        public UpdateDomainConfigBody setPrimaryDomain(String primaryDomain) {
            this.primaryDomain = primaryDomain;
            return this;
        }

        public UpdateDomainConfigBody setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public UpdateDomainConfigBody setKey(String key) {
            this.key = key;
            return this;
        }

        public UpdateDomainConfigBody setSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public UpdateDomainConfigBody setStatus(Status status) {
            this.status = status;
            return this;
        }

        public UpdateDomainConfigBody setSendUserDataType(SendUserDataType sendUserDataType) {
            this.sendUserDataType = sendUserDataType;
            return this;
        }

        public UpdateDomainConfigBody setSendRole(boolean sendRole) {
            this.sendRole = sendRole;
            return this;
        }

        public UpdateDomainConfigBody setSendName(boolean sendName) {
            this.sendName = sendName;
            return this;
        }

        public UpdateDomainConfigBody setSendEmail(boolean sendEmail) {
            this.sendEmail = sendEmail;
            return this;
        }

        public UpdateDomainConfigBody setUseSplashScreen(boolean useSplashScreen) {
            this.useSplashScreen = useSplashScreen;
            return this;
        }

        public UpdateDomainConfigBody setAllowMembershipService(boolean allowMembershipService) {
            this.allowMembershipService = allowMembershipService;
            return this;
        }

        public UpdateDomainConfigBody setAllowGradesService(boolean allowGradesService) {
            this.allowGradesService = allowGradesService;
            return this;
        }

        public UpdateDomainConfigBody setPublicKey(String publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public UpdateDomainConfigBody setJwksUrl(String jwksUrl) {
            this.jwksUrl = jwksUrl;
            return this;
        }

        public UpdateDomainConfigBody setCustomParameters(Map<String, String> customParameters) {
            this.customParameters = customParameters;
            return this;
        }
    }
}
