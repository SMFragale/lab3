package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.maria.entity.ProfesionEntity;
import org.modelmapper.ModelMapper;

public class ProfesionMapperImplMySql implements ProfesionMapperMySql {

    private ModelMapper mapper;

    public ProfesionMapperImplMySql() {
        mapper = new ModelMapper();
        mapper.typeMap(ProfesionEntity.class, Profesion.class).addMappings(mapping -> {
            mapping.map(ProfesionEntity::getId, Profesion::setId);
            mapping.map(ProfesionEntity::getNom, Profesion::setNombre);
            mapping.map(ProfesionEntity::getDes, Profesion::setNombre);
        });
    }

    @Override
    public Profesion fromEntityToDomain(ProfesionEntity entity) {
        return mapper.map(entity, Profesion.class);
    }

    @Override
    public ProfesionEntity fromDomainToEntity(Profesion domain) {
        return mapper.map(domain, ProfesionEntity.class);
    }
}
