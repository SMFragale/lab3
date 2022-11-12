package co.edu.javeriana.maria.repository;

import co.edu.javeriana.maria.entity.ProfesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesionRepositoryMySql extends JpaRepository<ProfesionEntity, String> {
    ProfesionEntity findById(Integer id);
}
