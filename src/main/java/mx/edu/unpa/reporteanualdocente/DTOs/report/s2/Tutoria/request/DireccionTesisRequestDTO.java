package mx.edu.unpa.reporteanualdocente.DTOs.report.s2.Tutoria.request;

import java.time.LocalDate;

public class DireccionTesisRequestDTO {

    private Integer reporteId;
    private Integer numDireccion;
    private String titulo;
    private String nombreEstudiante;
    private String grado;
    private Integer porcentajeAvance;
    private LocalDate fechaRegistro;
    private LocalDate fechaTerminacionProg;
    private LocalDate fechaTerminacionReprog;
}