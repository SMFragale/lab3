package co.edu.javeriana.maria.adapter;

import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.domain.ports.out.maria.TelefonoPortMaria;
import co.edu.javeriana.maria.entity.TelefonoEntity;
import co.edu.javeriana.maria.mapper.TelefonoMapperMySql;
import co.edu.javeriana.maria.repository.TelefonoRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TelefonoAdapterMySql implements TelefonoPortMaria {
    @Autowired
    TelefonoRepositoryMySql telefonoRepositoryMySql;

    @Autowired
    TelefonoMapperMySql telefonoMapperMySql;

    @Override
    public Boolean crear(Telefono telefono) {
        try {
            TelefonoEntity telefonoDocument = telefonoMapperMySql.fromDomainToEntity(telefono);
            telefonoRepositoryMySql.save(telefonoDocument);
            return true;
        }
        catch (Exception e) {
            return false;
        }    }

    @Override
    public Boolean delete(Telefono telefono) {
        try {
            TelefonoEntity telefonoDocument = telefonoMapperMySql.fromDomainToEntity(telefono);
            telefonoRepositoryMySql.delete(telefonoDocument);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Telefono telefono) {
        try{
            TelefonoEntity telefonoDocument = telefonoRepositoryMySql.findByNum(telefono.getNumero());
            if(telefonoDocument == null)
                return false;

            telefonoRepositoryMySql.save(telefonoMapperMySql.fromDomainToEntity(telefono));
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Telefono> findAll() {
        return telefonoRepositoryMySql.findAll().stream().map(e -> telefonoMapperMySql.fromEntityToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Telefono findByNum(String num) {
        return telefonoMapperMySql.fromEntityToDomain(telefonoRepositoryMySql.findByNum(num));
    }

    @Override
    public Long count() {
        return telefonoRepositoryMySql.count();
    }
}
