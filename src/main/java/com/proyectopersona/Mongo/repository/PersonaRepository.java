package com.proyectopersona.Mongo.repository;

import com.proyectopersona.Mongo.documentos.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository <Persona, Long>{


}
