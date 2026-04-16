package mx.edu.unpa.reporteanualdocente.domains.report.s3;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

import java.time.LocalDate;

@Entity
@Table(name = "publicaciones_articulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_publicacion", nullable = false)
    private Integer numPublicacion;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String revista;

    @NotBlank
    @Pattern(regexp = "[PAR]", message = "Fase debe ser P (Publicado), A (Aceptado) o R (Revisión)")
    @Column(nullable = false, length = 1)
    private String fase;

    @NotNull
    @Column(nullable = false)
    private LocalDate fecha;
}