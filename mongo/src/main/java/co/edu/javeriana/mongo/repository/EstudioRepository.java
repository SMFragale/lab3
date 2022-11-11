package co.edu.javeriana.mongo.repository;

import co.edu.javeriana.mongo.document.EstudioDocument;
import co.edu.javeriana.mongo.document.EstudioPK;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EstudioRepository extends MongoRepository<EstudioDocument, String> {

    @Query("{univer:?0}")
    public List<EstudioDocument> findByUniver(String univer);

    @Query("{'cc_per':?0, }")
    public List<EstudioDocument> findByCc_per(int cc_per);

}
