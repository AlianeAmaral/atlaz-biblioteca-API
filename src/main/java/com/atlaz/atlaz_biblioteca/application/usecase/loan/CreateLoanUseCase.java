package com.atlaz.atlaz_biblioteca.application.usecase.loan;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service // spring irá injetar no controller
public class CreateLoanUseCase {

    private final LoanRepository repository;

    public CreateLoanUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public Loan execute(Loan loan) {
        // define a data de hoje automaticamente
        loan.setLoanDate(LocalDateTime.now());

        // salva o empréstimo usando o adapter
        return repository.save(loan);
    }

    public List<Loan> findAll() {
        return repository.findAll();
    }
}