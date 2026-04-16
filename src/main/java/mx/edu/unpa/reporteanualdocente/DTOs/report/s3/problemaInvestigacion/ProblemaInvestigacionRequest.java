package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaInvestigacionRequest {

    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numProblema;

    @NotBlank
    private String textoLibre;
}