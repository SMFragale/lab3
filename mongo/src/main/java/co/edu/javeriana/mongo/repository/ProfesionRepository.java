package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.ProfesionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfesionRepository extends MongoRepository<ProfesionDocument, String> {
}
