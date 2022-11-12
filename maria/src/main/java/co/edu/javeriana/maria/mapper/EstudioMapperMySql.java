package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.maria.entity.EstudioEntity;

public interface EstudioMapperMySql {
    public Estudio fromEntityToDomain(EstudioEntity entity);
    public EstudioEntity fromDomainToEntity(Estudio domain);
}
