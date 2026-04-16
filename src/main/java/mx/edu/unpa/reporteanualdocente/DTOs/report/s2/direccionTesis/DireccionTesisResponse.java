package mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionTesisResponse {
    private Long id;
    private Long reporteId;
    private Integer numDireccion;
    private String titulo;
    private String nombreEstudiante;
    private String grado;
    private Integer porcentajeAvance;
    private LocalDate fechaRegistro;
    private LocalDate fechaTerminacionProg;
    private LocalDate fechaTerminacionReprog;
}