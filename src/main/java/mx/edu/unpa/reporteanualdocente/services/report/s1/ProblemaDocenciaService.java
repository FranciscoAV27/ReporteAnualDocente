package mx.edu.unpa.reporteanualdocente.services.report.s1;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia.ProblemaDocenciaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia.ProblemaDocenciaResponse;

import java.util.List;

public interface ProblemaDocenciaService {
    // ProblemaDocencia
    ProblemaDocenciaResponse createProblema(ProblemaDocenciaRequest request);
    ProblemaDocenciaResponse updateProblema(Long id, ProblemaDocenciaRequest request);
    void deleteProblema(Long id);
    ProblemaDocenciaResponse findProblemaById(Long id);
    List<ProblemaDocenciaResponse> findProblemasByReporte(Long reporteId);
}
