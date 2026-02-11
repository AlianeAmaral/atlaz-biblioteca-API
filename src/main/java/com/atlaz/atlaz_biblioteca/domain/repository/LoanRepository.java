package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import java.util.List;

public interface LoanRepository {
    Loan save(Loan loan);
    List<Loan> findAll();
}