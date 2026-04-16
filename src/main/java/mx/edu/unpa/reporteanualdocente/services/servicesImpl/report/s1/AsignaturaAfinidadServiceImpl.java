package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s1;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad.AsignaturaAfinidadRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad.AsignaturaAfinidadResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s1.AsignaturaAfinidad;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s1.AsignaturaAfinidadRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s1.AsignaturaAfinidadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsignaturaAfinidadServiceImpl implements AsignaturaAfinidadService {

    private final ReporteAnualRepository reporteAnualRepository;
    private final AsignaturaAfinidadRepository asignaturaRepository;

    @Override
    @Transactional
    public AsignaturaAfinidadResponse createAsignatura(AsignaturaAfinidadRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        AsignaturaAfinidad asignatura = new AsignaturaAfinidad();
        asignatura.setReporte(reporte);
        asignatura.setNumAsignatura(request.getNumAsignatura());
        asignatura.setCarrera(request.getCarrera());
        asignatura.setAsignatura(request.getAsignatura());
        asignatura.setSemestre(request.getSemestre());

        AsignaturaAfinidad saved = asignaturaRepository.save(asignatura);
        return mapAsignaturaToResponse(saved);
    }

    @Override
    @Transactional
    public AsignaturaAfinidadResponse updateAsignatura(Long id, AsignaturaAfinidadRequest request) {
        AsignaturaAfinidad asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura de afinidad no encontrada con id: " + id));
        asignatura.setNumAsignatura(request.getNumAsignatura());
        asignatura.setCarrera(request.getCarrera());
        asignatura.setAsignatura(request.getAsignatura());
        asignatura.setSemestre(request.getSemestre());
        return mapAsignaturaToResponse(asignaturaRepository.save(asignatura));
    }

    @Override
    @Transactional
    public void deleteAsignatura(Long id) {
        if (!asignaturaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Asignatura de afinidad no encontrada con id: " + id);
        }
        asignaturaRepository.deleteById(id);
    }

    @Override
    public AsignaturaAfinidadResponse findAsignaturaById(Long id) {
        AsignaturaAfinidad asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura de afinidad no encontrada con id: " + id));
        return mapAsignaturaToResponse(asignatura);
    }

    @Override
    public List<AsignaturaAfinidadResponse> findAsignaturasByReporte(Long reporteId) {
        return asignaturaRepository.findByReporteId(reporteId).stream()
                .map(this::mapAsignaturaToResponse)
                .collect(Collectors.toList());
    }

    private AsignaturaAfinidadResponse mapAsignaturaToResponse(AsignaturaAfinidad asignatura) {
        return new AsignaturaAfinidadResponse(
                asignatura.getId(),
                asignatura.getReporte().getId(),
                asignatura.getNumAsignatura(),
                asignatura.getCarrera(),
                asignatura.getAsignatura(),
                asignatura.getSemestre()
        );
    }
}
