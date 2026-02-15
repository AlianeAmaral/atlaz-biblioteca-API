package com.atlaz.atlaz_biblioteca.application.usecase.image;

import com.atlaz.atlaz_biblioteca.domain.model.Image;
import com.atlaz.atlaz_biblioteca.domain.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class GetImageUseCase {

    private final ImageRepository imageRepository;

    public GetImageUseCase(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image execute(String id) {

        // vai consultar no mongodb e tentar encontrar a imagem pelo ID
        return imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagem não encontrada no MongoDB com o ID: " + id ));
    }
}
