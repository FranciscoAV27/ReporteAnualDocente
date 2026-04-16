package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report;

import mx.edu.unpa.reporteanualdocente.DTOs.report.request.ReporteAnualRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.response.ReporteAnualResponse;
import mx.edu.unpa.reporteanualdocente.domains.Profesor;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.ProfesorRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.services.report.ReporteAnualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReporteAnualServiceImpl implements ReporteAnualService {

    private final ReporteAnualRepository reporteAnualRepository;
    private final ProfesorRepository profesorRepository;

    @Override
    @Transactional
    public ReporteAnualResponse create(ReporteAnualRequest request) {
        Profesor profesor = profesorRepository.findById(request.getProfesorId())
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado con id: " + request.getProfesorId()));

        ReporteAnual reporte = new ReporteAnual();
        reporte.setProfesor(profesor);
        reporte.setAño(request.getAño());
        reporte.setComentariosGenerales(request.getComentariosGenerales());
        reporte.setEstado(ReporteAnual.EstadoReporte.borrador);

        ReporteAnual saved = reporteAnualRepository.save(reporte);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public ReporteAnualResponse update(Long id, ReporteAnualRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + id));

        // Actualizar solo campos permitidos (comentarios, pero no profesor ni año)
        if (request.getComentariosGenerales() != null) {
            reporte.setComentariosGenerales(request.getComentariosGenerales());
        }
        return mapToResponse(reporteAnualRepository.save(reporte));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!reporteAnualRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reporte no encontrado con id: " + id);
        }
        reporteAnualRepository.deleteById(id);
    }

    @Override
    public ReporteAnualResponse findById(Long id) {
        ReporteAnual reporte = reporteAnualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + id));
        return mapToResponse(reporte);
    }

    @Override
    public List<ReporteAnualResponse> findByProfesorId(Long profesorId) {
        return reporteAnualRepository.findByProfesorId(profesorId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ReporteAnualResponse mapToResponse(ReporteAnual reporte) {
        return new ReporteAnualResponse(
                reporte.getId(),
                reporte.getProfesor().getId(),
                reporte.getProfesor().getNombre(),
                reporte.getAño(),
                reporte.getFechaCreacion(),
                reporte.getFechaEnvio(),
                reporte.getEstado().name(),
                reporte.getComentariosGenerales()
        );
    }
}