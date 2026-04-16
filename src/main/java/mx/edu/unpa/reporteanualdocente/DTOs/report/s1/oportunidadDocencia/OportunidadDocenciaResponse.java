package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadDocenciaResponse {
    private Long id;
    private Long reporteId;
    private Integer numOportunidad;
    private String textoLibre;
}