package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaDocenciaRequest {
    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numProblema;

    @NotBlank
    private String textoLibre;
}