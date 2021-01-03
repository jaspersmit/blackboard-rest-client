package org.jbsmit.blackboardRestClient.model;

import java.util.Map;

public class LTIDomainConfig {
    /*
     * The ID associated with this domainConfig.
     */
    private String id;

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
     * If true, a new link to this LTI domain must supply its own key and secret. If false, the key and secret for this domain are already configured system-wide. This is a read-only property that is determined by the presence of a key and secret.
     */
    private boolean perLinkCredentials;

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
     * Whether this domain configuration is editable by system admins. The "internal" apps created by Blackboard are non-editable. They are created or updated automatically or via Dev Portal, and they are locked to system admins or anyone with public REST access to change them.
     *
     * **Since**: 3800.17.0
     */
    private boolean allowEdit;

    /*
     * The custom parameters for the given domain.
     */
    private Map<String, String> customParameters;


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

    public String getId() {
        return id;
    }

    public LTIDomainConfig setId(String id) {
        this.id = id;
        return this;
    }

    public String getPrimaryDomain() {
        return primaryDomain;
    }

    public LTIDomainConfig setPrimaryDomain(String primaryDomain) {
        this.primaryDomain = primaryDomain;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public LTIDomainConfig setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public LTIDomainConfig setStatus(Status status) {
        this.status = status;
        return this;
    }

    public boolean getPerLinkCredentials() {
        return perLinkCredentials;
    }

    public LTIDomainConfig setPerLinkCredentials(boolean perLinkCredentials) {
        this.perLinkCredentials = perLinkCredentials;
        return this;
    }

    public SendUserDataType getSendUserDataType() {
        return sendUserDataType;
    }

    public LTIDomainConfig setSendUserDataType(SendUserDataType sendUserDataType) {
        this.sendUserDataType = sendUserDataType;
        return this;
    }

    public boolean getSendRole() {
        return sendRole;
    }

    public LTIDomainConfig setSendRole(boolean sendRole) {
        this.sendRole = sendRole;
        return this;
    }

    public boolean getSendName() {
        return sendName;
    }

    public LTIDomainConfig setSendName(boolean sendName) {
        this.sendName = sendName;
        return this;
    }

    public boolean getSendEmail() {
        return sendEmail;
    }

    public LTIDomainConfig setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
        return this;
    }

    public boolean getUseSplashScreen() {
        return useSplashScreen;
    }

    public LTIDomainConfig setUseSplashScreen(boolean useSplashScreen) {
        this.useSplashScreen = useSplashScreen;
        return this;
    }

    public boolean getAllowMembershipService() {
        return allowMembershipService;
    }

    public LTIDomainConfig setAllowMembershipService(boolean allowMembershipService) {
        this.allowMembershipService = allowMembershipService;
        return this;
    }

    public boolean getAllowGradesService() {
        return allowGradesService;
    }

    public LTIDomainConfig setAllowGradesService(boolean allowGradesService) {
        this.allowGradesService = allowGradesService;
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public LTIDomainConfig setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public String getJwksUrl() {
        return jwksUrl;
    }

    public LTIDomainConfig setJwksUrl(String jwksUrl) {
        this.jwksUrl = jwksUrl;
        return this;
    }

    public boolean getAllowEdit() {
        return allowEdit;
    }

    public LTIDomainConfig setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
        return this;
    }

    public Map<String, String> getCustomParameters() {
        return customParameters;
    }

    public LTIDomainConfig setCustomParameters(Map<String, String> customParameters) {
        this.customParameters = customParameters;
        return this;
    }
}

