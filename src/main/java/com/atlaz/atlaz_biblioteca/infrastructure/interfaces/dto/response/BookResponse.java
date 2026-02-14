package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response;

import com.atlaz.atlaz_biblioteca.domain.model.BookStatus;

public record BookResponse(
        Long id,
        Long bookCode,
        String title,
        String author,
        String genre,
        String imageId,
        BookStatus bookStatus
) {}