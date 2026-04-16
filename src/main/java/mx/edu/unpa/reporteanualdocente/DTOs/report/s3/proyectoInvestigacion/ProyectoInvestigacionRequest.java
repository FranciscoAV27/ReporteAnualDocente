package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoInvestigacionRequest {

    @NotNull
    private Long reporteId;

    @NotBlank
    private String numProyecto;

    @NotBlank
    private String titulo;

    @NotBlank
    @Pattern(regexp = "[DCO]")
    private String responsabilidad;

    @NotBlank
    @Pattern(regexp = "PEU|PEE")
    private String faseAprobacion;

    @NotBlank
    @Pattern(regexp = "[CPO]")
    private String instanciaPrincipal;

    @NotNull
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaTerminacion;

    private LocalDate fechaReprogramacion;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer avanceGlobalPorcentaje;
}