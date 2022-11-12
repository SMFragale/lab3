package co.edu.javeriana.maria.adapter;

import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.domain.ports.out.maria.ProfesionPortMaria;
import co.edu.javeriana.maria.entity.ProfesionEntity;
import co.edu.javeriana.maria.mapper.ProfesionMapperMySql;
import co.edu.javeriana.maria.repository.ProfesionRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProfesionAdapterMySql implements ProfesionPortMaria {
    @Autowired
    ProfesionRepositoryMySql profesionRepositoryMySql;

    @Autowired
    ProfesionMapperMySql profesionMapperMySql;
    @Override
    public Boolean crear(Profesion profesion) {
        try {
            ProfesionEntity profesionDocument = profesionMapperMySql.fromDomainToEntity(profesion);
            profesionRepositoryMySql.save(profesionDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(Profesion profesion) {
        try {
            ProfesionEntity profesionDocument = profesionMapperMySql.fromDomainToEntity(profesion);
            profesionRepositoryMySql.delete(profesionDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean update(Profesion profesion) {
        try {
            ProfesionEntity profesionDocument = profesionRepositoryMySql.findById(profesion.getId());
            if(profesionDocument == null)
                return false;

            profesionRepositoryMySql.save(profesionMapperMySql.fromDomainToEntity(profesion));
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }    }

    @Override
    public List<Profesion> findAll() {
        return profesionRepositoryMySql.findAll().stream().map(e -> profesionMapperMySql.fromEntityToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Profesion findById(Integer id) {
        return profesionMapperMySql.fromEntityToDomain(profesionRepositoryMySql.findById(id));
    }

    @Override
    public Long count() {
        return profesionRepositoryMySql.count();
    }
}
