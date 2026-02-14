package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// record: cria automaticamente construtor, getters, equals e hashcode - recomendado para DTOs para ser facilitação
// @NotBlack: garante preenchimento
// @Email: garante que o email tenha formato (@ e .)

public record CreateStudentRequest (

            @NotBlank(message = "O preenchimento do nome é obrigatório")
            String name,

            @NotBlank(message = "O preenchimento do email é obrigatório")
            @Email(message = "O formato de email é inválido")
            String email,

            @NotBlank(message = "O preechimento da matrícula é obrigatório")
            String registration,

            String imageId
) {}
