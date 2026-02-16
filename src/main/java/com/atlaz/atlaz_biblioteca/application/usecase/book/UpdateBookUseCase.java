package com.atlaz.atlaz_biblioteca.application.usecase.book;

import com.atlaz.atlaz_biblioteca.domain.model.Book;
import com.atlaz.atlaz_biblioteca.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookUseCase {

    private final BookRepository bookRepository;

    public UpdateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(Long id, Book bookUpdate) {
        // busca um livro existente
        return bookRepository.findById(id)
                .map(existingBook -> {

                    if (bookUpdate.getTitle() != null && !bookUpdate.getTitle().isBlank()) {
                        existingBook.setBookCode(bookUpdate.getBookCode());
                    }

                    if (bookUpdate.getAuthor() != null && !bookUpdate.getAuthor().isBlank()) {
                        existingBook.setAuthor(bookUpdate.getAuthor());
                    }

                    if (bookUpdate.getGenre() != null && !bookUpdate.getGenre().isBlank()) {
                        existingBook.setGenre(bookUpdate.getGenre());
                    }

                    if (bookUpdate.getImageId() != null && !bookUpdate.getImageId().isBlank()) {
                        existingBook.setImageId(bookUpdate.getImageId());
                    }

                    // isBlank é apenas para textos
                    if (bookUpdate.getBookStatus() != null){
                        existingBook.setBookStatus(bookUpdate.getBookStatus());
                    }

                    //salva versão atualizada
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado"));
    }
}
