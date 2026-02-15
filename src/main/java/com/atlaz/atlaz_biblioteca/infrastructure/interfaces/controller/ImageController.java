package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.image.UploadImageUseCase;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.ImageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final UploadImageUseCase uploadImageUseCase;

    public ImageController(UploadImageUseCase uploadImageUseCase) {
        this.uploadImageUseCase = uploadImageUseCase;
    }

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestBody ImageRequest request) {

        // chama o usecase dele e retorna o ID gerado pelo mongodb
        return uploadImageUseCase.execute(request.getFileName(), request.getBase64Data());
    }
}
