package co.edu.javeriana.domain.logic;

import co.edu.javeriana.domain.model.Estudio;

import java.util.List;

public interface EstudioLogic {
    Boolean create(Estudio estudio, int persistence);
    Boolean delete(Estudio estudio, int persistence);
    Boolean update(Estudio estudio, int persistence);

    List<Estudio> findAll(int persistence);
    Estudio findByIdCc(Integer cc, Integer id,int persistence);
    Integer count(int persistence);
}
