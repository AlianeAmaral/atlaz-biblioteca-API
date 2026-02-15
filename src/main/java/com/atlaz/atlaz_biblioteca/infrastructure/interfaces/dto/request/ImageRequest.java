package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request;

public class ImageRequest {
    private String fileName;
    private String base64Data;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }
}