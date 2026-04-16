package mx.edu.unpa.reporteanualdocente.services;

import mx.edu.unpa.reporteanualdocente.DTOs.profesor.request.ProfesorRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.profesor.response.ProfesorResponse;

import java.util.List;

public interface ProfesorService {
    ProfesorResponse create(ProfesorRequest request);
    ProfesorResponse update(Long id, ProfesorRequest request);
    void delete(Long id);
    ProfesorResponse findById(Long id);
    List<ProfesorResponse> findAll();
    ProfesorResponse findByEmail(String email);
    ProfesorResponse findByNumeroTrabajo(String numeroTrabajo);
}