package com.atlaz.atlaz_biblioteca.infrastructure.persistence.repository;

import com.atlaz.atlaz_biblioteca.infrastructure.persistence.entity.ImageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMongoRepository extends MongoRepository<ImageEntity, String> {
    // spring entende que você quer salvar ImageEntity usando String como ID neste local
    // esse arquivo é o local que fala a língua do banco utilizado
}
