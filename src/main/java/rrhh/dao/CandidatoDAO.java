package rrhh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rrhh.model.Candidato;
import rrhh.model.Conocimiento;

import java.util.Collection;

@Repository
public interface CandidatoDAO extends JpaRepository<Candidato, Long> {

    @Query("SELECT DISTINCT c FROM Candidato c INNER JOIN c.conocimientosCandidato co WHERE co IN ?1 ORDER by c.apellido")
    Collection<Candidato> buscarPorConocimientos(Collection<Conocimiento> conocimientosBuscados);
}
