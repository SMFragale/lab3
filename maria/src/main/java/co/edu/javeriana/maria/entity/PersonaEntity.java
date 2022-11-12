package co.edu.javeriana.maria.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "persona")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {
    @Id
    private Integer cc;
    private String nombre;
    private String apellido;
    private Character genero;
    private Integer edad;
}
