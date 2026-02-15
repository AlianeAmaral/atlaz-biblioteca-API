package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.student.ListAllStudentUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.student.UpdateStudentUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.application.usecase.student.CreateStudentUseCase;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.CreateStudentRequest;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response.StudentResponse;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.mapper.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // foi colocado dessa forma para separar quem cria e quem lista (SRP: princípio da responsabilidade única)
    private final CreateStudentUseCase createStudentUseCase;
    private final ListAllStudentUseCase listAllStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;
    private final StudentMapper studentMapper;

    // construtor que injeta as duas dependências
    public StudentController(CreateStudentUseCase createStudentUseCase, ListAllStudentUseCase listAllStudentUseCase, UpdateStudentUseCase updateStudentUseCase, StudentMapper studentMapper) {
        this.createStudentUseCase = createStudentUseCase;
        this.listAllStudentUseCase = listAllStudentUseCase;
        this.updateStudentUseCase = updateStudentUseCase;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // boa prática para retorno - 201 (sucesso gravado no banco), etc
    public StudentResponse create(@RequestBody CreateStudentRequest request) {

        // converte DTO (request) para domínio
        Student studentDomain = studentMapper.toDomain(request);
        // executa regra de negócio
        Student savedStudent = createStudentUseCase.execute(studentDomain);

        // converte domínio para DTO (response) e retorna resultado
        return studentMapper.toResponse(savedStudent);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> findAll() { // resposta após finalizado fluxo

        // busca a lista de livros do domínio
        List<Student> students = listAllStudentUseCase.execute();

        // converte a lista inteira de domínio para DTO de response
        return students.stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse update(@PathVariable Long id, @RequestBody CreateStudentRequest request) {

        // converte o DTO request para domain
        Student studentDomain = studentMapper.toDomain(request);
        // executa o UseCase passando o ID da URL e demais dados do objeto
        Student updatedStudent = updateStudentUseCase.execute(id, studentDomain);

        // Converte de volta para Response (DTO)
        return studentMapper.toResponse(updatedStudent);
    }
}
