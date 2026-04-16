package mx.edu.unpa.reporteanualdocente.repositories.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s2.DireccionTesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DireccionTesisRepository extends JpaRepository<DireccionTesis, Long> {
    List<DireccionTesis> findByReporteId(Long reporteId);
}