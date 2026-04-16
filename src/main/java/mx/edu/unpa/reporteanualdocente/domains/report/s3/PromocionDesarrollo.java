package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "promocion_desarrollo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDesarrollo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_actividad", nullable = false)
    private Integer numActividad;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String actividad;

    @NotBlank
    @Column(name = "institucion_solicitante", nullable = false, length = 150)
    private String institucionSolicitante;

    @NotNull
    @Positive
    @Column(name = "horas_requeridas", nullable = false)
    private Integer horasRequeridas;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String producto;
}