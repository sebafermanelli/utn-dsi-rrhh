package rrhh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rrhh.model.Conocimiento;

@Repository
public interface ConocimientoDAO extends JpaRepository<Conocimiento, Long> {
}
