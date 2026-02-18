package com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

    // permite encontrar a matrícula no empréstimo, utilizado para criação do empréstimo
    Optional<StudentEntity> findByRegistration(String registration);
}