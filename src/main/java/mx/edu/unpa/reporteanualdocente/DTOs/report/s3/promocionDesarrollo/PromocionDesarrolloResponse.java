package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDesarrolloResponse {
    private Long id;
    private Long reporteId;
    private Integer numActividad;
    private String actividad;
    private String institucionSolicitante;
    private Integer horasRequeridas;
    private String producto;
}