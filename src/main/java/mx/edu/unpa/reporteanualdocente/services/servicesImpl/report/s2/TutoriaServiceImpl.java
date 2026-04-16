package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s2;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria.TutoriaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria.TutoriaResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s2.TutoriaRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s2.TutoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutoriaServiceImpl implements TutoriaService {

    private final TutoriaRepository tutoriaRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public TutoriaResponse createTutoria(TutoriaRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        Tutoria tutoria = new Tutoria();
        tutoria.setReporte(reporte);
        tutoria.setNumTutoria(request.getNumTutoria());
        tutoria.setNombreEstudiante(request.getNombreEstudiante());
        tutoria.setCarreraEstudiante(request.getCarreraEstudiante());
        tutoria.setSemestre(request.getSemestre());
        tutoria.setFechaRegistro(request.getFechaRegistro());

        Tutoria saved = tutoriaRepository.save(tutoria);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public TutoriaResponse updateTutoria(Long id, TutoriaRequest request) {
        Tutoria tutoria = tutoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tutoría no encontrada con id: " + id));

        // Actualizar campos permitidos (no se cambia el reporte)
        tutoria.setNumTutoria(request.getNumTutoria());
        tutoria.setNombreEstudiante(request.getNombreEstudiante());
        tutoria.setCarreraEstudiante(request.getCarreraEstudiante());
        tutoria.setSemestre(request.getSemestre());
        tutoria.setFechaRegistro(request.getFechaRegistro());

        return mapToResponse(tutoriaRepository.save(tutoria));
    }

    @Override
    @Transactional
    public void deleteTutoria(Long id) {
        if (!tutoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tutoría no encontrada con id: " + id);
        }
        tutoriaRepository.deleteById(id);
    }

    @Override
    public TutoriaResponse findTutoriaById(Long id) {
        Tutoria tutoria = tutoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tutoría no encontrada con id: " + id));
        return mapToResponse(tutoria);
    }

    @Override
    public List<TutoriaResponse> findTutoriasByReporte(Long reporteId) {
        return tutoriaRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private TutoriaResponse mapToResponse(Tutoria tutoria) {
        return new TutoriaResponse(
                tutoria.getId(),
                tutoria.getReporte().getId(),
                tutoria.getNumTutoria(),
                tutoria.getNombreEstudiante(),
                tutoria.getCarreraEstudiante(),
                tutoria.getSemestre(),
                tutoria.getFechaRegistro()
        );
    }
}
