package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s3;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion.OportunidadInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion.OportunidadInvestigacionResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.OportunidadInvestigacion;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.OportunidadInvestigacionRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s3.OportunidadInvestigacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OportunidadInvestigacionServiceImpl implements OportunidadInvestigacionService {

    private final OportunidadInvestigacionRepository oportunidadRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public OportunidadInvestigacionResponse createOportunidad(OportunidadInvestigacionRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        OportunidadInvestigacion op = new OportunidadInvestigacion();
        op.setReporte(reporte);
        op.setNumOportunidad(request.getNumOportunidad());
        op.setTextoLibre(request.getTextoLibre());

        return mapToResponse(oportunidadRepository.save(op));
    }

    @Override
    @Transactional
    public OportunidadInvestigacionResponse updateOportunidad(Long id, OportunidadInvestigacionRequest request) {
        OportunidadInvestigacion op = oportunidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oportunidad no encontrada con id: " + id));

        op.setNumOportunidad(request.getNumOportunidad());
        op.setTextoLibre(request.getTextoLibre());

        return mapToResponse(oportunidadRepository.save(op));
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
    public OportunidadInvestigacionResponse findOportunidadById(Long id) {
        OportunidadInvestigacion op = oportunidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oportunidad no encontrada con id: " + id));
        return mapToResponse(op);
    }

    @Override
    public List<OportunidadInvestigacionResponse> findOportunidadesByReporte(Long reporteId) {
        return oportunidadRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private OportunidadInvestigacionResponse mapToResponse(OportunidadInvestigacion op) {
        return new OportunidadInvestigacionResponse(
                op.getId(),
                op.getReporte().getId(),
                op.getNumOportunidad(),
                op.getTextoLibre()
        );
    }
}
