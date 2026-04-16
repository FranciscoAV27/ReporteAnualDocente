package mx.edu.unpa.reporteanualdocente.controllers.report.s2;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis.DireccionTesisRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.direccionTesis.DireccionTesisResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s2.DireccionTesisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/formacion-rh")
@RequiredArgsConstructor
public class DireccionTesisController {

    private final DireccionTesisService service;

    @PostMapping("/direcciones-tesis")
    public ResponseEntity<DireccionTesisResponse> createDireccionTesis(@Valid @RequestBody DireccionTesisRequest request) {
        return new ResponseEntity<>(service.createDireccionTesis(request), HttpStatus.CREATED);
    }

    @PutMapping("/direcciones-tesis/{id}")
    public ResponseEntity<DireccionTesisResponse> updateDireccionTesis(@PathVariable Long id, @Valid @RequestBody DireccionTesisRequest request) {
        return ResponseEntity.ok(service.updateDireccionTesis(id, request));
    }

    @DeleteMapping("/direcciones-tesis/{id}")
    public ResponseEntity<Void> deleteDireccionTesis(@PathVariable Long id) {
        service.deleteDireccionTesis(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/direcciones-tesis/{id}")
    public ResponseEntity<DireccionTesisResponse> getDireccionTesisById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDireccionTesisById(id));
    }

    @GetMapping("/direcciones-tesis/reporte/{reporteId}")
    public ResponseEntity<List<DireccionTesisResponse>> getDireccionesTesisByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findDireccionesTesisByReporte(reporteId));
    }
}
