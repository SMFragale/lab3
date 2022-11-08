package co.edu.javeriana.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Estudios {
    private int id_prof;
    private int cc_per;
    private Date fecha;
    private String univer;
}
