package com.atlaz.atlaz_biblioteca.application.usecase.loan;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.domain.repository.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListAllLoanUseCase {

    private final LoanRepository loanRepository;

    public ListAllLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        return loanRepository.findAll();
    }
}
