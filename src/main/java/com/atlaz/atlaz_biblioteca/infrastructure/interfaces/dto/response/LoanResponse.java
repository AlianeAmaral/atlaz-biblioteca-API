package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response;

import com.atlaz.atlaz_biblioteca.domain.model.LoanStatus;

import java.time.LocalDate;

public record LoanResponse (
    Long id,
    String registration,
    Long bookCode,
    LocalDate startDate,
    LocalDate endDate,
    LoanStatus loanStatus
) {}
