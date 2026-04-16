package mx.edu.unpa.reporteanualdocente.controllers.report.s1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia.ProblemaDocenciaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.problemaDocencia.ProblemaDocenciaResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s1.ProblemaDocenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/docencia")
@RequiredArgsConstructor
public class ProblemaDocenciaController {

    private final ProblemaDocenciaService problemaService;

    @PostMapping("/problemas")
    public ResponseEntity<ProblemaDocenciaResponse> createProblema(@Valid @RequestBody ProblemaDocenciaRequest request) {
        return new ResponseEntity<>(problemaService.createProblema(request), HttpStatus.CREATED);
    }

    @PutMapping("/problemas/{id}")
    public ResponseEntity<ProblemaDocenciaResponse> updateProblema(@PathVariable Long id, @Valid @RequestBody ProblemaDocenciaRequest request) {
        return ResponseEntity.ok(problemaService.updateProblema(id, request));
    }

    @DeleteMapping("/problemas/{id}")
    public ResponseEntity<Void> deleteProblema(@PathVariable Long id) {
        problemaService.deleteProblema(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/problemas/{id}")
    public ResponseEntity<ProblemaDocenciaResponse> findProblemaById(@PathVariable Long id) {
        return ResponseEntity.ok(problemaService.findProblemaById(id));
    }

    @GetMapping("/problemas/reporte/{reporteId}")
    public ResponseEntity<List<ProblemaDocenciaResponse>> findProblemasByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(problemaService.findProblemasByReporte(reporteId));
    }

}
