package mx.edu.unpa.reporteanualdocente.repositories.report.s1;

import mx.edu.unpa.reporteanualdocente.domains.report.s1.CursoImpartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoImpartidoRepository extends JpaRepository<CursoImpartido, Long> {
    List<CursoImpartido> findByReporteId(Long reporteId);
}