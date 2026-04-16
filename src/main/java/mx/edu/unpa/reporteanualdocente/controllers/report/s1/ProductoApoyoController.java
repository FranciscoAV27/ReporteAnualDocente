package mx.edu.unpa.reporteanualdocente.controllers.report.s1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo.ProductoApoyoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.productoApoyo.ProductoApoyoResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s1.ProductoApoyoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/docencia")
@RequiredArgsConstructor
public class ProductoApoyoController {

    private final ProductoApoyoService productoApoyoService;

    @PostMapping("/productos")
    public ResponseEntity<ProductoApoyoResponse> createProducto(@Valid @RequestBody ProductoApoyoRequest request) {
        return new ResponseEntity<>(productoApoyoService.createProducto(request), HttpStatus.CREATED);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<ProductoApoyoResponse> updateProducto(@PathVariable Long id, @Valid @RequestBody ProductoApoyoRequest request) {
        return ResponseEntity.ok(productoApoyoService.updateProducto(id, request));
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoApoyoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoApoyoResponse> findProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(productoApoyoService.findProductoById(id));
    }

    @GetMapping("/productos/reporte/{reporteId}")
    public ResponseEntity<List<ProductoApoyoResponse>> findProductosByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(productoApoyoService.findProductosByReporte(reporteId));
    }

}
