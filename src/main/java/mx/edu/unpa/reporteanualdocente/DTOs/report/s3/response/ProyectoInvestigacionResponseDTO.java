package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response;

import java.time.LocalDate;

public class ProyectoInvestigacionResponseDTO {

    private Integer id;
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
