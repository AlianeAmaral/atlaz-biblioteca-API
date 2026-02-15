package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.BookEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookRepositoryAdapter implements BookRepository {

    private final BookJpaRepository bookJpaRepository;

    public BookRepositoryAdapter(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public Book save(Book book) {

        BookEntity entity = new BookEntity();
        if (book.getId() != null) {
            entity.setId(book.getId());
        }

        entity.setBookCode(book.getBookCode());
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setGenre(book.getGenre());
        entity.setImageId(book.getImageId());
        entity.setBookStatus(book.getBookStatus());

        BookEntity savedEntity = bookJpaRepository.save(entity);

        book.setId(savedEntity.getId());
        return book;
    }

    // para empréstimo
    @Override
    public Optional<Book> findByBookCode(Long bookCode) {
        return bookJpaRepository.findByBookCode(bookCode)
                .map(this::toDomain);
    }

    // para atualização
    @Override
    public Optional<Book> findById(Long id) {
        return bookJpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Book toDomain(BookEntity entity) {
        Book book = new Book();
        book.setId(entity.getId());
        book.setBookCode(entity.getBookCode());
        book.setTitle(entity.getTitle());
        book.setAuthor(entity.getAuthor());
        book.setGenre(entity.getGenre());
        book.setImageId(entity.getImageId());
        book.setBookStatus(entity.getBookStatus());
        return book;
    }
}