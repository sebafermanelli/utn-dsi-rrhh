package rrhh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rrhh.model.Entrevista;

import java.util.Collection;
import java.util.Date;

@Repository
public interface EntrevistaDAO extends JpaRepository<Entrevista, Long> {

    @Query("SELECT e FROM Entrevista e WHERE e.estado='confirmado' AND e.fechaEntrevista >= ?1 ORDER by e.fechaEntrevista")
    Collection<Entrevista> buscarEntrevistasPorFecha(Date fechaDesde);
}
