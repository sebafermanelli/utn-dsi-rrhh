package rrhh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conocimientos")
public class Conocimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_conocimiento")
    private Long codConocimiento;

    @Column(name = "descripcion")
    private String descripcion;

    public Conocimiento() {
    }

    public Conocimiento(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCodConocimiento() {
        return codConocimiento;
    }

    public void setCodConocimiento(Long pCodConocimiento) {
        codConocimiento = pCodConocimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String pDescripcion) {
        descripcion = pDescripcion;
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof Conocimiento other) {
            return other.getCodConocimiento().equals(getCodConocimiento());
        }
        return false;
    }
}
