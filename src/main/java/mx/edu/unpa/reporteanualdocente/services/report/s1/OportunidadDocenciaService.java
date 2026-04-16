package mx.edu.unpa.reporteanualdocente.services.report.s1;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia.OportunidadDocenciaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia.OportunidadDocenciaResponse;

import java.util.List;

public interface OportunidadDocenciaService {
    // OportunidadDocencia
    OportunidadDocenciaResponse createOportunidad(OportunidadDocenciaRequest request);
    OportunidadDocenciaResponse updateOportunidad(Long id, OportunidadDocenciaRequest request);
    void deleteOportunidad(Long id);
    OportunidadDocenciaResponse findOportunidadById(Long id);
    List<OportunidadDocenciaResponse> findOportunidadesByReporte(Long reporteId);
}
