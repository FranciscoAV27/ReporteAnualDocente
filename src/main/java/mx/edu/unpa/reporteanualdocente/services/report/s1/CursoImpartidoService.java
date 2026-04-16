package mx.edu.unpa.reporteanualdocente.services.report.s1;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido.CursoImpartidoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido.CursoImpartidoResponse;

import java.util.List;

public interface CursoImpartidoService {
    // CursoImpartido
    CursoImpartidoResponse createCurso(CursoImpartidoRequest request);
    CursoImpartidoResponse updateCurso(Long id, CursoImpartidoRequest request);
    void deleteCurso(Long id);
    CursoImpartidoResponse findCursoById(Long id);
    List<CursoImpartidoResponse> findCursosByReporte(Long reporteId);
}
