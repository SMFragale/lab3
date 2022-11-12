package co.edu.javeriana.maria.adapter;

import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.domain.ports.out.maria.EstudioPortMaria;
import co.edu.javeriana.maria.entity.EstudioEntity;
import co.edu.javeriana.maria.entity.EstudioPK;
import co.edu.javeriana.maria.mapper.EstudioMapperMySql;
import co.edu.javeriana.maria.repository.EstudioRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EstudioAdapterMySql implements EstudioPortMaria {
    @Autowired
    EstudioRepositoryMySql estudioRepositoryMySql;
    @Autowired
    EstudioMapperMySql estudioMapperMySql;

    @Override
    public Boolean crear(Estudio estudio) {
        try {
            EstudioEntity estudioEntity = estudioMapperMySql.fromDomainToEntity(estudio);
            estudioRepositoryMySql.save(estudioEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(Estudio estudio) {
        try {
            EstudioEntity estudioEntity = estudioMapperMySql.fromDomainToEntity(estudio);
            estudioRepositoryMySql.delete(estudioEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean update(Estudio estudio) {
        try {
            EstudioPK estudioPK = new EstudioPK(estudio.getId_profesion(),estudio.getCc_persona());
            List<EstudioEntity> estudios = estudioRepositoryMySql.findByEstudioPK(estudioPK);
            if(estudios.isEmpty())
                return Boolean.FALSE;
            estudioRepositoryMySql.save(estudioMapperMySql.fromDomainToEntity(estudio));
        }
        catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public List<Estudio> findAll() {
        return estudioRepositoryMySql.findAll().stream().map(e -> estudioMapperMySql.fromEntityToDomain(e)).collect(Collectors.toList());
    }

    @Override
    public Estudio findByIdCcAndId(Integer cc, Integer id) {
        EstudioPK estudioPK = new EstudioPK(id, cc);
        List<EstudioEntity> found = estudioRepositoryMySql.findByEstudioPK(estudioPK);
        if(found.isEmpty())
            return null;
        return estudioMapperMySql.fromEntityToDomain(found.get(0));
    }

    @Override
    public Long count() {
        return estudioRepositoryMySql.count();
    }
}
