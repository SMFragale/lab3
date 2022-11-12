package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.maria.entity.PersonaEntity;

public interface PersonaMapperMySql {
    public Persona fromEntityToDomain(PersonaEntity entity);

    public PersonaEntity fromDomainToEntity(Persona domain);
}
