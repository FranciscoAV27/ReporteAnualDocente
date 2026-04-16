package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndicadorProyectoRequest {
    @NotNull
    private Long proyectoId;

    @NotNull
    private Integer numIndicador;

    @NotBlank
    private String descripcion;
}