package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(Long id);
    List<Loan> findAll();
}
