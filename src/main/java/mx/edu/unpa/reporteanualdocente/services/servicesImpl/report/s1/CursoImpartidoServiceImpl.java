package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s1;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido.CursoImpartidoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido.CursoImpartidoResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s1.CursoImpartido;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s1.CursoImpartidoRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s1.CursoImpartidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoImpartidoServiceImpl implements CursoImpartidoService {

    private final ReporteAnualRepository reporteAnualRepository;
    private final CursoImpartidoRepository cursoRepository;

    @Override
    @Transactional
    public CursoImpartidoResponse createCurso(CursoImpartidoRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        CursoImpartido curso = new CursoImpartido();
        curso.setReporte(reporte);
        curso.setNumCurso(request.getNumCurso());
        curso.setCarrera(request.getCarrera());
        curso.setAsignatura(request.getAsignatura());
        curso.setSemestre(request.getSemestre());
        curso.setCicloEscolar(request.getCicloEscolar());
        curso.setHorasSemana(request.getHorasSemana());
        curso.setNumAlumnos(request.getNumAlumnos());

        CursoImpartido saved = cursoRepository.save(curso);
        return mapCursoToResponse(saved);
    }

    @Override
    @Transactional
    public CursoImpartidoResponse updateCurso(Long id, CursoImpartidoRequest request) {
        CursoImpartido curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con id: " + id));
        // Actualizar campos
        curso.setNumCurso(request.getNumCurso());
        curso.setCarrera(request.getCarrera());
        curso.setAsignatura(request.getAsignatura());
        curso.setSemestre(request.getSemestre());
        curso.setCicloEscolar(request.getCicloEscolar());
        curso.setHorasSemana(request.getHorasSemana());
        curso.setNumAlumnos(request.getNumAlumnos());
        // No se cambia el reporte
        return mapCursoToResponse(cursoRepository.save(curso));
    }

    @Override
    @Transactional
    public void deleteCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Curso no encontrado con id: " + id);
        }
        cursoRepository.deleteById(id);
    }

    @Override
    public CursoImpartidoResponse findCursoById(Long id) {
        CursoImpartido curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con id: " + id));
        return mapCursoToResponse(curso);
    }

    @Override
    public List<CursoImpartidoResponse> findCursosByReporte(Long reporteId) {
        return cursoRepository.findByReporteId(reporteId).stream()
                .map(this::mapCursoToResponse)
                .collect(Collectors.toList());
    }

    private CursoImpartidoResponse mapCursoToResponse(CursoImpartido curso) {
        return new CursoImpartidoResponse(
                curso.getId(),
                curso.getReporte().getId(),
                curso.getNumCurso(),
                curso.getCarrera(),
                curso.getAsignatura(),
                curso.getSemestre(),
                curso.getCicloEscolar(),
                curso.getHorasSemana(),
                curso.getNumAlumnos()
        );
    }
}
