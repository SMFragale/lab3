package co.edu.javeriana.maria.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "estudios")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EstudioEntity {
    @EmbeddedId
    private EstudioPK estudioPK;

    private LocalDate fecha;

    private String univer;

    public Integer getEstudioPKCc() {
        return estudioPK.getCc_per();
    }

    public Integer getEstudioPKId() {
        return estudioPK.getId_prof();
    }

    public void setEstudioPKCc(Integer cc_per) {
        this.estudioPK.setCc_per(cc_per);
    }
    public void setEstudioPKId(Integer id_prof) {
        this.estudioPK.setId_prof(id_prof);
    }
}
