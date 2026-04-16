package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s3;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo.PromocionDesarrolloRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo.PromocionDesarrolloResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.PromocionDesarrollo;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.PromocionDesarrolloRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s3.PromocionDesarrolloService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromocionDesarrolloServiceImpl implements PromocionDesarrolloService {

    private final PromocionDesarrolloRepository promocionRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public PromocionDesarrolloResponse createPromocion(PromocionDesarrolloRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        PromocionDesarrollo prom = new PromocionDesarrollo();
        prom.setReporte(reporte);
        prom.setNumActividad(request.getNumActividad());
        prom.setActividad(request.getActividad());
        prom.setInstitucionSolicitante(request.getInstitucionSolicitante());
        prom.setHorasRequeridas(request.getHorasRequeridas());
        prom.setProducto(request.getProducto());

        return mapToResponse(promocionRepository.save(prom));
    }

    @Override
    @Transactional
    public PromocionDesarrolloResponse updatePromocion(Long id, PromocionDesarrolloRequest request) {
        PromocionDesarrollo prom = promocionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actividad de promoción no encontrada con id: " + id));

        prom.setNumActividad(request.getNumActividad());
        prom.setActividad(request.getActividad());
        prom.setInstitucionSolicitante(request.getInstitucionSolicitante());
        prom.setHorasRequeridas(request.getHorasRequeridas());
        prom.setProducto(request.getProducto());

        return mapToResponse(promocionRepository.save(prom));
    }

    @Override
    @Transactional
    public void deletePromocion(Long id) {
        if (!promocionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Actividad de promoción no encontrada con id: " + id);
        }
        promocionRepository.deleteById(id);
    }

    @Override
    public PromocionDesarrolloResponse findPromocionById(Long id) {
        PromocionDesarrollo prom = promocionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actividad de promoción no encontrada con id: " + id));
        return mapToResponse(prom);
    }

    @Override
    public List<PromocionDesarrolloResponse> findPromocionesByReporte(Long reporteId) {
        return promocionRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private PromocionDesarrolloResponse mapToResponse(PromocionDesarrollo prom) {
        return new PromocionDesarrolloResponse(
                prom.getId(),
                prom.getReporte().getId(),
                prom.getNumActividad(),
                prom.getActividad(),
                prom.getInstitucionSolicitante(),
                prom.getHorasRequeridas(),
                prom.getProducto()
        );
    }
}
