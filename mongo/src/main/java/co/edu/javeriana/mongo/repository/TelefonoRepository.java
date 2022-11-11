package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.TelefonoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TelefonoRepository extends MongoRepository<TelefonoDocument, String> {
}
