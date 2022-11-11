package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.mongo.document.PersonaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonaRepository extends MongoRepository<PersonaDocument, String> {

    @Query("{cc_per: ?0}")
    List<PersonaDocument> findByCc(Integer cc_per);

}
