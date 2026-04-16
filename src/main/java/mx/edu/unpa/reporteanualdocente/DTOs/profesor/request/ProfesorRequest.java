package mx.edu.unpa.reporteanualdocente.DTOs.profesor.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorRequest {
    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String numeroTrabajo;

    @NotBlank
    @Size(min = 8)
    private String contrasenia;

    private Long carreraId;  // opcional
}