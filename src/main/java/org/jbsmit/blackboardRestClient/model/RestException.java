package org.jbsmit.blackboardRestClient.model;


public class RestException {
    /*
     * Represents HTTP Status code in the response header.
     */
    private String status;

    /*
     * The error code specific to a particular REST API. It is usually something that conveys information specific to the problem domain. For cases where the HTTP Status code conveys all the information required (such as a 404-Not Found) then the code may be omitted.
     */
    private String code;

    /*
     * Error message that should be easy to understand and convey a concise reason as to why the error occurred
     */
    private String message;

    /*
     * Represents any technical information that a developer calling REST API might find useful.
     */
    private String developerMessage;

    /*
     * Indicates a URL that anyone seeing the error message can click in a browser. The target web page should describe the error condition fully, as well as potential solutions to help them resolve the error condition
     */
    private String extraInfo;


    public String getStatus() {
        return status;
    }

    public RestException setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RestException setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestException setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public RestException setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public RestException setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
        return this;
    }
}

