package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s3;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion.ProyectoInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion.ProyectoInvestigacionResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProyectoInvestigacion;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.ProyectoInvestigacionRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s3.ProyectoInvestigacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProyectoInvestigacionServiceImpl implements ProyectoInvestigacionService {

    private final ProyectoInvestigacionRepository proyectoRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public ProyectoInvestigacionResponse createProyecto(ProyectoInvestigacionRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        ProyectoInvestigacion proyecto = new ProyectoInvestigacion();
        proyecto.setReporte(reporte);
        proyecto.setNumProyecto(request.getNumProyecto());
        proyecto.setTitulo(request.getTitulo());
        proyecto.setResponsabilidad(request.getResponsabilidad());
        proyecto.setFaseAprobacion(request.getFaseAprobacion());
        proyecto.setInstanciaPrincipal(request.getInstanciaPrincipal());
        proyecto.setFechaInicio(request.getFechaInicio());
        proyecto.setFechaTerminacion(request.getFechaTerminacion());
        proyecto.setFechaReprogramacion(request.getFechaReprogramacion());
        proyecto.setAvanceGlobalPorcentaje(request.getAvanceGlobalPorcentaje());

        ProyectoInvestigacion saved = proyectoRepository.save(proyecto);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public ProyectoInvestigacionResponse updateProyecto(Long id, ProyectoInvestigacionRequest request) {
        ProyectoInvestigacion proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado con id: " + id));

        proyecto.setNumProyecto(request.getNumProyecto());
        proyecto.setTitulo(request.getTitulo());
        proyecto.setResponsabilidad(request.getResponsabilidad());
        proyecto.setFaseAprobacion(request.getFaseAprobacion());
        proyecto.setInstanciaPrincipal(request.getInstanciaPrincipal());
        proyecto.setFechaInicio(request.getFechaInicio());
        proyecto.setFechaTerminacion(request.getFechaTerminacion());
        proyecto.setFechaReprogramacion(request.getFechaReprogramacion());
        proyecto.setAvanceGlobalPorcentaje(request.getAvanceGlobalPorcentaje());

        return mapToResponse(proyectoRepository.save(proyecto));
    }

    @Override
    @Transactional
    public void deleteProyecto(Long id) {
        if (!proyectoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Proyecto no encontrado con id: " + id);
        }
        proyectoRepository.deleteById(id);
    }

    @Override
    public ProyectoInvestigacionResponse findProyectoById(Long id) {
        ProyectoInvestigacion proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado con id: " + id));
        return mapToResponse(proyecto);
    }

    @Override
    public List<ProyectoInvestigacionResponse> findProyectosByReporte(Long reporteId) {
        return proyectoRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProyectoInvestigacionResponse mapToResponse(ProyectoInvestigacion proyecto) {
        return new ProyectoInvestigacionResponse(
                proyecto.getId(),
                proyecto.getReporte().getId(),
                proyecto.getNumProyecto(),
                proyecto.getTitulo(),
                proyecto.getResponsabilidad(),
                proyecto.getFaseAprobacion(),
                proyecto.getInstanciaPrincipal(),
                proyecto.getFechaInicio(),
                proyecto.getFechaTerminacion(),
                proyecto.getFechaReprogramacion(),
                proyecto.getAvanceGlobalPorcentaje(),
                null // Los indicadores se pueden cargar aparte si se desea
        );
    }


}
