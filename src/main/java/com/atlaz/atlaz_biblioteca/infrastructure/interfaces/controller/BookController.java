package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.book.CreateBookUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.book.ListAllBookUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateBookRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.BookResponse;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final ListAllBookUseCase listAllBookUseCase;

    public BookController(CreateBookUseCase createBookUseCase, ListAllBookUseCase listAllBookUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.listAllBookUseCase = listAllBookUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody CreateBookRequest request) {

        Book bookDomain = BookMapper.toDomain(request);
        Book savedBook = createBookUseCase.execute(bookDomain);

        return BookMapper.toResponse(savedBook);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findAll() {

        List<Book> books = listAllBookUseCase.execute();

        return books.stream()
                .map(BookMapper::toResponse)
                .toList();
    }
}