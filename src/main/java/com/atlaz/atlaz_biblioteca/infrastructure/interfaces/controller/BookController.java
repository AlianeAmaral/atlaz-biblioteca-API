package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.book.CreateBookUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.book.GetBookUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.book.ListAllBookUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.book.UpdateBookUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateBookRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.BookResponse;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.StudentResponse;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final GetBookUseCase getBookUseCase;
    private final ListAllBookUseCase listAllBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final BookMapper bookMapper;

    public BookController(CreateBookUseCase createBookUseCase, GetBookUseCase getBookUseCase, ListAllBookUseCase listAllBookUseCase, UpdateBookUseCase updateBookUseCase, BookMapper bookMapper) {
        this.createBookUseCase = createBookUseCase;
        this.getBookUseCase = getBookUseCase;
        this.listAllBookUseCase = listAllBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody CreateBookRequest request) {

        Book bookDomain = bookMapper.toDomain(request);
        Book savedBook = createBookUseCase.execute(bookDomain);

        return bookMapper.toResponse(savedBook);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getById(@PathVariable Long id) {
        Book book = getBookUseCase.execute(id);
        return bookMapper.toResponse(book);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findAll() {

        List<Book> books = listAllBookUseCase.execute();

        return books.stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
        // não foi criado outro UpdateBookRequest porque na edição seriam todos os campos para editar mesmo (DRY)
        public BookResponse update(@PathVariable Long id, @RequestBody CreateBookRequest request) {

            Book bookDomain = bookMapper.toDomain(request);
            Book updatedBook = updateBookUseCase.execute(id, bookDomain);

            return bookMapper.toResponse(updatedBook);
        }
}