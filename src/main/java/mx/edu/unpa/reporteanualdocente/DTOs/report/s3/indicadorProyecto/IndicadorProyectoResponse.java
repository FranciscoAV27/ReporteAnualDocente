package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndicadorProyectoResponse {
    private Long id;
    private Long proyectoId;
    private Integer numIndicador;
    private String descripcion;
}