package com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    // permite encontrar o código do livro no empréstimo, usado para criação do empréstimo
    Optional<BookEntity> findByBookCode(Long bookCode);
}