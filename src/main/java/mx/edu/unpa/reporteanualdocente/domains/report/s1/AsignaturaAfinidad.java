package mx.edu.unpa.reporteanualdocente.domains.report.s1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;

@Entity
@Table(name = "asignaturas_afinidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaAfinidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", nullable = false)
    private ReporteAnual reporte;

    @NotNull
    @Column(name = "num_asignatura", nullable = false)
    private Integer numAsignatura;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String carrera;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String asignatura;

    @NotBlank
    @Column(nullable = false, length = 10)
    private String semestre;
}