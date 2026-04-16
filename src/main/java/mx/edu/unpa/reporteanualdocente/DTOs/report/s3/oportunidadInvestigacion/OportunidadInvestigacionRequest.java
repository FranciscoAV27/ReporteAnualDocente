package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadInvestigacionRequest {

    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numOportunidad;

    @NotBlank
    private String textoLibre;
}