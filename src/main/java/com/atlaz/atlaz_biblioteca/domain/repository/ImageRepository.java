package com.atlaz.atlaz_biblioteca.domain.repository;

import com.atlaz.atlaz_biblioteca.domain.model.Image;
import java.util.Optional;

public interface ImageRepository {

    // esse contrato diz que que implementar esse repositório deve saber salvar uma Image e buscar por ID
    Image save(Image image);
    Optional<Image> findById(String id);
}
