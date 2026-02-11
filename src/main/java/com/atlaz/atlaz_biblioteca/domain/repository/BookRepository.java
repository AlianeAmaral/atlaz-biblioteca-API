package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    // salva livro novo ou edição
    Book save(Book book);

    // busca do livro pelo ID
    Optional<Book> findById(Long id);

    // lista todos os livros
    List<Book> findAll();

}