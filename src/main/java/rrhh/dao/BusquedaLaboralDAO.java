package rrhh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rrhh.model.BusquedaLaboral;

import java.util.Collection;

@Repository
public interface BusquedaLaboralDAO extends JpaRepository<BusquedaLaboral, Long> {

    @Query("SELECT b FROM BusquedaLaboral b WHERE b.estado = 'activo'")
    Collection<BusquedaLaboral> buscarBusquedasActivas();
}
