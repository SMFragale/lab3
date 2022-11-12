package co.edu.javeriana.maria.mapper;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.maria.entity.TelefonoEntity;
import org.modelmapper.ModelMapper;

public class TelefonoMapperImplMySql implements TelefonoMapperMySql {
    private ModelMapper mapper;

    public TelefonoMapperImplMySql() {
        mapper = new ModelMapper();
        mapper.typeMap(TelefonoEntity.class, Telefono.class).addMappings(mapping -> {
            mapping.map(TelefonoEntity::getNum, Telefono::setNumero);
            mapping.map(TelefonoEntity::getOper, Telefono::setOperador);
            mapping.map(TelefonoEntity::getDuenio, Telefono::setDuenio);
        });
    }

    @Override
    public Telefono fromEntityToDomain(TelefonoEntity entity) {
        return mapper.map(entity, Telefono.class);
    }

    @Override
    public TelefonoEntity fromDomainToEntity(Telefono domain) {
        return mapper.map(domain, TelefonoEntity.class);
    }
}
