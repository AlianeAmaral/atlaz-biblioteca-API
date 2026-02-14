package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findByBookCode(Long bookCode);
    List<Book> findAll();
}