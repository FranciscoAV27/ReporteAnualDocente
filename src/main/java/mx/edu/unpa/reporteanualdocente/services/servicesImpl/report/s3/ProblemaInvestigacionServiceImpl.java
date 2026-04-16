package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s3;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion.ProblemaInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion.ProblemaInvestigacionResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProblemaInvestigacion;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.ProblemaInvestigacionRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s3.ProblemaInvestigacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemaInvestigacionServiceImpl implements ProblemaInvestigacionService {

    private final ProblemaInvestigacionRepository problemaRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public ProblemaInvestigacionResponse createProblema(ProblemaInvestigacionRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        ProblemaInvestigacion prob = new ProblemaInvestigacion();
        prob.setReporte(reporte);
        prob.setNumProblema(request.getNumProblema());
        prob.setTextoLibre(request.getTextoLibre());

        return mapToResponse(problemaRepository.save(prob));
    }

    @Override
    @Transactional
    public ProblemaInvestigacionResponse updateProblema(Long id, ProblemaInvestigacionRequest request) {
        ProblemaInvestigacion prob = problemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Problema no encontrado con id: " + id));

        prob.setNumProblema(request.getNumProblema());
        prob.setTextoLibre(request.getTextoLibre());

        return mapToResponse(problemaRepository.save(prob));
    }

    @Override
    @Transactional
    public void deleteProblema(Long id) {
        if (!problemaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Problema no encontrado con id: " + id);
        }
        problemaRepository.deleteById(id);
    }

    @Override
    public ProblemaInvestigacionResponse findProblemaById(Long id) {
        ProblemaInvestigacion prob = problemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Problema no encontrado con id: " + id));
        return mapToResponse(prob);
    }

    @Override
    public List<ProblemaInvestigacionResponse> findProblemasByReporte(Long reporteId) {
        return problemaRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProblemaInvestigacionResponse mapToResponse(ProblemaInvestigacion prob) {
        return new ProblemaInvestigacionResponse(
                prob.getId(),
                prob.getReporte().getId(),
                prob.getNumProblema(),
                prob.getTextoLibre()
        );
    }
}
