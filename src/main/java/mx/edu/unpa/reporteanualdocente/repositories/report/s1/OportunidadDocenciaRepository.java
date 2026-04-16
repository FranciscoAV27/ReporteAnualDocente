package mx.edu.unpa.reporteanualdocente.repositories.report.s1;

import mx.edu.unpa.reporteanualdocente.domains.report.s1.OportunidadDocencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadDocenciaRepository extends JpaRepository<OportunidadDocencia, Long> {
    List<OportunidadDocencia> findByReporteId(Long reporteId);
}
