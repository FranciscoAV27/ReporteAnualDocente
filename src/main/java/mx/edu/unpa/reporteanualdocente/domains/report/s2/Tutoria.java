package mx.edu.unpa.reporteanualdocente.domains.report.s2;

import jakarta.persistence.*;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "tutorias")
public class Tutoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numTutoria;
    private String nombreEstudiante;
    private String carreraEstudiante;
    private String semestre;
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private ReporteAnual reporte;
}
