package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.domain.repository.LoanRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.BookEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.LoanEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.StudentEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.BookJpaRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.LoanJpaRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanRepositoryAdapter implements LoanRepository {

    private final LoanJpaRepository loanJpaRepository;
    private final StudentJpaRepository studentJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    public LoanRepositoryAdapter(LoanJpaRepository loanJpaRepository, StudentJpaRepository studentJpaRepository, BookJpaRepository bookJpaRepository) {
        this.loanJpaRepository = loanJpaRepository;
        this.studentJpaRepository = studentJpaRepository;
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public Loan save(Loan loan) {
        LoanEntity entity = new LoanEntity();
        if (loan.getId() != null) entity.setId(loan.getId());

        // busca aluno e livro para associar com a entidade do empréstimo
        StudentEntity student = studentJpaRepository.findById(loan.getStudentId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        BookEntity book = bookJpaRepository.findById(loan.getBookId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        entity.setStudent(student);
        entity.setBook(book);
        entity.setLoanDate(loan.getStartDate());
        entity.setReturnDate(loan.getEndDate());

        LoanEntity saved = loanJpaRepository.save(entity);
        loan.setId(saved.getId());

        return loan;
    }

    @Override
    public List<Loan> findAll() {
        return List.of();
    }
}