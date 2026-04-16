package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s1;

import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo.ProductoApoyoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo.ProductoApoyoResponse;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s1.ProductoApoyo;
import mx.edu.unpa.reporteanualdocente.exceptions.ResourceNotFoundException;
import mx.edu.unpa.reporteanualdocente.repositories.report.ReporteAnualRepository;
import mx.edu.unpa.reporteanualdocente.repositories.report.s1.ProductoApoyoRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s1.ProductoApoyoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoApoyoServiceImpl implements ProductoApoyoService {

    private final ReporteAnualRepository reporteAnualRepository;
    private final ProductoApoyoRepository productoRepository;

    @Override
    @Transactional
    public ProductoApoyoResponse createProducto(ProductoApoyoRequest request) {
        ReporteAnual reporte = reporteAnualRepository.findById(request.getReporteId())
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + request.getReporteId()));

        ProductoApoyo producto = new ProductoApoyo();
        producto.setReporte(reporte);
        producto.setNumCurso(request.getNumCurso());
        producto.setDescripcion(request.getDescripcion());
        producto.setEnlace(request.getEnlace());

        ProductoApoyo saved = productoRepository.save(producto);
        return mapProductoToResponse(saved);
    }

    @Override
    @Transactional
    public ProductoApoyoResponse updateProducto(Long id, ProductoApoyoRequest request) {
        ProductoApoyo producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
        producto.setNumCurso(request.getNumCurso());
        producto.setDescripcion(request.getDescripcion());
        producto.setEnlace(request.getEnlace());
        return mapProductoToResponse(productoRepository.save(producto));
    }

    @Override
    @Transactional
    public void deleteProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con id: " + id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoApoyoResponse findProductoById(Long id) {
        ProductoApoyo producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
        return mapProductoToResponse(producto);
    }

    @Override
    public List<ProductoApoyoResponse> findProductosByReporte(Long reporteId) {
        return productoRepository.findByReporteId(reporteId).stream()
                .map(this::mapProductoToResponse)
                .collect(Collectors.toList());
    }

    private ProductoApoyoResponse mapProductoToResponse(ProductoApoyo producto) {
        return new ProductoApoyoResponse(
                producto.getId(),
                producto.getReporte().getId(),
                producto.getNumCurso(),
                producto.getDescripcion(),
                producto.getEnlace()
        );
    }
}
