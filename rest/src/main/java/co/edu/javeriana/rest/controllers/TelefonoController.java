package co.edu.javeriana.rest.controllers;

import co.edu.javeriana.domain.logic.TelefonoLogic;
import co.edu.javeriana.domain.model.Telefono;
import co.edu.javeriana.rest.requestBody.TelefonoRequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelefonoController {
    private final TelefonoLogic telefonoLogic;

    public TelefonoController(TelefonoLogic telefonoLogic) {
        this.telefonoLogic = telefonoLogic;
    }

    @GetMapping("/telefonos")
    List<Telefono> getAllTelefonos(@RequestBody Integer persistence) {
        return telefonoLogic.findAll(persistence);
    }

    @GetMapping("/telefonos/{numero}")
    Telefono getTelefonoByNumero(@PathVariable String numero, @RequestBody Integer persistence) {
        return telefonoLogic.findByNum(numero, persistence);
    }

    @GetMapping("/telefonos/count")
    Long getTelefonoCount(@RequestBody Integer persistence) {
        return telefonoLogic.count(persistence);
    }


    @PostMapping("/telefonos/create")
    Boolean createPersona(@RequestBody TelefonoRequestBody telefonoRequestBody) {
        return telefonoLogic.create(telefonoRequestBody.getTelefono(), telefonoRequestBody.getPersistence());
    }

    @PostMapping("/telefonos/update")
    Boolean updateTelefono(@RequestBody TelefonoRequestBody telefonoRequestBody) {
        return telefonoLogic.update(telefonoRequestBody.getTelefono(), telefonoRequestBody.getPersistence());
    }

    @PostMapping("/telefonos/delete")
    Boolean deleteTelefono(@RequestBody TelefonoRequestBody telefonoRequestBody) {
        return telefonoLogic.delete(telefonoRequestBody.getTelefono(), telefonoRequestBody.getPersistence());
    }
}
