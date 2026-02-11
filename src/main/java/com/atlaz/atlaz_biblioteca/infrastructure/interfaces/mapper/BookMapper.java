package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateBookRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.BookResponse;

public class BookMapper {

    public static Book toDomain(CreateBookRequest request) {
        return new Book(
                null,
                request.title(),
                request.author(),
                request.genre(),
                request.imageId(),
                request.bookStatus()
        );
    }

    public static BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getImageId(),
                book.getBookStatus()
        );
    }
}