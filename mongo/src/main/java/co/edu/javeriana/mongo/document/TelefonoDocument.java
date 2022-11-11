package co.edu.javeriana.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telefono")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoDocument {
    private String num;
    private String oper;
    private Integer duenio;
}
