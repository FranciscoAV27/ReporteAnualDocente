package mx.edu.unpa.reporteanualdocente.repositories.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.DireccionTesis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionTesisRepository extends JpaRepository<DireccionTesis, Integer> {
    List<DireccionTesis> findByReporteId(Integer reporteId);
}