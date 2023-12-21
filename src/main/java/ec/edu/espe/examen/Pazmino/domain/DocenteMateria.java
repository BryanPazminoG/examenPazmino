package ec.edu.espe.examen.Pazmino.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name="DOCENTE_MATERIA")
public class DocenteMateria {

    @EmbeddedId
    private DocenteMateriaPK pK;

    @Column(name = "PERIODO", nullable = false, length = 10)
    private String periodo;

    @Column(name = "ALUMNOS_MATRICULADOS", nullable = false, length = 2)
    private Integer alumnosMatriculados;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "PROMEDIO_CURSO", nullable = false, precision = 4, scale = 2)
    private BigDecimal promedioCurso;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)    
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaCreacion;

    public DocenteMateria(DocenteMateriaPK pK) {
        this.pK = pK;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pK == null) ? 0 : pK.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocenteMateria other = (DocenteMateria) obj;
        if (pK == null) {
            if (other.pK != null)
                return false;
        } else if (!pK.equals(other.pK))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DocenteMateria [pK=" + pK + ", periodo=" + periodo + ", alumnosMatriculados=" + alumnosMatriculados
                + ", estado=" + estado + ", promedioCurso=" + promedioCurso + ", fechaCreacion=" + fechaCreacion + "]";
    }

    


}
