package mx.edu.unpa.reporteanualdocente.services.servicesImpl;

import mx.edu.unpa.reporteanualdocente.DTOs.profesor.request.ProfesorRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.profesor.response.ProfesorResponse;
import mx.edu.unpa.reporteanualdocente.domains.Profesor;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.ProfesorRepository;
import mx.edu.unpa.reporteanualdocente.services.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final PasswordEncoder passwordEncoder;   // ← NUEVO

    @Override
    @Transactional
    public ProfesorResponse create(ProfesorRequest request) {
        Profesor profesor = new Profesor();
        profesor.setNombre(request.getNombre());
        profesor.setEmail(request.getEmail());
        profesor.setCarreraId(request.getCarreraId());
        // NUEVO: asignar número de trabajo y contraseña encriptada
        profesor.setNumeroTrabajo(request.getNumeroTrabajo());
        profesor.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
        Profesor saved = profesorRepository.save(profesor);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public ProfesorResponse update(Long id, ProfesorRequest request) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con id: " + id));
        profesor.setNombre(request.getNombre());
        profesor.setEmail(request.getEmail());
        profesor.setCarreraId(request.getCarreraId());
        // NUEVO: actualizar número de trabajo (validar que no exista otro)
        if (request.getNumeroTrabajo() != null && !request.getNumeroTrabajo().equals(profesor.getNumeroTrabajo())) {
            // Opcional: verificar unicidad aquí
            profesor.setNumeroTrabajo(request.getNumeroTrabajo());
        }

        // NUEVO: si se envía una nueva contraseña, se encripta y se actualiza
        if (request.getContrasenia() != null && !request.getContrasenia().isEmpty()) {
            profesor.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
        }
        return mapToResponse(profesorRepository.save(profesor));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Profesor no encontrado con id: " + id);
        }
        profesorRepository.deleteById(id);
    }

    @Override
    public ProfesorResponse findById(Long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con id: " + id));
        return mapToResponse(profesor);
    }

    @Override
    public List<ProfesorResponse> findAll() {
        return profesorRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProfesorResponse findByEmail(String email) {
        Profesor profesor = profesorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con email: " + email));
        return mapToResponse(profesor);
    }

    private ProfesorResponse mapToResponse(Profesor profesor) {
        return new ProfesorResponse(
                profesor.getId(),
                profesor.getNombre(),
                profesor.getEmail(),
                profesor.getNumeroTrabajo(),   // ← NUEVO
                profesor.getCarreraId(),
                profesor.getCreatedAt()
        );
    }

    @Override
    public ProfesorResponse findByNumeroTrabajo(String numeroTrabajo) {
        Profesor profesor = profesorRepository.findByNumeroTrabajo(numeroTrabajo)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con número de trabajo: " + numeroTrabajo));
        return mapToResponse(profesor);
    }
}