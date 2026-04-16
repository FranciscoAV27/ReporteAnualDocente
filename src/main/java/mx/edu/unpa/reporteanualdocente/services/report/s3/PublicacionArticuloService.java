package mx.edu.unpa.reporteanualdocente.services.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo.PublicacionArticuloRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo.PublicacionArticuloResponse;

import java.util.List;

public interface PublicacionArticuloService {
    // Publicaciones
    PublicacionArticuloResponse createPublicacion(PublicacionArticuloRequest request);
    PublicacionArticuloResponse updatePublicacion(Long id, PublicacionArticuloRequest request);
    void deletePublicacion(Long id);
    PublicacionArticuloResponse findPublicacionById(Long id);
    List<PublicacionArticuloResponse> findPublicacionesByReporte(Long reporteId);
}
