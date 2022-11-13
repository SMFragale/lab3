package co.edu.javeriana.rest.controllers;


import co.edu.javeriana.domain.logic.ProfesionLogic;
import co.edu.javeriana.domain.model.Profesion;
import co.edu.javeriana.rest.requestBody.ProfesionRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesionController {
    private final ProfesionLogic profesionLogic;

    public ProfesionController(ProfesionLogic profesionLogic) {
        this.profesionLogic = profesionLogic;
    }

    @GetMapping("/profesiones")
    List<Profesion> getAllProfesiones(@RequestBody Integer persistence) {
        return profesionLogic.findAll(persistence);
    }

    @GetMapping("/profesiones/{id_profesion}")
    Profesion getProfesionById(@PathVariable Integer id_profesion, @RequestBody Integer persistence) {
        return profesionLogic.findById(id_profesion, persistence);
    }

    @GetMapping("/profesiones/count")
    Long getProfesionesCount(@RequestBody Integer persistence) {
        return profesionLogic.count(persistence);
    }


    @PostMapping("/profesiones/create")
    Boolean createProfesion(@RequestBody ProfesionRequestBody profesionRequestBody) {
        return profesionLogic.create(profesionRequestBody.getProfesion(), profesionRequestBody.getPersistence());
    }

    @PostMapping("/profesiones/update")
    Boolean updateProfesion(@RequestBody ProfesionRequestBody profesionRequestBody) {
        return profesionLogic.update(profesionRequestBody.getProfesion(), profesionRequestBody.getPersistence());
    }

    @PostMapping("/profesiones/delete")
    Boolean deleteProfesion(@RequestBody ProfesionRequestBody profesionRequestBody) {
        return profesionLogic.delete(profesionRequestBody.getProfesion(), profesionRequestBody.getPersistence());
    }
}
