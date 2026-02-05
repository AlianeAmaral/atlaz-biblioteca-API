package com.atlaz.atlaz_biblioteca.domain.model;

import java.time.LocalDate;

public class Loan {
    private Long id;
    private Long studentId;
    private Long bookId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LoanStatus status;
}

// utilizado ID nos atributos para que o domain não dependa da infraestrutura, facilita migração para microsserviços.
