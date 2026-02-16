package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.loan.CreateLoanUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.loan.ListAllLoanUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.loan.UpdateLoanUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateLoanRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.LoanResponse;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper.LoanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final CreateLoanUseCase createLoanUseCase;
    private final ListAllLoanUseCase listAllLoanUseCase;
    private final UpdateLoanUseCase updateLoanUseCase;
    private final LoanMapper loanMapper;

    public LoanController(CreateLoanUseCase createLoanUseCase, ListAllLoanUseCase listAllLoanUseCase, UpdateLoanUseCase updateLoanUseCase, LoanMapper loanMapper) {
        this.createLoanUseCase = createLoanUseCase;
        this.listAllLoanUseCase = listAllLoanUseCase;
        this.updateLoanUseCase = updateLoanUseCase;
        this.loanMapper = loanMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponse create(@RequestBody CreateLoanRequest request) {

        Loan loanDomain = loanMapper.toDomain(request);
        Loan savedLoan = createLoanUseCase.execute(loanDomain);

        return loanMapper.toResponse(savedLoan);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoanResponse> findAll() {

        List<Loan> loans = listAllLoanUseCase.execute();

        return loans.stream()
                .map(loanMapper::toResponse)
                .toList();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LoanResponse update(@PathVariable Long id, @RequestBody CreateLoanRequest request) {

        Loan loanDomain = loanMapper.toDomain(request);
        Loan updatedLoan = updateLoanUseCase.execute(id, loanDomain);

        return loanMapper.toResponse(updatedLoan);
    }
}
