package mx.edu.unpa.reporteanualdocente.services.report;

import mx.edu.unpa.reporteanualdocente.DTOs.report.request.ReporteAnualRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.response.ReporteAnualResponse;

import java.util.List;

public interface ReporteAnualService {
    ReporteAnualResponse create(ReporteAnualRequest request);
    ReporteAnualResponse update(Long id, ReporteAnualRequest request);
    void delete(Long id);
    ReporteAnualResponse findById(Long id);
    List<ReporteAnualResponse> findByProfesorId(Long profesorId);
}