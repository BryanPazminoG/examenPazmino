package ec.edu.espe.examen.Pazmino.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Embeddable
public class DocenteMateriaPK implements Serializable {

    @Column(name = "COD_DOCENTE")
    private Integer codigoDocente;
    @Column(name = "COD_MATERIA")
    private Integer codigoMateria;

    @ManyToOne
    @JoinColumn(name = "COD_DOCENTE", referencedColumnName = "COD_DOCENTE", insertable = false, updatable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "COD_MATERIA", referencedColumnName = "COD_MATERIA", insertable = false, updatable = false)
    private Materia materia;
    
    public DocenteMateriaPK(Integer codigoDocente, Integer codigoMateria) {
        this.codigoDocente = codigoDocente;
        this.codigoMateria = codigoMateria;
    }

    @Override
    public String toString() {
        return "DocenteMateriaPK [codigoDocente=" + codigoDocente + ", codigoMateria=" + codigoMateria + "]";
    }

}
