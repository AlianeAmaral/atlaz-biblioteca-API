package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    // salva ou atualiza aluno
    Student save(Student student);

    // busca de aluno pelo ID
    Optional<Student> findById(Long id);

    // lista todos os alunos cadastrados
    List<Student> findAll();

    // se for o caso de precisar aplicar delete futuramente, utilizar o seguinte:
    //void deleteById(Long id);
}