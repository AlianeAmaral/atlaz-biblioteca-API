package com.atlaz.atlaz_biblioteca.infrastructure.persistence.adapter;

import com.atlaz.atlaz_biblioteca.domain.model.Image;
import com.atlaz.atlaz_biblioteca.domain.repository.ImageRepository;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.ImageEntity;
import com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository.ImageMongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component // diz para o spring gerenciar essa classe
public class ImageRepositoryAdapter implements ImageRepository {

    private final ImageMongoRepository imageMongoRepository;

    public ImageRepositoryAdapter(ImageMongoRepository imageMongoRepository) {
        this.imageMongoRepository = imageMongoRepository;
    }

    @Override
    public Image save(Image image) {

        // converte domain para entity
        ImageEntity entity = new ImageEntity();
        entity.setFileName(image.getFileName());
        entity.setBase64Data(image.getBase64Data());

        // salva no mongodb
        ImageEntity savedEntity = imageMongoRepository.save(entity);

        // atualiza o ID do objeto original e o retorna a imagem
        image.setId(savedEntity.getId());
        return image;
    }

    @Override
    public Optional<Image> findById(String id) {
        // busca no banco, se encontrar converte para domain
        return imageMongoRepository.findById(id)
                .map(this::toDomain);
    }

    // traduz de entity para domain
    private Image toDomain(ImageEntity entity) {
        Image image = new Image();
        image.setId(entity.getId());
        image.setFileName(entity.getFileName());
        image.setBase64Data(entity.getBase64Data());
        return image;
    }
}