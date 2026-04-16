package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoResponse;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoInvestigacionResponse {
    private Long id;
    private Long reporteId;
    private String numProyecto;
    private String titulo;
    private String responsabilidad;
    private String faseAprobacion;
    private String instanciaPrincipal;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private LocalDate fechaReprogramacion;
    private Integer avanceGlobalPorcentaje;
    private List<IndicadorProyectoResponse> indicadores; // opcional
}