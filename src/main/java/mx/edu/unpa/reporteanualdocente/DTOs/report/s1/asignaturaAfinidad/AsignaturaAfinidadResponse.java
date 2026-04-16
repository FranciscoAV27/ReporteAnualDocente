package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaAfinidadResponse {
    private Long id;
    private Long reporteId;
    private Integer numAsignatura;
    private String carrera;
    private String asignatura;
    private String semestre;
}