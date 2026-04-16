package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadInvestigacionResponse {
    private Long id;
    private Long reporteId;
    private Integer numOportunidad;
    private String textoLibre;
}