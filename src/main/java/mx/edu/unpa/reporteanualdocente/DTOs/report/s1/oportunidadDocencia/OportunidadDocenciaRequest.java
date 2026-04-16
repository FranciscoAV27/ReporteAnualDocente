package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadDocenciaRequest {
    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numOportunidad;

    @NotBlank
    private String textoLibre;
}