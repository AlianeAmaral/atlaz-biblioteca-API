package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.domain.model.Student;
import com.atlaz.atlaz_biblioteca.domain.repository.StudentRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.StudentEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentRepositoryAdapter implements StudentRepository {

    private final StudentJpaRepository studentJpaRepository;

    public StudentRepositoryAdapter(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public Student save(Student student) {

        // converte o domain para entity
        StudentEntity entity = new StudentEntity();
        if (student.getId() != null) {
            entity.setId(student.getId());
        }

        entity.setName(student.getName());
        entity.setEmail(student.getEmail());
        entity.setRegistration(student.getRegistration());
        entity.setImageId(student.getImageId());

        StudentEntity savedEntity = studentJpaRepository.save(entity);

        // converte de volta o entity para domain e retorna
        student.setId(savedEntity.getId());
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentJpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // metodo auxiliar para não repetir o código
    private Student toDomain(StudentEntity entity) {
        Student student = new Student();
        student.setId(entity.getId());
        student.setName(entity.getName());
        student.setEmail(entity.getEmail());
        student.setRegistration(entity.getRegistration());
        student.setImageId(entity.getImageId());
        return student;
    }
}