package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.model.BookStatus;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.BookEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryAdapter implements BookRepository {

    private final BookJpaRepository jpaRepository;

    public BookRepositoryAdapter(BookJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Book save(Book book) {
        BookEntity entity = new BookEntity();
        if (book.getId() != null) entity.setId(book.getId());

        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setGenre(book.getGenre());
        entity.setImageId(book.getImageId());

        // converte o enum para string no banco
        entity.setBookStatus(book.getBookStatus() != null ? book.getBookStatus().name() : "AVAILABLE");

        BookEntity saved = jpaRepository.save(entity);
        book.setId(saved.getId());
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }
}