package mx.edu.unpa.reporteanualdocente.services.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion.ProyectoInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion.ProyectoInvestigacionResponse;

import java.util.List;

public interface ProyectoInvestigacionService {
    ProyectoInvestigacionResponse createProyecto(ProyectoInvestigacionRequest request);
    ProyectoInvestigacionResponse updateProyecto(Long id, ProyectoInvestigacionRequest request);
    void deleteProyecto(Long id);
    ProyectoInvestigacionResponse findProyectoById(Long id);
    List<ProyectoInvestigacionResponse> findProyectosByReporte(Long reporteId);
}