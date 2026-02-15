package com.atlaz.atlaz_biblioteca.domain.model;

// private para segurança / encapsulamento
public class Student {
    private Long id;
    private String name;
    private String email;
    private String registration;
    private String imageId;
    private String enrollmentProofId;

    // construtor com todos os argumentos, o atributo recebe o valor recebido de fora
    public Student(Long id, String name, String email, String registration, String imageId, String enrollmentProofId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registration = registration;
        this.imageId = imageId;
        this.enrollmentProofId = enrollmentProofId;
    }

    // construtor vazio (flexibilidade para criação do objeto)
    public Student() {}

    // public, getters (permite ver sem mexer) e setters (permite mexer mas com regras)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getEnrollmentProofId() {
        return enrollmentProofId;
    }

    public void setEnrollmentProofId(String enrollmentProofId) {
        this.enrollmentProofId = enrollmentProofId;
    }
}
