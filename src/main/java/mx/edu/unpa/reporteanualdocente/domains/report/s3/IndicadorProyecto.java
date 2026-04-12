package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;

@Entity
@Table(name = "indicadores_proyecto")
public class IndicadorProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numIndicador;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private ProyectoInvestigacion proyecto;
}
