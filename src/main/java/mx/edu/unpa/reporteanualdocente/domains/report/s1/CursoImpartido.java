package mx.edu.unpa.reporteanualdocente.domains.report.s1;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "cursos_impartidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoImpartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @Column(name = "num_curso", nullable = false)
    private Integer numCurso;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String carrera;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String asignatura;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String semestre;

    @NotBlank
    @Column(name = "ciclo_escolar", nullable = false, length = 20)
    private String cicloEscolar;

    @NotNull
    @Positive
    @Column(name = "horas_semana", nullable = false)
    private Integer horasSemana;

    @NotNull
    @PositiveOrZero
    @Column(name = "num_alumnos", nullable = false)
    private Integer numAlumnos;
}
