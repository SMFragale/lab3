package co.edu.javeriana.maria.repository;

import co.edu.javeriana.maria.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositoryMySql extends JpaRepository<PersonaEntity, String> {
    List<PersonaEntity> findByCc(Integer cc);
}
