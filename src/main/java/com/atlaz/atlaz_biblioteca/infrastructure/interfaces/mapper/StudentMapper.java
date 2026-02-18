package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateStudentRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    // converte DTO (request) para domínio, ID é nulo porque o aluno é novo e ainda não foi salvo no banco
    // está como request pois no CreateStudentRequest está como record
    public Student toDomain(CreateStudentRequest request) {
        return new Student(
                null,
                request.name(),
                request.email(),
                request.registration(),
                request.imageId(),
                request.enrollmentProofId()
        );
    }

    // converte do domínio (student) para DTO (response), nesse momento o ID passa a existir
    public StudentResponse toResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getRegistration(),
                student.getImageId(),
                student.getEnrollmentProofId()
        );
    }
}