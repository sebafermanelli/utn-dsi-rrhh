package rrhh.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entrevistas")
public class Entrevista {
    @Column(name = "puntaje_evaluacion")
    private final Double puntajeEvaluacion = null;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "id_candidato")
    private Candidato candidato;
    @ManyToOne
    private BusquedaLaboral busquedaLaboral;
    @Column(name = "fecha_entrevista")
    private Date fechaEntrevista;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "estado")
    private String estado;

    public Entrevista() {
    }

    public Entrevista(Candidato candidato, BusquedaLaboral busquedaLaboral, Date fechaEntrevista) {
        this.candidato = candidato;
        this.busquedaLaboral = busquedaLaboral;
        this.fechaEntrevista = fechaEntrevista;
        fechaCreacion = new Date();
        estado = "confirmado";
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public BusquedaLaboral getBusquedaLaboral() {
        return busquedaLaboral;
    }

    public Date getFechaEntrevista() {
        return fechaEntrevista;
    }
}
