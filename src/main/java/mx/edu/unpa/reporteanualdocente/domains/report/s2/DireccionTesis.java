package mx.edu.unpa.reporteanualdocente.domains.report.s2;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "direcciones_tesis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionTesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_direccion", nullable = false)
    private Integer numDireccion;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotBlank
    @Column(name = "nombre_estudiante", nullable = false, length = 150)
    private String nombreEstudiante;

    @NotBlank
    @Pattern(regexp = "[LM]", message = "El grado debe ser L (Licenciatura) o M (Maestría)")
    @Column(nullable = false, length = 1)
    private String grado;

    @NotNull
    @Min(0)
    @Max(100)
    @Column(name = "porcentaje_avance", nullable = false)
    private Integer porcentajeAvance;

    @NotNull
    @PastOrPresent
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @NotNull
    @Column(name = "fecha_terminacion_prog", nullable = false)
    private LocalDate fechaTerminacionProg;

    @Column(name = "fecha_terminacion_reprog")
    private LocalDate fechaTerminacionReprog;
}