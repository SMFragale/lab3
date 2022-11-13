package co.edu.javeriana.rest.controllers;

import co.edu.javeriana.domain.logic.PersonaLogic;
import co.edu.javeriana.domain.model.Persona;
import co.edu.javeriana.rest.requestBody.PersonaRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    private final PersonaLogic personaLogic;

    public PersonaController(PersonaLogic personaLogic) {
        this.personaLogic = personaLogic;
    }

    @GetMapping("/personas")
    List<Persona> getAllPersonas(@RequestBody Integer persistence) {
        return personaLogic.findAll(persistence);
    }

    @GetMapping("/personas/{cc_persona}")
    Persona getEstudioByCcId(@PathVariable Integer cc_persona, @RequestBody Integer persistence) {
        return personaLogic.findByCC(cc_persona, persistence);
    }

    @GetMapping("/personas/count")
    Long getPersonaCount(@RequestBody Integer persistence) {
        return personaLogic.count(persistence);
    }


    @PostMapping("/personas/create")
    Boolean createPersona(@RequestBody PersonaRequestBody personaRequestBody) {
        return personaLogic.create(personaRequestBody.getPersona(), personaRequestBody.getPersistence());
    }

    @PostMapping("/personas/update")
    Boolean updatePersona(@RequestBody PersonaRequestBody personaRequestBody) {
        return personaLogic.update(personaRequestBody.getPersona(), personaRequestBody.getPersistence());
    }

    @PostMapping("/personas/delete")
    Boolean deletePersona(@RequestBody PersonaRequestBody personaRequestBody) {
        return personaLogic.delete(personaRequestBody.getPersona(), personaRequestBody.getPersistence());
    }
}
