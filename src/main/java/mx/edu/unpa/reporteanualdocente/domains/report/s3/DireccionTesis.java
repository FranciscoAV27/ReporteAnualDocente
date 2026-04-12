package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "direcciones_tesis")
public class DireccionTesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numDireccion;
    private String titulo;
    private String nombreEstudiante;
    private String grado;
    private Integer porcentajeAvance;
    private LocalDate fechaRegistro;
    private LocalDate fechaTerminacionProg;
    private LocalDate fechaTerminacionReprog;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private ReporteAnual reporte;
}