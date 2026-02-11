package com.atlaz.atlaz_biblioteca.application.usecase.book;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllBookUseCase {

    private final BookRepository bookRepository;

    public ListAllBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute() {
        return bookRepository.findAll();
    }
}
