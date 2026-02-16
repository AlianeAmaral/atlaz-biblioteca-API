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

                    // atualiza só os campos permitidos, se for null, manterá o mesmo valor existente
                    if (studentUpdate.getName() != null && !studentUpdate.getName().isBlank()) {
                        existingStudent.setName(studentUpdate.getName());
                    }

                    if (studentUpdate.getEmail() != null && !studentUpdate.getEmail().isBlank()) {
                        existingStudent.setEmail(studentUpdate.getEmail());
                    }

                    if (studentUpdate.getRegistration() != null && !studentUpdate.getRegistration().isBlank()) {
                        existingStudent.setRegistration(studentUpdate.getRegistration());
                    }

                    if (studentUpdate.getImageId() != null) {
                        existingStudent.setImageId(studentUpdate.getImageId());
                    }

                    if (studentUpdate.getEnrollmentProofId() != null) {
                        existingStudent.setEnrollmentProofId(studentUpdate.getEnrollmentProofId());
                    }

                    // salva versão atualizada
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow(() -> new RuntimeException("Aluno com ID " + id + " não encontrado"));
    }
}
