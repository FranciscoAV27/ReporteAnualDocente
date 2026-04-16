package mx.edu.unpa.reporteanualdocente.services.report.s1;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo.ProductoApoyoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo.ProductoApoyoResponse;

import java.util.List;

public interface ProductoApoyoService {
    // ProductoApoyo
    ProductoApoyoResponse createProducto(ProductoApoyoRequest request);
    ProductoApoyoResponse updateProducto(Long id, ProductoApoyoRequest request);
    void deleteProducto(Long id);
    ProductoApoyoResponse findProductoById(Long id);
    List<ProductoApoyoResponse> findProductosByReporte(Long reporteId);
}
