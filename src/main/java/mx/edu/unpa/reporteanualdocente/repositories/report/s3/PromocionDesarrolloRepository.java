package mx.edu.unpa.reporteanualdocente.repositories.report.s3;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.PromocionDesarrollo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PromocionDesarrolloRepository extends JpaRepository<PromocionDesarrollo, Long> {
    List<PromocionDesarrollo> findByReporteId(Long reporteId);
}