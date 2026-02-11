package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student); // salva ou atualiza aluno

    Optional<Student> findById(Long id); // busca de aluno pelo ID

    List<Student> findAll(); // lista todos os alunos cadastrados
}