package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateLoanRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.LoanResponse;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    // transforma o request em modelo de domain
    public Loan toDomain(CreateLoanRequest request) {
        Loan loan = new Loan();
        loan.setRegistration(request.registration());
        loan.setBookCode(request.bookCode());
        return loan;
    }

    // transforma o modelo de domain para o response
    public LoanResponse toResponse(Loan loan) {
        return new LoanResponse(
                loan.getId(),
                loan.getRegistration(),
                loan.getBookCode(),
                loan.getStartDate(),
                loan.getEndDate(),
                loan.getLoanStatus()
        );
    }
}
