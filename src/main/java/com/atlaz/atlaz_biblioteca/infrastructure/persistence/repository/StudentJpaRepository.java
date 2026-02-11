package com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}