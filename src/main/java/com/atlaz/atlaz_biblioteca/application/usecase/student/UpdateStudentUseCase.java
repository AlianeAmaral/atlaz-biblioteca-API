package com.atlaz.atlaz_biblioteca.application.usecase.student;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentUseCase {

    private final StudentRepository studentRepository;

    public UpdateStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(Long id, Student studentUpdate) {
        // busca um aluno existente
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    // atualiza só os campos permitidos
                    existingStudent.setName(studentUpdate.getName());
                    existingStudent.setEmail(studentUpdate.getEmail());
                    existingStudent.setImageId(studentUpdate.getImageId());
                    existingStudent.setEnrollmentProofId(studentUpdate.getEnrollmentProofId());

                    // salva versão atualizada
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow(() -> new RuntimeException("Aluno com ID " + id + " não encontrado"));
    }
}
