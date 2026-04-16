package mx.edu.unpa.reporteanualdocente.repositories.report.s3;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.IndicadorProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IndicadorProyectoRepository extends JpaRepository<IndicadorProyecto, Long> {
    List<IndicadorProyecto> findByProyectoId(Long proyectoId);
}