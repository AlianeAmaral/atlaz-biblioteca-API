package com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String registration;

    @Column(name = "image_id")
    private String imageId;

    @Column(name = "enrollment_proof_id")
    private String enrollmentProofId;

    // construtor vazio também para JPA
    public StudentEntity() {
    }

    // getters e setters importantes para execução do hibernate
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