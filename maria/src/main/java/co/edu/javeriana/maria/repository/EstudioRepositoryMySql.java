package co.edu.javeriana.maria.repository;

import co.edu.javeriana.maria.entity.EstudioEntity;
import co.edu.javeriana.maria.entity.EstudioPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudioRepositoryMySql extends JpaRepository<EstudioEntity, Integer> {
    List<EstudioEntity> findByEstudioPK(EstudioPK estudioPK);
    List<EstudioEntity> findByUniver(String univer);
}
