package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.book.CreateBookUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;

    public BookController(CreateBookUseCase createBookUseCase) {
        this.createBookUseCase = createBookUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return createBookUseCase.execute(book);
    }

    @GetMapping
    public List<Book> findAll() {
        return createBookUseCase.findAll();
    }
}