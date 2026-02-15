package com.atlaz.atlaz_biblioteca.application.usecase.image;

import com.atlaz.atlaz_biblioteca.domain.model.Image;
import com.atlaz.atlaz_biblioteca.domain.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class UploadImageUseCase {

    private final ImageRepository imageRepository;

    public UploadImageUseCase(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String execute(String fileName, String base64Data) {

        // cria um domain os dados recebidos
        Image image = new Image();
        image.setFileName(fileName);
        image.setBase64Data(base64Data);

        // pede para o repositório salvar (ele vai usar o mongodb)
        Image savedImage = imageRepository.save(image);

        // retorna apenas o ID da imagem salva para ser usado no postegresql
        return savedImage.getId();
    }
}