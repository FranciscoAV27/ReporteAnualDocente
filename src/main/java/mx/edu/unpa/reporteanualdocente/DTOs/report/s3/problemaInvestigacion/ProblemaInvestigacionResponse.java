package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaInvestigacionResponse {
    private Long id;
    private Long reporteId;
    private Integer numProblema;
    private String textoLibre;
}