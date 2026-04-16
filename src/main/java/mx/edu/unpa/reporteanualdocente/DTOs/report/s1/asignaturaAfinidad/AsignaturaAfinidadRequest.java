package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaAfinidadRequest {
    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numAsignatura;

    @NotBlank
    private String carrera;

    @NotBlank
    private String asignatura;

    @NotBlank
    private String semestre;
}