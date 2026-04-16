package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proyectos_investigacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotBlank
    @Column(name = "num_proyecto", nullable = false, length = 20)
    private String numProyecto;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotBlank
    @Pattern(regexp = "[DCO]", message = "Responsabilidad debe ser D (Director), C (Colaborador) o O (Otro)")
    @Column(nullable = false, length = 1)
    private String responsabilidad;

    @NotBlank
    @Pattern(regexp = "PEU|PEE", message = "Fase de aprobación debe ser PEU o PEE")
    @Column(name = "fase_aprobacion", nullable = false, length = 3)
    private String faseAprobacion;

    @NotBlank
    @Pattern(regexp = "[CPO]", message = "Instancia principal debe ser C (CONACYT), P (PROMEP) o O (Otra)")
    @Column(name = "instancia_principal", nullable = false, length = 1)
    private String instanciaPrincipal;

    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "fecha_terminacion", nullable = false)
    private LocalDate fechaTerminacion;

    @Column(name = "fecha_reprogramacion")
    private LocalDate fechaReprogramacion;

    @NotNull
    @Min(0)
    @Max(100)
    @Column(name = "avance_global_porcentaje", nullable = false)
    private Integer avanceGlobalPorcentaje;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IndicadorProyecto> indicadores = new ArrayList<>();
}