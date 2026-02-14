package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response;

import com.atlaz.atlaz_biblioteca.domain.model.LoanStatus;
import java.time.LocalDateTime;

public record LoanResponse (
    Long id,
    String registration,
    Long bookCode,
    LocalDateTime startDate,
    LocalDateTime endDate,
    LoanStatus loanStatus
) {}
