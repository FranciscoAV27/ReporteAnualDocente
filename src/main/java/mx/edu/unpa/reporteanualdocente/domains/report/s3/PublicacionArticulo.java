package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "publicaciones_articulos")
public class PublicacionArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numPublicacion;
    private String titulo;
    private String revista;
    private String fase;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private ReporteAnual reporte;
}
