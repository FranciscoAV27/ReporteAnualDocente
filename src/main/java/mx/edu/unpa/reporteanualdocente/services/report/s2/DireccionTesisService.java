package mx.edu.unpa.reporteanualdocente.services.report.s2;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis.DireccionTesisRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis.DireccionTesisResponse;

import java.util.List;

public interface DireccionTesisService {
    DireccionTesisResponse createDireccionTesis(DireccionTesisRequest request);
    DireccionTesisResponse updateDireccionTesis(Long id, DireccionTesisRequest request);
    void deleteDireccionTesis(Long id);
    DireccionTesisResponse findDireccionTesisById(Long id);
    List<DireccionTesisResponse> findDireccionesTesisByReporte(Long reporteId);
}
