package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionArticuloRequest {

    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numPublicacion;

    @NotBlank
    private String titulo;

    @NotBlank
    private String revista;

    @NotBlank
    @Pattern(regexp = "[PAR]")
    private String fase;

    @NotNull
    private LocalDate fecha;
}