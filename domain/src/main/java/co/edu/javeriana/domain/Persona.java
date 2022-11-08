package co.edu.javeriana.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
public class Persona {
    private int cc;
    private String nombre;
    private String apellido;
    private char genero;
    private int edad;
}
