package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionArticuloResponse {
    private Long id;
    private Long reporteId;
    private Integer numPublicacion;
    private String titulo;
    private String revista;
    private String fase;
    private LocalDate fecha;
}