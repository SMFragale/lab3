package co.edu.javeriana.maria.adapter;

import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.domain.ports.out.maria.PersonaPortMaria;
import co.edu.javeriana.maria.entity.PersonaEntity;
import co.edu.javeriana.maria.mapper.PersonaMapperMySql;
import co.edu.javeriana.maria.repository.PersonaRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaAdapterMySql implements PersonaPortMaria {

    @Autowired
    PersonaRepositoryMySql personaRepositoryMySql;

    @Autowired
    PersonaMapperMySql personaMapperMySql;

    @Override
    public Boolean crear(Persona persona) {
        try {
            PersonaEntity personaEntity = personaMapperMySql.fromDomainToEntity(persona);
            personaRepositoryMySql.save(personaEntity);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Persona persona) {
        try {
            PersonaEntity personaEntity = personaMapperMySql.fromDomainToEntity(persona);
            personaRepositoryMySql.delete(personaEntity);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Persona persona) {
        try {
            List<PersonaEntity> personas = personaRepositoryMySql.findByCc(persona.getCc());
            if(personas.isEmpty())
                return Boolean.FALSE;
            personaRepositoryMySql.save(personaMapperMySql.fromDomainToEntity(persona));
        }
        catch (Exception e) {
            return Boolean.FALSE;
        }
        return null;    }

    @Override
    public List<Persona> findAll() {
        return personaRepositoryMySql.findAll().stream().map(e -> personaMapperMySql.fromEntityToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Persona findByCC(Integer cc) {
        List<PersonaEntity> found = personaRepositoryMySql.findByCc(cc);
        if(found.isEmpty())
            return null;
        return personaMapperMySql.fromEntityToDomain(found.get(0));
    }

    @Override
    public Long count() {
        return  personaRepositoryMySql.count();
    }
}
