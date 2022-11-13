package co.edu.javeriana.rest.requestBody;

import co.edu.javeriana.domain.model.Profesion;
import lombok.Data;

@Data
public class ProfesionRequestBody {
    private Profesion profesion;
    private Integer persistence;
}
