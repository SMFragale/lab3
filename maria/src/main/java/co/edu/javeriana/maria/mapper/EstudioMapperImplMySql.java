package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.maria.entity.EstudioEntity;
import co.edu.javeriana.maria.entity.EstudioPK;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EstudioMapperImplMySql implements EstudioMapperMySql{
    private ModelMapper mapper;

    public EstudioMapperImplMySql() {
        mapper = new ModelMapper();
        mapper.typeMap(EstudioEntity.class, Estudio.class).addMappings(mapping -> {
            mapping.map(EstudioEntity::getUniver, Estudio::setUniversidad);
            mapping.map(EstudioEntity::getEstudioPKCc, Estudio::setCc_persona);
            mapping.map(EstudioEntity::getEstudioPKId, Estudio::setId_profesion);
            mapping.map(EstudioEntity::getFecha, Estudio::setFecha);
        });
    }

    @Override
    public Estudio fromEntityToDomain(EstudioEntity entity) {
        return mapper.map(entity, Estudio.class);
    }

    @Override
    public EstudioEntity fromDomainToEntity(Estudio domain) {
        return mapper.map(domain, EstudioEntity.class);    }
}
