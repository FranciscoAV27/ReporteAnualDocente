package mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionTesisRequest {

    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numDireccion;

    @NotBlank
    private String titulo;

    @NotBlank
    private String nombreEstudiante;

    @NotBlank
    @Pattern(regexp = "[LM]")
    private String grado;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer porcentajeAvance;

    @NotNull
    @PastOrPresent
    private LocalDate fechaRegistro;

    @NotNull
    private LocalDate fechaTerminacionProg;

    private LocalDate fechaTerminacionReprog;
}