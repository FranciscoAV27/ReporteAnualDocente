package mx.edu.unpa.reporteanualdocente.repositories.report.s3;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.OportunidadInvestigacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OportunidadInvestigacionRepository extends JpaRepository<OportunidadInvestigacion, Long> {
    List<OportunidadInvestigacion> findByReporteId(Long reporteId);
}