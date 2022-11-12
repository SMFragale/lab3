package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.maria.entity.TelefonoEntity;

public interface TelefonoMapperMySql {
    public Telefono fromEntityToDomain(TelefonoEntity entity);

    public TelefonoEntity fromDomainToEntity(Telefono domain);
}
