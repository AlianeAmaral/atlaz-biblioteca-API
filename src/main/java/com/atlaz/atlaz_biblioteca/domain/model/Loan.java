package com.atlaz.atlaz_biblioteca.domain.model;

import java.time.LocalDateTime;

public class Loan {
    private Long id;
    private Long studentId;
    private Long bookId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LoanStatus status;

    public Loan() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }

    public void setLoanDate(LocalDateTime now) {
        this.startDate = now;
    }
}