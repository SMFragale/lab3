package co.edu.javeriana.maria.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EstudioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prof", nullable = false)
    private Integer id_prof;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cc_per", nullable = false)
    private Integer cc_per;
}
