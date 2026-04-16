package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s3;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.IndicadorProyecto;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProyectoInvestigacion;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
//import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.IndicadorProyectoRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.ProyectoInvestigacionRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s3.IndicadorProyectoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndicadorProyectoServiceImpl implements IndicadorProyectoService {

    private final ProyectoInvestigacionRepository proyectoRepository;
    private final IndicadorProyectoRepository indicadorRepository;

    @Override
    @Transactional
    public IndicadorProyectoResponse createIndicador(IndicadorProyectoRequest request) {
        ProyectoInvestigacion proyecto = proyectoRepository.findById(request.getProyectoId())
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado con id: " + request.getProyectoId()));

        IndicadorProyecto indicador = new IndicadorProyecto();
        indicador.setProyecto(proyecto);
        indicador.setNumIndicador(request.getNumIndicador());
        indicador.setDescripcion(request.getDescripcion());

        IndicadorProyecto saved = indicadorRepository.save(indicador);
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public IndicadorProyectoResponse updateIndicador(Long id, IndicadorProyectoRequest request) {
        IndicadorProyecto indicador = indicadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Indicador no encontrado con id: " + id));

        indicador.setNumIndicador(request.getNumIndicador());
        indicador.setDescripcion(request.getDescripcion());

        return mapToResponse(indicadorRepository.save(indicador));
    }

    @Override
    @Transactional
    public void deleteIndicador(Long id) {
        if (!indicadorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Indicador no encontrado con id: " + id);
        }
        indicadorRepository.deleteById(id);
    }

    @Override
    public IndicadorProyectoResponse findIndicadorById(Long id) {
        IndicadorProyecto indicador = indicadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Indicador no encontrado con id: " + id));
        return mapToResponse(indicador);
    }

    @Override
    public List<IndicadorProyectoResponse> findIndicadoresByProyecto(Long proyectoId) {
        return indicadorRepository.findByProyectoId(proyectoId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private IndicadorProyectoResponse mapToResponse(IndicadorProyecto indicador) {
        return new IndicadorProyectoResponse(
                indicador.getId(),
                indicador.getProyecto().getId(),
                indicador.getNumIndicador(),
                indicador.getDescripcion()
        );
    }
}
