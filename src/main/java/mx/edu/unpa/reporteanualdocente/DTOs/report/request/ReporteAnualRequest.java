package mx.edu.unpa.reporteanualdocente.DTOs.report.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteAnualRequest {
    @NotNull
    private Long profesorId;

    @NotNull
    @Min(2000)
    @Max(2100)
    private Integer año;

    private String comentariosGenerales;
}