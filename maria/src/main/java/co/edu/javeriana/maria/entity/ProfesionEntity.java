package co.edu.javeriana.maria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "profesion")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionEntity {
    @Id
    private Integer id;
    private String nom;
    private String des;
}
