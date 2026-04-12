package mx.edu.unpa.reporteanualdocente.repositories.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutoriaRepository extends JpaRepository<Tutoria, Integer> {
    List<Tutoria> findByReporteId(Integer reporteId);
}
