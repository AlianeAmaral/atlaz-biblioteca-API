package com.atlaz.atlaz_biblioteca.application.usecase.loan;

import com.atlaz.atlaz_biblioteca.domain.model.Loan;
import com.atlaz.atlaz_biblioteca.domain.model.LoanStatus;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import com.atlaz.atlaz_biblioteca.domain.repository.LoanRepository;
import com.atlaz.atlaz_biblioteca.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateLoanUseCase {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public CreateLoanUseCase(LoanRepository loanRepository, BookRepository bookRepository, StudentRepository studentRepository) {
           this.loanRepository = loanRepository;
           this.bookRepository = bookRepository;
           this.studentRepository = studentRepository;
    }

    public Loan execute(Loan loan) {

        // valida se o aluno existe pela matrícula
        studentRepository.findByRegistration(loan.getRegistration())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com a matrícula: " + loan.getRegistration()));

        // valida se o livro existe pelo código do livro
        var book = bookRepository.findByBookCode(loan.getBookCode())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o código: " + loan.getBookCode()));

        // regra de negócio: configurar datas, empréstimo automático de 7 dias e status inicial
        loan.setStartDate(LocalDateTime.now());
        loan.setEndDate(LocalDateTime.now().plusDays(7));
        loan.setLoanStatus(LoanStatus.EMPRESTADO);

        // salva o empréstimo em caso de sucesso
        return loanRepository.save(loan);
    }
}
