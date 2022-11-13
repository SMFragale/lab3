package co.edu.javeriana.rest.requestBody;

import co.edu.javeriana.domain.model.Telefono;
import lombok.Data;

@Data
public class TelefonoRequestBody {
    private Telefono telefono;
    private Integer persistence;
}
