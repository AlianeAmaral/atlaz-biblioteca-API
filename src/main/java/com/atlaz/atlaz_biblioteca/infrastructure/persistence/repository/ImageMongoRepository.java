package com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.ImageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMongoRepository extends MongoRepository<ImageEntity, String> {
    // aqui o spring já entnde que você quer salvar ImageEntity usando String como ID
    // esse arquivo é a ferramenta técnica que fala a língua do mongodb
}
