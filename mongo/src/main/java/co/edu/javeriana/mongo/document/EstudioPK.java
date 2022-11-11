package co.edu.javeriana.mongo.document;

import lombok.Data;

@Data
public class EstudioPK {
    private Integer id_prof;
    private Integer cc_per;

    public EstudioPK(Integer id_prof, Integer cc_per) {
        this.id_prof = id_prof;
        this.cc_per = cc_per;
    }
}
