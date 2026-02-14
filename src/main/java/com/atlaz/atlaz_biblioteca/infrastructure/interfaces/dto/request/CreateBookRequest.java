package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request;

import com.atlaz.atlaz_biblioteca.domain.model.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBookRequest (

        @NotNull(message = "O preenchimento do código do livro é obrigatório")
        Long bookCode,

        @NotBlank(message = "O preenchimento do título do livro é obrigatório")
        String title,

        @NotBlank(message = "O preenchimento do autor é obrigatório")
        String author,

        @NotBlank(message = "O preenchimento do gênero é obrigatório")
        String genre,

        @NotNull(message = "É obrigatório selecionar o status disponível ou indisponível")
        BookStatus bookStatus,

        String imageId
) {}
