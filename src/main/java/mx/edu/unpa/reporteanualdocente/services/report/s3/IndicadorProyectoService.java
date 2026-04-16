package mx.edu.unpa.reporteanualdocente.services.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoResponse;

import java.util.List;

public interface IndicadorProyectoService {
    // Indicadores de proyecto
    IndicadorProyectoResponse createIndicador(IndicadorProyectoRequest request);
    IndicadorProyectoResponse updateIndicador(Long id, IndicadorProyectoRequest request);
    void deleteIndicador(Long id);
    IndicadorProyectoResponse findIndicadorById(Long id);
    List<IndicadorProyectoResponse> findIndicadoresByProyecto(Long proyectoId);
}