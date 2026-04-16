package mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDesarrolloRequest {

    @NotNull
    private Long reporteId;

    @NotNull
    private Integer numActividad;

    @NotBlank
    private String actividad;

    @NotBlank
    private String institucionSolicitante;

    @NotNull
    @Positive
    private Integer horasRequeridas;

    @NotBlank
    private String producto;
}