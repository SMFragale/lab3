package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.maria.entity.ProfesionEntity;

public interface ProfesionMapperMySql {
    public Profesion fromEntityToDomain(ProfesionEntity entity);

    public ProfesionEntity fromDomainToEntity(Profesion domain);
}
