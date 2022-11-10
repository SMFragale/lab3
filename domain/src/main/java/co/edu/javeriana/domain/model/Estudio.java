package co.edu.javeriana.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Estudio {
    private LocalDate fecha;
    private String universidad;
    private Profesion profesion;
    private Persona persona;
}
