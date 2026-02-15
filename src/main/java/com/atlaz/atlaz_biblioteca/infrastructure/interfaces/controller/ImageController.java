package com.atlaz.atlaz_biblioteca.infrastructure.interfaces.controller;

import com.atlaz.atlaz_biblioteca.application.usecase.image.GetImageUseCase;
import com.atlaz.atlaz_biblioteca.application.usecase.image.UploadImageUseCase;
import com.atlaz.atlaz_biblioteca.domain.model.Image;
import com.atlaz.atlaz_biblioteca.infrastructure.interfaces.dto.request.ImageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final UploadImageUseCase uploadImageUseCase;
    private final GetImageUseCase getImageUseCase;

    public ImageController(UploadImageUseCase uploadImageUseCase, GetImageUseCase getImageUseCase) {
        this.uploadImageUseCase = uploadImageUseCase;
        this.getImageUseCase = getImageUseCase;
    }

    // upload da imagem
    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestBody ImageRequest request) {

        // chama o usecase dele e retorna o ID gerado pelo mongodb
        return uploadImageUseCase.execute(request.getFileName(), request.getBase64Data());
    }

    // mostrar a imagem existente por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Image getById(@PathVariable String id) {
        return getImageUseCase.execute(id);
    }

    @GetMapping("/{id}/download")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> download(@PathVariable String id) {

        // busca a imagem usando o usecase da imagem
        Image image = getImageUseCase.execute(id);

        // converte o texto Base64 de volta para um array de bytes (binário)
        byte[] fileData = java.util.Base64.getDecoder().decode(image.getBase64Data());

        // monta a resposta com o cabeçalho de download
        return ResponseEntity.ok()

                // aqui é definido o nome que será apresentado no arquivo de download
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"")

                // aqui descreve o tipo de conteúdo (opcional, mas é bom ter)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileData);
    }
}
