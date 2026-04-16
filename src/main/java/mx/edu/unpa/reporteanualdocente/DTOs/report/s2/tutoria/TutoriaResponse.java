package mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutoriaResponse {
    private Long id;
    private Long reporteId;
    private Integer numTutoria;
    private String nombreEstudiante;
    private String carreraEstudiante;
    private String semestre;
    private LocalDate fechaRegistro;
}