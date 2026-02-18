package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request;

import com.atlaz.atlaz_biblioteca.domain.model.LoanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateLoanRequest(

        @NotBlank(message = "O preenchimento do aluno é obrigatório")
        String registration,

        @NotNull(message = "O preenchimento do livro é obrigatório")
        Long bookCode,

        @NotNull(message = "O preenchimento da data de início do empréstimo é obrigatório")
        LocalDate startDate,

        @NotNull(message = "O preenchimento da data de devolução do empréstimo é obrigatório")
        LocalDate endDate,

        @NotNull(message = "É obrigatório selecionar o status de empréstimo ativo ou finalizado")
        LoanStatus loanStatus
) {}
