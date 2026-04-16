package mx.edu.unpa.reporteanualdocente.repositories.report;

import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReporteAnualRepository extends JpaRepository<ReporteAnual, Long> {
    List<ReporteAnual> findByProfesorId(Long profesorId);
    Optional<ReporteAnual> findByProfesorIdAndAño(Long profesorId, Integer año);
}
