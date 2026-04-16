package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaDocenciaResponse {
    private Long id;
    private Long reporteId;
    private Integer numProblema;
    private String textoLibre;
}