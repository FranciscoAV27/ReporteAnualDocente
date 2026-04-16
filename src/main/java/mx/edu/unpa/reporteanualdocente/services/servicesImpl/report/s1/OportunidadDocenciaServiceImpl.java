package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s1;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia.OportunidadDocenciaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia.OportunidadDocenciaResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s1.OportunidadDocencia;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s1.OportunidadDocenciaRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s1.OportunidadDocenciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OportunidadDocenciaServiceImpl implements OportunidadDocenciaService {

    private final ReporteAnualRepository reporteAnualRepository;
    private final OportunidadDocenciaRepository oportunidadRepository;

    @Override
    @Transactional
    public OportunidadDocenciaResponse createOportunidad(OportunidadDocenciaRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        OportunidadDocencia oportunidad = new OportunidadDocencia();
        oportunidad.setReporte(reporte);
        oportunidad.setNumOportunidad(request.getNumOportunidad());
        oportunidad.setTextoLibre(request.getTextoLibre());

        OportunidadDocencia saved = oportunidadRepository.save(oportunidad);
        return mapOportunidadToResponse(saved);
    }

    @Override
    @Transactional
    public OportunidadDocenciaResponse updateOportunidad(Long id, OportunidadDocenciaRequest request) {
        OportunidadDocencia oportunidad = oportunidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oportunidad no encontrada con id: " + id));
        oportunidad.setNumOportunidad(request.getNumOportunidad());
        oportunidad.setTextoLibre(request.getTextoLibre());
        return mapOportunidadToResponse(oportunidadRepository.save(oportunidad));
    }

    @Override
    @Transactional
    public void deleteOportunidad(Long id) {
        if (!oportunidadRepository.existsById(id)) {
            throw new ResourceNotFoundException("Oportunidad no encontrada con id: " + id);
        }
        oportunidadRepository.deleteById(id);
    }

    @Override
    public OportunidadDocenciaResponse findOportunidadById(Long id) {
        OportunidadDocencia oportunidad = oportunidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oportunidad no encontrada con id: " + id));
        return mapOportunidadToResponse(oportunidad);
    }

    @Override
    public List<OportunidadDocenciaResponse> findOportunidadesByReporte(Long reporteId) {
        return oportunidadRepository.findByReporteId(reporteId).stream()
                .map(this::mapOportunidadToResponse)
                .collect(Collectors.toList());
    }

    private OportunidadDocenciaResponse mapOportunidadToResponse(OportunidadDocencia oportunidad) {
        return new OportunidadDocenciaResponse(
                oportunidad.getId(),
                oportunidad.getReporte().getId(),
                oportunidad.getNumOportunidad(),
                oportunidad.getTextoLibre()
        );
    }
}
