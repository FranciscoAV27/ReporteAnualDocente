package mx.edu.unpa.reporteanualdocente.controllers.report.s1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad.AsignaturaAfinidadRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad.AsignaturaAfinidadResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s1.AsignaturaAfinidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/docencia")
@RequiredArgsConstructor
public class AsignaturaAfinidadController {

    private final AsignaturaAfinidadService asignaturaAfinidadService;

    @PostMapping("/asignaturas")
    public ResponseEntity<AsignaturaAfinidadResponse> createAsignatura(@Valid @RequestBody AsignaturaAfinidadRequest request) {
        return new ResponseEntity<>(asignaturaAfinidadService.createAsignatura(request), HttpStatus.CREATED);
    }

    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<AsignaturaAfinidadResponse> updateAsignatura(@PathVariable Long id, @Valid @RequestBody AsignaturaAfinidadRequest request) {
        return ResponseEntity.ok(asignaturaAfinidadService.updateAsignatura(id, request));
    }

    @DeleteMapping("/asignaturas/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        asignaturaAfinidadService.deleteAsignatura(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/asignaturas/{id}")
    public ResponseEntity<AsignaturaAfinidadResponse> findAsignaturaById(@PathVariable Long id) {
        return ResponseEntity.ok(asignaturaAfinidadService.findAsignaturaById(id));
    }

    @GetMapping("/asignaturas/reporte/{reporteId}")
    public ResponseEntity<List<AsignaturaAfinidadResponse>> findAsignaturasByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(asignaturaAfinidadService.findAsignaturasByReporte(reporteId));
    }

}
