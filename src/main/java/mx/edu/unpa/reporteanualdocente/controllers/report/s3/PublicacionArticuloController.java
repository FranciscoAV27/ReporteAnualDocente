package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo.PublicacionArticuloRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.publicacionArticulo.PublicacionArticuloResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s3.PublicacionArticuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/investigacion")
@RequiredArgsConstructor
public class PublicacionArticuloController {

    private final PublicacionArticuloService service;

    @PostMapping("/publicaciones")
    public ResponseEntity<PublicacionArticuloResponse> createPublicacion(@Valid @RequestBody PublicacionArticuloRequest request) {
        return new ResponseEntity<>(service.createPublicacion(request), HttpStatus.CREATED);
    }

    @PutMapping("/publicaciones/{id}")
    public ResponseEntity<PublicacionArticuloResponse> updatePublicacion(@PathVariable Long id, @Valid @RequestBody PublicacionArticuloRequest request) {
        return ResponseEntity.ok(service.updatePublicacion(id, request));
    }

    @DeleteMapping("/publicaciones/{id}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable Long id) {
        service.deletePublicacion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/publicaciones/{id}")
    public ResponseEntity<PublicacionArticuloResponse> getPublicacionById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findPublicacionById(id));
    }

    @GetMapping("/publicaciones/reporte/{reporteId}")
    public ResponseEntity<List<PublicacionArticuloResponse>> getPublicacionesByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findPublicacionesByReporte(reporteId));
    }
}
