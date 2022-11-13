package co.edu.javeriana.rest.controllers;

import co.edu.javeriana.domain.logic.EstudioLogic;
import co.edu.javeriana.domain.model.Estudio;
import co.edu.javeriana.rest.requestBody.EstudioRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudioController {

    private final EstudioLogic estudioLogic;

    public EstudioController(EstudioLogic logic) {
        estudioLogic = logic;
    }

    @GetMapping("/estudios")
    List<Estudio> getAllEstudios(@RequestBody Integer persistence) {
        return estudioLogic.findAll(persistence);
    }

    @GetMapping("/estudios/{cc_persona}/{id_profesion}")
    Estudio getEstudioByCcId(@PathVariable Integer cc_persona, @PathVariable Integer id_profesion, @RequestBody Integer persistence) {
        return estudioLogic.findByIdCc(cc_persona, id_profesion, persistence);
    }

    @GetMapping("/estudios/count")
    Long getEstudioCount(@RequestBody Integer persistence) {
        return estudioLogic.count(persistence);
    }

    @PostMapping("/estudios/create")
    Boolean createEstudio(@RequestBody EstudioRequestBody estudioRequestBody) {
        return estudioLogic.create(estudioRequestBody.getEstudio(), estudioRequestBody.getPersistence());
    }

    @PostMapping("/estudios/update")
    Boolean updateEstudio(@RequestBody EstudioRequestBody estudioRequestBody) {
        return estudioLogic.update(estudioRequestBody.getEstudio(), estudioRequestBody.getPersistence());
    }

    @PostMapping("/estudios/delete")
    Boolean deleteEstudio(@RequestBody EstudioRequestBody estudioRequestBody) {
        return estudioLogic.delete(estudioRequestBody.getEstudio(), estudioRequestBody.getPersistence());
    }

}
