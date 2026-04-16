package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion.ProyectoInvestigacionRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.proyectoInvestigacion.ProyectoInvestigacionResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s3.ProyectoInvestigacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/investigacion")
@RequiredArgsConstructor
public class ProyectoInvestigacionController {

    private final ProyectoInvestigacionService service;

    // -------------------- Proyectos --------------------
    @PostMapping("/proyectos")
    public ResponseEntity<ProyectoInvestigacionResponse> createProyecto(@Valid @RequestBody ProyectoInvestigacionRequest request) {
        return new ResponseEntity<>(service.createProyecto(request), HttpStatus.CREATED);
    }

    @PutMapping("/proyectos/{id}")
    public ResponseEntity<ProyectoInvestigacionResponse> updateProyecto(@PathVariable Long id, @Valid @RequestBody ProyectoInvestigacionRequest request) {
        return ResponseEntity.ok(service.updateProyecto(id, request));
    }

    @DeleteMapping("/proyectos/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        service.deleteProyecto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/proyectos/{id}")
    public ResponseEntity<ProyectoInvestigacionResponse> getProyectoById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findProyectoById(id));
    }

    @GetMapping("/proyectos/reporte/{reporteId}")
    public ResponseEntity<List<ProyectoInvestigacionResponse>> getProyectosByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findProyectosByReporte(reporteId));
    }

}