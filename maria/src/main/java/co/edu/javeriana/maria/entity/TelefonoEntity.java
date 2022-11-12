package co.edu.javeriana.maria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "telefono")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoEntity {
    private String num;
    private String oper;
    @Id
    private Integer duenio;
}
