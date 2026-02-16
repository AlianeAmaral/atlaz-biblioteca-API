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

    // possibilita download da imagem existente
    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> download(@PathVariable String id) {

        // busca a imagem existente no usecase dela
        Image image = getImageUseCase.execute(id);

        // coleta o texto original da imagem
        String base64Text = image.getBase64Data();

        // remove o prefixo (ex: "data:image/png;base64,") se existir
        if (base64Text != null && base64Text.contains(",")) {
            base64Text = base64Text.split(",")[1];
        }

        // limpa espaços em branco, tabs e quebras de linha ocultas
        if (base64Text != null) {
            base64Text = base64Text.replaceAll("\\s+", "");
        }

        // utilização do MimeDecoder (mais resistente a erros)
        byte[] fileData = java.util.Base64.getMimeDecoder().decode(base64Text);

        // monta a resposta para possibilitar o download da imagem
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileData);
    }
}
