package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.maria.entity.PersonaEntity;
import org.modelmapper.ModelMapper;

public class PersonaMapperImplMysql implements PersonaMapperMySql{

    private ModelMapper mapper;

    public PersonaMapperImplMysql() {
        mapper = new ModelMapper();
        mapper.typeMap(PersonaEntity.class, Persona.class).addMappings(mapping -> {
            mapping.map(PersonaEntity::getCc, Persona::setCc);
            mapping.map(PersonaEntity::getNombre, Persona::setNombre);
            mapping.map(PersonaEntity::getApellido, Persona::setApellido);
            mapping.map(PersonaEntity::getGenero, Persona::setGenero);
            mapping.map(PersonaEntity::getEdad, Persona::setEdad);
        });
    }

    @Override
    public Persona fromEntityToDomain(PersonaEntity entity) {
        return mapper.map(entity, Persona.class);
    }

    @Override
    public PersonaEntity fromDomainToEntity(Persona domain) {
        return mapper.map(domain, PersonaEntity.class);
    }
}
