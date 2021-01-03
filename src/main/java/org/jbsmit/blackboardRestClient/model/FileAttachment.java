package org.jbsmit.blackboardRestClient.model;


public class FileAttachment {
    private String id;

    private String fileName;

    private String mimeType;


    public String getId() {
        return id;
    }

    public FileAttachment setId(String id) {
        this.id = id;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public FileAttachment setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getMimeType() {
        return mimeType;
    }

    public FileAttachment setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}

