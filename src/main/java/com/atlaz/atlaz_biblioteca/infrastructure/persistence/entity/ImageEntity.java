package com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// aqui não será entity pois ela é do Postgres/JPA, aqui será @Document, que diz ao spring que vai para uma coleção
@Document(collection = "images")
public class ImageEntity {

    @Id // define chave primária no mongodb
    private String id;
    private String fileName;
    private String base64Data;

    // getters e setters necessários para o spring salvar
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
