package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "indicadores_proyecto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndicadorProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyecto_id", nullable = false)
    private ProyectoInvestigacion proyecto;

    @NotNull
    @Column(name = "num_indicador", nullable = false)
    private Integer numIndicador;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;
}