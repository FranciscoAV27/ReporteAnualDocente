package mx.edu.unpa.reporteanualdocente.services.report.s2;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria.TutoriaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria.TutoriaResponse;

import java.util.List;

public interface TutoriaService {
    TutoriaResponse createTutoria(TutoriaRequest request);
    TutoriaResponse updateTutoria(Long id, TutoriaRequest request);
    void deleteTutoria(Long id);
    TutoriaResponse findTutoriaById(Long id);
    List<TutoriaResponse> findTutoriasByReporte(Long reporteId);
}
