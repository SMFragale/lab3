package co.edu.javeriana.rest.requestBody;

import co.edu.javeriana.domain.model.Estudio;
import lombok.Data;

@Data
public class EstudioRequestBody {
    Estudio estudio;
    Integer persistence;
}
