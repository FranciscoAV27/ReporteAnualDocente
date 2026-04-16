package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s3;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo.PublicacionArticuloRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo.PublicacionArticuloResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.PublicacionArticulo;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s3.PublicacionArticuloRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s3.PublicacionArticuloService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicacionArticuloServiceImpl implements PublicacionArticuloService {

    private final PublicacionArticuloRepository publicacionRepository;
    private final ReporteAnualRepository reporteAnualRepository;

    @Override
    @Transactional
    public PublicacionArticuloResponse createPublicacion(PublicacionArticuloRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        PublicacionArticulo pub = new PublicacionArticulo();
        pub.setReporte(reporte);
        pub.setNumPublicacion(request.getNumPublicacion());
        pub.setTitulo(request.getTitulo());
        pub.setRevista(request.getRevista());
        pub.setFase(request.getFase());
        pub.setFecha(request.getFecha());

        return mapToResponse(publicacionRepository.save(pub));
    }

    @Override
    @Transactional
    public PublicacionArticuloResponse updatePublicacion(Long id, PublicacionArticuloRequest request) {
        PublicacionArticulo pub = publicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicación no encontrada con id: " + id));

        pub.setNumPublicacion(request.getNumPublicacion());
        pub.setTitulo(request.getTitulo());
        pub.setRevista(request.getRevista());
        pub.setFase(request.getFase());
        pub.setFecha(request.getFecha());

        return mapToResponse(publicacionRepository.save(pub));
    }

    @Override
    @Transactional
    public void deletePublicacion(Long id) {
        if (!publicacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Publicación no encontrada con id: " + id);
        }
        publicacionRepository.deleteById(id);
    }

    @Override
    public PublicacionArticuloResponse findPublicacionById(Long id) {
        PublicacionArticulo pub = publicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicación no encontrada con id: " + id));
        return mapToResponse(pub);
    }

    @Override
    public List<PublicacionArticuloResponse> findPublicacionesByReporte(Long reporteId) {
        return publicacionRepository.findByReporteId(reporteId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private PublicacionArticuloResponse mapToResponse(PublicacionArticulo pub) {
        return new PublicacionArticuloResponse(
                pub.getId(),
                pub.getReporte().getId(),
                pub.getNumPublicacion(),
                pub.getTitulo(),
                pub.getRevista(),
                pub.getFase(),
                pub.getFecha()
        );
    }
}
