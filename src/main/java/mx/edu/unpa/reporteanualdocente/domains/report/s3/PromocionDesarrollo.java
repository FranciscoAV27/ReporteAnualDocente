package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "promocion_desarrollo")
public class PromocionDesarrollo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numActividad;
    private String actividad;
    private String institucionSolicitante;
    private Integer horasRequeridas;
    private String producto;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private ReporteAnual reporte;
}