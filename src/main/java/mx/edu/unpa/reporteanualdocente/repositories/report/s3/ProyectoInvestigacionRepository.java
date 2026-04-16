package mx.edu.unpa.reporteanualdocente.repositories.report.s3;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProyectoInvestigacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProyectoInvestigacionRepository extends JpaRepository<ProyectoInvestigacion, Long> {
    List<ProyectoInvestigacion> findByReporteId(Long reporteId);
}