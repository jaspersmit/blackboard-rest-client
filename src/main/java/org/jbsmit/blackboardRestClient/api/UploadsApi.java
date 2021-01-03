package org.jbsmit.blackboardRestClient.api;

import com.google.gson.reflect.TypeToken;
import org.jbsmit.blackboardRestClient.model.UploadedFileInfo;
import org.jbsmit.blackboardRestClient.agentsupport.RestCall;
import org.jbsmit.blackboardRestClient.agentsupport.RestCallBuilder;

public class UploadsApi {
    /*
     * Upload
     *
     * Upload a file to temporary storage. The request is a multipart/form-data POST following RFC 1867. (https://www.ietf.org/rfc/rfc1867.txt)
     *
     * The uploaded file will be scanned for potential security threats by the system's XSS filters. If the file is deemed as unsafe, the request will be rejected and an HTTP Status of 422 is returned.
     *
     * Returns an ID of the file reference, so it can be used for processing by a different service.
     *
     * Example Request: <pre>  curl -X POST -H 'Authorization: Bearer your_token' -F 'file=@/path/to/your/file' https://YOUR_LEARN_INSTANCE/learn/api/public/v1/uploads  </pre>
     *
     * **Since**: 3100.12.0
     */
    public static RestCall<UploadedFileInfo> upload() {
        return RestCallBuilder
            .start(new TypeToken<UploadedFileInfo>() {})
            .post()
            .url("/learn/api/public/v1/uploads")
            .build();
    }
}
