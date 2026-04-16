package mx.edu.unpa.reporteanualdocente.domains.report.s1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "problemas_docencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaDocencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_problema", nullable = false)
    private Integer numProblema;

    @NotBlank
    @Column(name = "texto_libre", nullable = false, columnDefinition = "TEXT")
    private String textoLibre;
}