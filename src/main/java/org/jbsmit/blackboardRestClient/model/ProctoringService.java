package org.jbsmit.blackboardRestClient.model;

import java.util.Map;

public class ProctoringService {
    /*
     * The ID associated with this proctoring service.
     */
    private String id;

    /*
     * The name of the proctoring service.
     */
    private String name;

    /*
     * The handle that uniquely identifies this proctoring service.
     */
    private String handle;

    /*
     * The vendors of the proctoring service.
     *
     *
     * | Type      | Description
     *  | --------- | --------- |
     * | Respondus |  |
     * | Internal |  |
     *
     */
    private Vendor vendor;

    /*
     * The url for the vendors assessment settings LTI tool.
     */
    private String assessmentSettingsUrl;

    /*
     * Custom launch parameters for the vendors assessment settings LTI tool.
     */
    private Map<String, String> assessmentSettingsCustomParameters;

    /*
     * The download url for the vendors secure browser.
     */
    private String browserDownloadUrl;

    /*
     * Settings controlling availability of the proctoring service.
     */
    private Availability availability;


    public static class Availability {
        /*
         * Whether the proctoring service is available within the system.
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

    public enum Vendor {
        Respondus,
        Internal
    }

    public String getId() {
        return id;
    }

    public ProctoringService setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProctoringService setName(String name) {
        this.name = name;
        return this;
    }

    public String getHandle() {
        return handle;
    }

    public ProctoringService setHandle(String handle) {
        this.handle = handle;
        return this;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public ProctoringService setVendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    public String getAssessmentSettingsUrl() {
        return assessmentSettingsUrl;
    }

    public ProctoringService setAssessmentSettingsUrl(String assessmentSettingsUrl) {
        this.assessmentSettingsUrl = assessmentSettingsUrl;
        return this;
    }

    public Map<String, String> getAssessmentSettingsCustomParameters() {
        return assessmentSettingsCustomParameters;
    }

    public ProctoringService setAssessmentSettingsCustomParameters(Map<String, String> assessmentSettingsCustomParameters) {
        this.assessmentSettingsCustomParameters = assessmentSettingsCustomParameters;
        return this;
    }

    public String getBrowserDownloadUrl() {
        return browserDownloadUrl;
    }

    public ProctoringService setBrowserDownloadUrl(String browserDownloadUrl) {
        this.browserDownloadUrl = browserDownloadUrl;
        return this;
    }

    public Availability getAvailability() {
        return availability;
    }

    public ProctoringService setAvailability(Availability availability) {
        this.availability = availability;
        return this;
    }
}

