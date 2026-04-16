package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s2;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis.DireccionTesisRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis.DireccionTesisResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s2.DireccionTesis;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s2.DireccionTesisRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s2.DireccionTesisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DireccionTesisServiceImpl implements DireccionTesisService {

    private final DireccionTesisRepository direccionTesisRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public DireccionTesisResponse createDireccionTesis(DireccionTesisRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        DireccionTesis tesis = new DireccionTesis();
        tesis.setReporte(reporte);
        tesis.setNumDireccion(request.getNumDireccion());
        tesis.setTitulo(request.getTitulo());
        tesis.setNombreEstudiante(request.getNombreEstudiante());
        tesis.setGrado(request.getGrado());
        tesis.setPorcentajeAvance(request.getPorcentajeAvance());
        tesis.setFechaRegistro(request.getFechaRegistro());
        tesis.setFechaTerminacionProg(request.getFechaTerminacionProg());
        tesis.setFechaTerminacionReprog(request.getFechaTerminacionReprog());

        DireccionTesis saved = direccionTesisRepository.save(tesis);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public DireccionTesisResponse updateDireccionTesis(Long id, DireccionTesisRequest request) {
        DireccionTesis tesis = direccionTesisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dirección de tesis no encontrada con id: " + id));

        tesis.setNumDireccion(request.getNumDireccion());
        tesis.setTitulo(request.getTitulo());
        tesis.setNombreEstudiante(request.getNombreEstudiante());
        tesis.setGrado(request.getGrado());
        tesis.setPorcentajeAvance(request.getPorcentajeAvance());
        tesis.setFechaRegistro(request.getFechaRegistro());
        tesis.setFechaTerminacionProg(request.getFechaTerminacionProg());
        tesis.setFechaTerminacionReprog(request.getFechaTerminacionReprog());

        return mapToResponse(direccionTesisRepository.save(tesis));
    }

    @Override
    @Transactional
    public void deleteDireccionTesis(Long id) {
        if (!direccionTesisRepository.existsById(id)) {
            throw new ResourceNotFoundException("Dirección de tesis no encontrada con id: " + id);
        }
        direccionTesisRepository.deleteById(id);
    }

    @Override
    public DireccionTesisResponse findDireccionTesisById(Long id) {
        DireccionTesis tesis = direccionTesisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dirección de tesis no encontrada con id: " + id));
        return mapToResponse(tesis);
    }

    @Override
    public List<DireccionTesisResponse> findDireccionesTesisByReporte(Long reporteId) {
        return direccionTesisRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private DireccionTesisResponse mapToResponse(DireccionTesis tesis) {
        return new DireccionTesisResponse(
                tesis.getId(),
                tesis.getReporte().getId(),
                tesis.getNumDireccion(),
                tesis.getTitulo(),
                tesis.getNombreEstudiante(),
                tesis.getGrado(),
                tesis.getPorcentajeAvance(),
                tesis.getFechaRegistro(),
                tesis.getFechaTerminacionProg(),
                tesis.getFechaTerminacionReprog()
        );
    }
}
