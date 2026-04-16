package mx.edu.unpa.reporteanualdocente.services.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion.ProblemaInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion.ProblemaInvestigacionResponse;

import java.util.List;

public interface ProblemaInvestigacionService {
    // Problemas
    ProblemaInvestigacionResponse createProblema(ProblemaInvestigacionRequest request);
    ProblemaInvestigacionResponse updateProblema(Long id, ProblemaInvestigacionRequest request);
    void deleteProblema(Long id);
    ProblemaInvestigacionResponse findProblemaById(Long id);
    List<ProblemaInvestigacionResponse> findProblemasByReporte(Long reporteId);
}
