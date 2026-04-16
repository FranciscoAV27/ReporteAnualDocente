package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoApoyoResponse {
    private Long id;
    private Long reporteId;
    private Integer numCurso;
    private String descripcion;
    private String enlace;
}