package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request;

import java.time.LocalDate;

public class PublicacionArticuloRequestDTO {

    private Integer reporteId;
    private Integer numPublicacion;
    private String titulo;
    private String revista;
    private String fase;
    private LocalDate fecha;
}