package com.atlaz.atlaz_biblioteca.domain.model;

public class Image {

    private String id; // id é string no mongodb
    private String fileName; // nome real do arquivo com extensão (.jpg)
    private String base64Data; // imagem transformada em texto

    public Image(){
    }

    public Image(String id, String fileName, String base64Data) {
        this.id = id;
        this.fileName = fileName;
        this.base64Data = base64Data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
