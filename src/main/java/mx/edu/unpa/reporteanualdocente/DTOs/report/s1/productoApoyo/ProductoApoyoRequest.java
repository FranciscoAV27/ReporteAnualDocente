package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoApoyoRequest {
    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numCurso;

    @NotBlank
    private String descripcion;

    private String enlace;
}