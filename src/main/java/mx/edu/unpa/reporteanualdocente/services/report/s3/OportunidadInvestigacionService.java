package mx.edu.unpa.reporteanualdocente.services.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion.OportunidadInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion.OportunidadInvestigacionResponse;

import java.util.List;

public interface OportunidadInvestigacionService {
    // Oportunidades
    OportunidadInvestigacionResponse createOportunidad(OportunidadInvestigacionRequest request);
    OportunidadInvestigacionResponse updateOportunidad(Long id, OportunidadInvestigacionRequest request);
    void deleteOportunidad(Long id);
    OportunidadInvestigacionResponse findOportunidadById(Long id);
    List<OportunidadInvestigacionResponse> findOportunidadesByReporte(Long reporteId);
}
