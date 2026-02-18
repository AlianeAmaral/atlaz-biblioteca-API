package com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity;

import com.atlaz.atlaz_biblioteca.domain.model.LoanStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // faz com quem a matrícula e o código de livros sejam associados aos alunos e livros realmente
    @ManyToOne
    @JoinColumn(name = "student_registration", referencedColumnName = "registration", nullable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "book_code", referencedColumnName = "bookCode", nullable = false)
    private BookEntity book;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus loanStatus;

    public LoanEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
