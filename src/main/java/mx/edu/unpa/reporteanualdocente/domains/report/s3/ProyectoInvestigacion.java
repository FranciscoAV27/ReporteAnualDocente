package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "proyectos_investigacion")
public class ProyectoInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numProyecto;
    private String titulo;
    private String responsabilidad;
    private String faseAprobacion;
    private String instanciaPrincipal;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private LocalDate fechaReprogramacion;
    private Integer avanceGlobalPorcentaje;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private ReporteAnual reporte;
}