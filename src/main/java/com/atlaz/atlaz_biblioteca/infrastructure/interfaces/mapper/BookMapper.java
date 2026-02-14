package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateBookRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.BookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toDomain(CreateBookRequest request) {
        Book book = new Book();
        book.setBookCode(request.bookCode());
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setGenre(request.genre());
        book.setImageId(request.imageId());
        book.setBookStatus(request.bookStatus());
        return book;
    }

    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getBookCode(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getImageId(),
                book.getBookStatus()
        );
    }
}