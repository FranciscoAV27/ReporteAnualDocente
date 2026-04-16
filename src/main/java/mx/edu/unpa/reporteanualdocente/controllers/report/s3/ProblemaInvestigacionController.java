package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion.ProblemaInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.problemaInvestigacion.ProblemaInvestigacionResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s3.ProblemaInvestigacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/investigacion")
@RequiredArgsConstructor
public class ProblemaInvestigacionController {

    private final ProblemaInvestigacionService service;

    @PostMapping("/problemas")
    public ResponseEntity<ProblemaInvestigacionResponse> createProblema(@Valid @RequestBody ProblemaInvestigacionRequest request) {
        return new ResponseEntity<>(service.createProblema(request), HttpStatus.CREATED);
    }

    @PutMapping("/problemas/{id}")
    public ResponseEntity<ProblemaInvestigacionResponse> updateProblema(@PathVariable Long id, @Valid @RequestBody ProblemaInvestigacionRequest request) {
        return ResponseEntity.ok(service.updateProblema(id, request));
    }

    @DeleteMapping("/problemas/{id}")
    public ResponseEntity<Void> deleteProblema(@PathVariable Long id) {
        service.deleteProblema(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/problemas/{id}")
    public ResponseEntity<ProblemaInvestigacionResponse> getProblemaById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findProblemaById(id));
    }

    @GetMapping("/problemas/reporte/{reporteId}")
    public ResponseEntity<List<ProblemaInvestigacionResponse>> getProblemasByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findProblemasByReporte(reporteId));
    }
}
