package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request;

import java.time.LocalDate;

public class ProyectoInvestigacionRequestDTO {

    private Integer reporteId;
    private String numProyecto;
    private String titulo;
    private String responsabilidad;
    private String faseAprobacion;
    private String instanciaPrincipal;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private LocalDate fechaReprogramacion;
    private Integer avanceGlobalPorcentaje;
}
