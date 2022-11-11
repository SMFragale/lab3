package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.PersonaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<PersonaDocument, String> {
}
