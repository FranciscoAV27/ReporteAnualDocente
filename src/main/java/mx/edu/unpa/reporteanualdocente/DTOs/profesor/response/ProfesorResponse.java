package mx.edu.unpa.reporteanualdocente.DTOs.profesor.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorResponse {
    private Long id;
    private String nombre;
    private String email;
    private String numeroTrabajo;
    // no incluir contrasenia
    private Long carreraId;
    private LocalDateTime createdAt;
}