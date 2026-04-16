package mx.edu.unpa.reporteanualdocente.repositories.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TutoriaRepository extends JpaRepository<Tutoria, Long> {
    List<Tutoria> findByReporteId(Long reporteId);
}