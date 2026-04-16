package mx.edu.unpa.reporteanualdocente.domains.report.s2;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "tutorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_tutoria", nullable = false)
    private Integer numTutoria;

    @NotBlank
    @Column(name = "nombre_estudiante", nullable = false, length = 150)
    private String nombreEstudiante;

    @NotBlank
    @Column(name = "carrera_estudiante", nullable = false, length = 100)
    private String carreraEstudiante;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String semestre;

    @NotNull
    @PastOrPresent
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;
}