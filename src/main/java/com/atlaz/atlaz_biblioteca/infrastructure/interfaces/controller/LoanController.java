package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.loan.CreateLoanUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final CreateLoanUseCase createLoanUseCase;

    public LoanController(CreateLoanUseCase createLoanUseCase) {
        this.createLoanUseCase = createLoanUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan create(@RequestBody Loan loan) {
        return createLoanUseCase.execute(loan);
    }

    @GetMapping
    public List<Loan> findAll() {
        return createLoanUseCase.findAll();
    }
}