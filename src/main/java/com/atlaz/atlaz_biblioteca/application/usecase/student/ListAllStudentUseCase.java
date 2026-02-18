package com.atlaz.atlaz_biblioteca.application.usecase.student;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListAllStudentUseCase {

    // este conhece somente a interface do repository
    private final StudentRepository studentRepository;

    // injeção de dependência através do construtor
    public ListAllStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // método que de fato executa a ação
    public List<Student> execute() {
        // devolve a lista de todos os alunos
        return studentRepository.findAll();
    }
}
