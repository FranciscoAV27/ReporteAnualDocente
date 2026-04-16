package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo.PromocionDesarrolloRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.promocionDesarrollo.PromocionDesarrolloResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s3.PromocionDesarrolloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/investigacion")
@RequiredArgsConstructor
public class PromocionDesarrolloController {

    private final PromocionDesarrolloService service;

    @PostMapping("/promociones")
    public ResponseEntity<PromocionDesarrolloResponse> createPromocion(@Valid @RequestBody PromocionDesarrolloRequest request) {
        return new ResponseEntity<>(service.createPromocion(request), HttpStatus.CREATED);
    }

    @PutMapping("/promociones/{id}")
    public ResponseEntity<PromocionDesarrolloResponse> updatePromocion(@PathVariable Long id, @Valid @RequestBody PromocionDesarrolloRequest request) {
        return ResponseEntity.ok(service.updatePromocion(id, request));
    }

    @DeleteMapping("/promociones/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable Long id) {
        service.deletePromocion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/promociones/{id}")
    public ResponseEntity<PromocionDesarrolloResponse> getPromocionById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findPromocionById(id));
    }

    @GetMapping("/promociones/reporte/{reporteId}")
    public ResponseEntity<List<PromocionDesarrolloResponse>> getPromocionesByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findPromocionesByReporte(reporteId));
    }
}
