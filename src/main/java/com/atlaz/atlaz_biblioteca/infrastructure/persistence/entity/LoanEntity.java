package com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.BookEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.StudentEntity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // muitos empréstimos para um mesmo aluno
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    // muitos empréstimos (em tempos diferentes) para um livro
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Column(nullable = false)
    private LocalDateTime loanDate;

    // pode ser null se não tiver devolvido
    private LocalDateTime returnDate;

    public LoanEntity() {}

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
    public LocalDateTime getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}