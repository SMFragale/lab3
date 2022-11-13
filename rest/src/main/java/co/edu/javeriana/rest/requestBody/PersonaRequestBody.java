package co.edu.javeriana.rest.requestBody;

import co.edu.javeriana.domain.model.Persona;
import lombok.Data;

@Data
public class PersonaRequestBody {
    private Persona persona;
    private Integer persistence;
}
