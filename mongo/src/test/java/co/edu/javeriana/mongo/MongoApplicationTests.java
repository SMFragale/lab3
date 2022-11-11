package co.edu.javeriana.mongo;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.mongo.document.EstudioDocument;
import co.edu.javeriana.mongo.mapper.EstudioMapperImpl;
import co.edu.javeriana.mongo.repository.EstudioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class MongoApplicationTests {
	@Autowired
	EstudioRepository estudioRepository;

	EstudioMapperImpl estudioMapper = new EstudioMapperImpl();
	@Test
	void repositorySave() {
		estudioRepository.save(new EstudioDocument(2,2, LocalDate.now(),"Andes"));
	}

	@Test
	void documentToDomain(){
//		EstudioDocument document = estudioRepository.findByUniver("Javeriana").get(0);
		EstudioDocument document = estudioRepository.findByCc_per(1).get(0);
		Estudio estudio = estudioMapper.fromDocumentToDomain(document);
		System.out.println(estudio.toString());

	}

}
