package mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoImpartidoResponse {
    private Long id;
    private Long reporteId;
    private Integer numCurso;
    private String carrera;
    private String asignatura;
    private String semestre;
    private String cicloEscolar;
    private Integer horasSemana;
    private Integer numAlumnos;
}