package rrhh.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "candidatos")
public class Candidato {
    @ManyToMany
    @JoinTable(name = "candidatos_conocimientos")
    private final Collection<Conocimiento> conocimientosCandidato = new ArrayList<Conocimiento>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCandidato;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    public Candidato() {
    }

    public Candidato(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public boolean sabe(Collection<Conocimiento> conocimientosBuscados) {
        return conocimientosCandidato.containsAll(conocimientosBuscados);
    }

    public Long getIdCandidato() {
        return idCandidato;
    }

    public String getNombreApellido() {
        return nombre + " " + apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void agregarConocimiento(Conocimiento conocimiento) {
        conocimientosCandidato.add(conocimiento);
    }

    public void agregarConocimientos(Collection<Conocimiento> conocimientos) {
        conocimientosCandidato.addAll(conocimientos);
    }

    public int getCantidadConocimientos() {
        return conocimientosCandidato.size();
    }
}
