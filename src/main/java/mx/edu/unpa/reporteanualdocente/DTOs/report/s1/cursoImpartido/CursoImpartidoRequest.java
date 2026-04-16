package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoImpartidoRequest {
    @NotNull
    private Long reporteId;

    @NotNull
    @Positive
    private Integer numCurso;

    @NotBlank
    private String carrera;

    @NotBlank
    private String asignatura;

    @NotBlank
    private String semestre;

    @NotBlank
    private String cicloEscolar;

    @NotNull
    @Min(1)
    @Max(40)
    private Integer horasSemana;

    @NotNull
    @PositiveOrZero
    private Integer numAlumnos;
}