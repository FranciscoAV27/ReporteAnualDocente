package mx.edu.unpa.reporteanualdocente.services.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo.PromocionDesarrolloRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo.PromocionDesarrolloResponse;

import java.util.List;

public interface PromocionDesarrolloService {
    // Promoción
    PromocionDesarrolloResponse createPromocion(PromocionDesarrolloRequest request);
    PromocionDesarrolloResponse updatePromocion(Long id, PromocionDesarrolloRequest request);
    void deletePromocion(Long id);
    PromocionDesarrolloResponse findPromocionById(Long id);
    List<PromocionDesarrolloResponse> findPromocionesByReporte(Long reporteId);
}