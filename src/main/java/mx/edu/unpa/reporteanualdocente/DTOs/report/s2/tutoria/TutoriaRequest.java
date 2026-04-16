package mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutoriaRequest {

    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numTutoria;

    @NotBlank
    private String nombreEstudiante;

    @NotBlank
    private String carreraEstudiante;

    @NotBlank
    private String semestre;

    @NotNull
    @PastOrPresent
    private LocalDate fechaRegistro;
}