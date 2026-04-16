package mx.edu.unpa.reporteanualdocente.domains.report;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.unpa.reporteanualdocente.domains.Profesor;
import mx.edu.unpa.reporteanualdocente.domains.report.s1.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reportes_anuales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteAnual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    @NotNull
    @Min(2000)
    @Max(2100)
    @Column(nullable = false)
    private Integer año;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('borrador','enviado','validado','rechazado') DEFAULT 'borrador'")
    private EstadoReporte estado = EstadoReporte.borrador;

    @Column(name = "comentarios_generales", columnDefinition = "TEXT")
    private String comentariosGenerales;

    // Relaciones con las demás tablas (opcional, para acceso bidireccional)
    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CursoImpartido> cursosImpartidos = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductoApoyo> productosApoyo = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AsignaturaAfinidad> asignaturasAfinidad = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OportunidadDocencia> oportunidadesDocencia = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProblemaDocencia> problemasDocencia = new ArrayList<>();

    /*@OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tutoria> tutorias = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DireccionTesisRequest> direccionesTesis = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProyectoInvestigacion> proyectosInvestigacion = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PublicacionArticulo> publicacionesArticulos = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PromocionDesarrollo> promocionesDesarrollo = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OportunidadInvestigacion> oportunidadesInvestigacion = new ArrayList<>();

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProblemaInvestigacion> problemasInvestigacion = new ArrayList<>();*/

    // Enum para estado
    public enum EstadoReporte {
        borrador, enviado, validado, rechazado
    }
}