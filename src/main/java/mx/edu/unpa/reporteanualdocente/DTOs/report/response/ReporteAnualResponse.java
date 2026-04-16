package mx.edu.unpa.reporteanualdocente.DTOs.report.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteAnualResponse {
    private Long id;
    private Long profesorId;
    private String profesorNombre;
    private Integer año;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaEnvio;
    private String estado;
    private String comentariosGenerales;
}