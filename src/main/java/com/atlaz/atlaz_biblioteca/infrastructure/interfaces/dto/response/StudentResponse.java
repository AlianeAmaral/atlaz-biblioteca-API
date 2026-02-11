package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.response;

public record StudentResponse(
        Long id,
        String name,
        String email,
        String registration,
        String imageId
) {}