package com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanJpaRepository extends JpaRepository<LoanEntity, Long> {
}
