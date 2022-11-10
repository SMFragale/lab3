package co.edu.javeriana.domain.logic.impl;

import co.edu.javeriana.domain.logic.EstudioLogic;
import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.domain.ports.out.maria.EstudioPortMaria;
import co.edu.javeriana.domain.ports.out.maria.PersonaPortMaria;
import co.edu.javeriana.domain.ports.out.mongo.EstudioPortMongo;
import co.edu.javeriana.domain.ports.out.mongo.PersonaPortMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EstudioLogicImpl implements EstudioLogic {
    @Autowired
    private EstudioPortMaria estudioPortMaria;

    @Autowired
    private EstudioPortMongo estudioPortMongo;

    @Override
    public Boolean create(Estudio estudio, int persistence) {
        if (persistence == 1){
            return estudioPortMaria.crear(estudio);
        }
        else if (persistence == 2) {
            return estudioPortMongo.crear(estudio);
        }
        else {
            return estudioPortMaria.crear(estudio) && estudioPortMongo.crear(estudio);
        }
    }

    @Override
    public Boolean delete(Estudio estudio, int persistence) {
        if (persistence == 1){
            return estudioPortMaria.delete(estudio);
        }
        else if (persistence == 2) {
            return estudioPortMongo.delete(estudio);
        }
        else {
            return estudioPortMaria.delete(estudio) && estudioPortMongo.delete(estudio);
        }
    }

    @Override
    public Boolean update(Estudio estudio, int persistence) {
        if (persistence == 1){
            return estudioPortMaria.update(estudio);
        }
        else if (persistence == 2) {
            return estudioPortMongo.update(estudio);
        }
        else {
            return estudioPortMaria.update(estudio) && estudioPortMongo.update(estudio);
        }
    }

    @Override
    public List<Estudio> findAll(int persistence) {
        if (persistence == 1){
            return estudioPortMaria.findAll();
        }
        else if (persistence == 2) {
            return estudioPortMaria.findAll();
        }
        else {
            List<Estudio> list = new ArrayList<>();
            list.addAll(estudioPortMaria.findAll());
            list.addAll(estudioPortMongo.findAll());
            return list;
        }
    }

    @Override
    public Estudio findByIdCc(Integer cc, Integer id, int persistence) {
        if (persistence == 1){
            return estudioPortMaria.findByIdCc(cc, id);
        }
        else if (persistence == 2) {
            return estudioPortMongo.findByIdCc(cc, id);
        }
        else {
//            return estudioPortMaria.findByIdCc(cc, id) && estudioPortMongo.findByIdCc(cc, id);
        }
        return null;
    }

    @Override
    public Integer count(int persistence) {
        if (persistence == 1){
            return estudioPortMaria.count();
        }
        else if (persistence == 2) {
            return estudioPortMongo.count();
        }
        else {
            return estudioPortMaria.count() + estudioPortMongo.count();
        }
    }
}