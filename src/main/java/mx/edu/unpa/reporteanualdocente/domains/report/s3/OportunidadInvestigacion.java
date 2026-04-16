package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "oportunidades_investigacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OportunidadInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_oportunidad", nullable = false)
    private Integer numOportunidad;

    @NotBlank
    @Column(name = "texto_libre", nullable = false, columnDefinition = "TEXT")
    private String textoLibre;
}