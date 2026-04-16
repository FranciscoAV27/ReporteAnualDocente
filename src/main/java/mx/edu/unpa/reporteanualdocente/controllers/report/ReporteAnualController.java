package mx.edu.unpa.reporteanualdocente.controllers.report;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.request.ReporteAnualRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.response.ReporteAnualResponse;
import mx.edu.unpa.reporteanualdocente.services.report.ReporteAnualService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/reportes")
@RequiredArgsConstructor
public class ReporteAnualController {

    private final ReporteAnualService reporteService;

    @PostMapping
    public ResponseEntity<ReporteAnualResponse> create(@Valid @RequestBody ReporteAnualRequest request) {
        return new ResponseEntity<>(reporteService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteAnualResponse> update(@PathVariable Long id, @Valid @RequestBody ReporteAnualRequest request) {
        return ResponseEntity.ok(reporteService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reporteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteAnualResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reporteService.findById(id));
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<ReporteAnualResponse>> findByProfesorId(@PathVariable Long profesorId) {
        return ResponseEntity.ok(reporteService.findByProfesorId(profesorId));
    }
}