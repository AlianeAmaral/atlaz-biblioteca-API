package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    // salva ou atualiza aluno
    Student save(Student student);

    // busca aluno por matrícula
    Optional<Student> findByRegistration(String registration);

    // lista todos os alunos cadastrados
    List<Student> findAll();
}