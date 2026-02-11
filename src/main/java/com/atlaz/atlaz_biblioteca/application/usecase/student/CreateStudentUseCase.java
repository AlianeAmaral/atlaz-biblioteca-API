package com.atlaz.atlaz_biblioteca.application.usecase.student;

import com.atlaz.atlaz_biblioteca.domain.repository.StudentRepository;
import com.atlaz.atlaz_biblioteca.domain.model.Student;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentUseCase {

    private final StudentRepository studentRepository;

    public CreateStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(Student student) {
        return studentRepository.save(student);
    }
}
