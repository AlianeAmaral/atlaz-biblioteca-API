package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response;

import com.atlaz.atlaz_biblioteca.domain.model.BookStatus;

public record BookResponse(
        Long id,
        String title,
        String author,
        String genre,
        String imageId,
        BookStatus bookStatus
) {}