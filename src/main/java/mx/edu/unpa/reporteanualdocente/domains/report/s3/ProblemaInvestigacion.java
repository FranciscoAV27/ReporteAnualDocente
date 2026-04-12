package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "problemas_investigacion")
public class ProblemaInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numProblema;
    private String textoLibre;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private ReporteAnual reporte;
}
