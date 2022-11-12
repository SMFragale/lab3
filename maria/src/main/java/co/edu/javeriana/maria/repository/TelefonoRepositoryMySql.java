package co.edu.javeriana.maria.repository;

import co.edu.javeriana.maria.entity.TelefonoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepositoryMySql extends JpaRepository<TelefonoEntity, String> {
    TelefonoEntity findByNum(String num);
}
