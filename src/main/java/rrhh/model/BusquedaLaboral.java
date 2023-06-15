package rrhh.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "busqueda_laboral")
public class BusquedaLaboral {
    @ManyToMany
    @JoinTable(name = "busqueda_conocimientos")
    private final Collection<Conocimiento> conocimientosBuscados = new ArrayList<Conocimiento>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_busqueda_laboral")
    private final Collection<Entrevista> entrevistas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idBusquedaLaboral;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;

    public BusquedaLaboral() {
        estado = "activo";
        entrevistas = new ArrayList<Entrevista>();
    }

    public BusquedaLaboral(String descripcion) {
        this();
        this.descripcion = descripcion;
    }

    public Long getIdBusquedaLaboral() {
        return idBusquedaLaboral;
    }

    public Collection<Conocimiento> getConocimientosBuscados() {
        return conocimientosBuscados;
    }

    public void agregarEntrevista(Candidato c, Date fechaHoraEntrevista) {
        Entrevista e = new Entrevista(c, this, fechaHoraEntrevista);
        entrevistas.add(e);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void agregarConocimiento(Conocimiento conocimiento) {
        conocimientosBuscados.add(conocimiento);
    }

    public void desactivar() {
        estado = "inactivo";
    }
}
