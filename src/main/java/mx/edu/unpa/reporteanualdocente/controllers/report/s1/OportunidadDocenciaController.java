package mx.edu.unpa.reporteanualdocente.controllers.report.s1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia.OportunidadDocenciaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.oportunidadDocencia.OportunidadDocenciaResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s1.OportunidadDocenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/docencia")
@RequiredArgsConstructor
public class OportunidadDocenciaController {

    private final OportunidadDocenciaService oportunidadService;

    @PostMapping("/oportunidades")
    public ResponseEntity<OportunidadDocenciaResponse> createOportunidad(@Valid @RequestBody OportunidadDocenciaRequest request) {
        return new ResponseEntity<>(oportunidadService.createOportunidad(request), HttpStatus.CREATED);
    }

    @PutMapping("/oportunidades/{id}")
    public ResponseEntity<OportunidadDocenciaResponse> updateOportunidad(@PathVariable Long id, @Valid @RequestBody OportunidadDocenciaRequest request) {
        return ResponseEntity.ok(oportunidadService.updateOportunidad(id, request));
    }

    @DeleteMapping("/oportunidades/{id}")
    public ResponseEntity<Void> deleteOportunidad(@PathVariable Long id) {
        oportunidadService.deleteOportunidad(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/oportunidades/{id}")
    public ResponseEntity<OportunidadDocenciaResponse> findOportunidadById(@PathVariable Long id) {
        return ResponseEntity.ok(oportunidadService.findOportunidadById(id));
    }

    @GetMapping("/oportunidades/reporte/{reporteId}")
    public ResponseEntity<List<OportunidadDocenciaResponse>> findOportunidadesByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(oportunidadService.findOportunidadesByReporte(reporteId));
    }

}
