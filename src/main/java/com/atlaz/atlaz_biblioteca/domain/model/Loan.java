package com.atlaz.atlaz_biblioteca.domain.model;

import java.time.LocalDateTime;

public class Loan {
    private Long id;
    private String registration;
    private Long bookCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LoanStatus loanStatus;

    public Loan(Long id, String registration, Long bookCode, LocalDateTime startDate, LocalDateTime endDate, LoanStatus loanStatus) {
        this.id = id;
        this.registration = registration;
        this.bookCode = bookCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loanStatus = loanStatus;
    }

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Long getBookCode() {
        return bookCode;
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}