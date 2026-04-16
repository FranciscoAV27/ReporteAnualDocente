package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion.OportunidadInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.oportunidadInvestigacion.OportunidadInvestigacionResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s3.OportunidadInvestigacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/investigacion")
@RequiredArgsConstructor
public class OportunidadInvestigacionController {

    private final OportunidadInvestigacionService service;

    @PostMapping("/oportunidades")
    public ResponseEntity<OportunidadInvestigacionResponse> createOportunidad(@Valid @RequestBody OportunidadInvestigacionRequest request) {
        return new ResponseEntity<>(service.createOportunidad(request), HttpStatus.CREATED);
    }

    @PutMapping("/oportunidades/{id}")
    public ResponseEntity<OportunidadInvestigacionResponse> updateOportunidad(@PathVariable Long id, @Valid @RequestBody OportunidadInvestigacionRequest request) {
        return ResponseEntity.ok(service.updateOportunidad(id, request));
    }

    @DeleteMapping("/oportunidades/{id}")
    public ResponseEntity<Void> deleteOportunidad(@PathVariable Long id) {
        service.deleteOportunidad(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/oportunidades/{id}")
    public ResponseEntity<OportunidadInvestigacionResponse> getOportunidadById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOportunidadById(id));
    }

    @GetMapping("/oportunidades/reporte/{reporteId}")
    public ResponseEntity<List<OportunidadInvestigacionResponse>> getOportunidadesByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findOportunidadesByReporte(reporteId));
    }
}
