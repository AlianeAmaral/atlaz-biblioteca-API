package com.atlaz.atlaz_biblioteca.application.usecase.book;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.model.BookStatus;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // comunica spring que é uma classe de serviço
public class CreateBookUseCase {

    private final BookRepository repository;

    // construtor que realiza a injeção de dependência do repository
    public CreateBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    // todo livro começará como disponível

    public Book execute(Book book) {
        if (book.getStatus() == null) {
            book.setStatus(BookStatus.AVAILABLE);
        }
        return repository.save(book);
    }
}