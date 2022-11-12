package co.edu.javeriana.maria;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.maria.entity.EstudioEntity;
import co.edu.javeriana.maria.entity.EstudioPK;
import co.edu.javeriana.maria.mapper.EstudioMapperImplMySql;
import co.edu.javeriana.maria.mapper.EstudioMapperMySql;
import co.edu.javeriana.maria.repository.EstudioRepositoryMySql;
import co.edu.javeriana.maria.repository.TelefonoRepositoryMySql;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MariaApplicationTests {

	@Autowired
	EstudioRepositoryMySql estudioRepositoryMySql;

	EstudioMapperMySql estudioMapper = new EstudioMapperImplMySql();
	@Test
	void contextLoads() {
//		EstudioPK estudioPK = new EstudioPK(2,1);
//		System.out.println(estudioRepositoryMySql.findByEstudioPK(estudioPK).toString());
//		System.out.println(estudioRepositoryMySql.findByUniver("Javeriana").get(0));
		List<Estudio> estudios = estudioRepositoryMySql.findAll().stream().map(e -> estudioMapper.fromEntityToDomain(e)).collect(Collectors.toList());
		System.out.println(estudios.size());
		System.out.println(estudioRepositoryMySql.count());
	}
	@Test
	void updateEstudio() {
		EstudioPK ep = new EstudioPK(1,1);
		EstudioEntity e = new EstudioEntity(ep,LocalDate.now(),"Piloto");
		estudioRepositoryMySql.save(e);
	}
}
