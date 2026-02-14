package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.domain.repository.LoanRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.LoanEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.BookJpaRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.LoanJpaRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Loan save (Loan loan) {
        var studentEntity = studentJpaRepository.findByRegistration(loan.getRegistration())
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado com matrícula: " + loan.getRegistration()));

        var bookEntity = bookJpaRepository.findByBookCode(loan.getBookCode())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com código: " + loan.getBookCode()));

        // modelo de domain para entity no banco
        LoanEntity entity = new LoanEntity();
        entity.setStudent(studentEntity);
        entity.setBook(bookEntity);
        entity.setStartDate(loan.getStartDate());
        entity.setEndDate(loan.getEndDate());
        entity.setLoanStatus(loan.getLoanStatus());

        // salva no banco realmente
        LoanEntity savedEntity = loanJpaRepository.save(entity);

        // devolve o modelo de domain com o ID criado no banco
        loan.setId(savedEntity.getId());
        return loan;
    }

    @Override
    public List<Loan> findAll() {
        // converte lista da entidade para lista de objetos de domain
        return loanJpaRepository.findAll().stream()
                .map(entity -> new Loan(
                        entity.getId(),
                        entity.getStudent().getRegistration(),
                        entity.getBook().getBookCode(),
                        entity.getStartDate(),
                        entity.getEndDate(),
                        entity.getLoanStatus()
                )).toList();
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return loanJpaRepository.findById(id)
                .map(entity -> new Loan(
                        entity.getId(),
                        entity.getStudent().getRegistration(),
                        entity.getBook().getBookCode(),
                        entity.getStartDate(),
                        entity.getEndDate(),
                        entity.getLoanStatus()
                ));
    }
}