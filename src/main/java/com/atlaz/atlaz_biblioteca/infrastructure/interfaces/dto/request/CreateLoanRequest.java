package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request;

import com.atlaz.atlaz_biblioteca.domain.model.LoanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CreateLoanRequest(

        @NotBlank(message = "O preenchimento do aluno é obrigatório")
        String registration,

        @NotBlank(message = "O preenchimento do livro é obrigatório")
        Long bookCode,

        @NotBlank(message = "O preenchimento da data de início do empréstimo é obrigatório")
        LocalDateTime startDate,

        LocalDateTime endDate,

        @NotNull(message = "É obrigatório selecionar o status de empréstimo ativo ou finalizado")
        LoanStatus loanStatus
) {}
