package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s1;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia.ProblemaDocenciaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia.ProblemaDocenciaResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s1.ProblemaDocencia;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s1.ProblemaDocenciaRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s1.ProblemaDocenciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemaDocenciaServiceImpl implements ProblemaDocenciaService {

    private final ReporteAnualRepository reporteAnualRepository;
    private final ProblemaDocenciaRepository problemaRepository;

    @Override
    @Transactional
    public ProblemaDocenciaResponse createProblema(ProblemaDocenciaRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        ProblemaDocencia problema = new ProblemaDocencia();
        problema.setReporte(reporte);
        problema.setNumProblema(request.getNumProblema());
        problema.setTextoLibre(request.getTextoLibre());

        ProblemaDocencia saved = problemaRepository.save(problema);
        return mapProblemaToResponse(saved);
    }

    @Override
    @Transactional
    public ProblemaDocenciaResponse updateProblema(Long id, ProblemaDocenciaRequest request) {
        ProblemaDocencia problema = problemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Problema no encontrado con id: " + id));
        problema.setNumProblema(request.getNumProblema());
        problema.setTextoLibre(request.getTextoLibre());
        return mapProblemaToResponse(problemaRepository.save(problema));
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
    public ProblemaDocenciaResponse findProblemaById(Long id) {
        ProblemaDocencia problema = problemaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Problema no encontrado con id: " + id));
        return mapProblemaToResponse(problema);
    }

    @Override
    public List<ProblemaDocenciaResponse> findProblemasByReporte(Long reporteId) {
        return problemaRepository.findByReporteId(reporteId).stream()
                .map(this::mapProblemaToResponse)
                .collect(Collectors.toList());
    }

    private ProblemaDocenciaResponse mapProblemaToResponse(ProblemaDocencia problema) {
        return new ProblemaDocenciaResponse(
                problema.getId(),
                problema.getReporte().getId(),
                problema.getNumProblema(),
                problema.getTextoLibre()
        );
    }

}
