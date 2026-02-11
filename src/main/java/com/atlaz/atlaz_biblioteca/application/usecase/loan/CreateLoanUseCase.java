//package com.atlaz.atlaz_biblioteca.application.usecase.loan;
//
//import com.atlaz.atlaz_biblioteca.domain.model.loan;
//import com.atlaz.atlaz_biblioteca.domain.repository.loanrepository;
//import org.springframework.stereotype.service;
//
//import java.time.localdatetime;
//import java.util.list;
//
//@service // spring irá injetar no controller
//public class createloanusecase {
//
//    private final loanrepository repository;
//
//    public createloanusecase(loanrepository repository) {
//        this.repository = repository;
//    }
//
//    public loan execute(loan loan) {
//        // define a data de hoje automaticamente
//        loan.setloandate(localdatetime.now());
//
//        // salva o empréstimo usando o adapter
//        return repository.save(loan);
//    }
//
//    public list<loan> findall() {
//        return repository.findall();
//    }
//}