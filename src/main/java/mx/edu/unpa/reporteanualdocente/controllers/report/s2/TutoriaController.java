package mx.edu.unpa.reporteanualdocente.controllers.report.s2;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria.TutoriaRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.tutoria.TutoriaResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s2.TutoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/formacion-rh")
@RequiredArgsConstructor
public class TutoriaController {

    private final TutoriaService service;

    // -------------------- Tutorías --------------------
    @PostMapping("/tutorias")
    public ResponseEntity<TutoriaResponse> createTutoria(@Valid @RequestBody TutoriaRequest request) {
        return new ResponseEntity<>(service.createTutoria(request), HttpStatus.CREATED);
    }

    @PutMapping("/tutorias/{id}")
    public ResponseEntity<TutoriaResponse> updateTutoria(@PathVariable Long id, @Valid @RequestBody TutoriaRequest request) {
        return ResponseEntity.ok(service.updateTutoria(id, request));
    }

    @DeleteMapping("/tutorias/{id}")
    public ResponseEntity<Void> deleteTutoria(@PathVariable Long id) {
        service.deleteTutoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tutorias/{id}")
    public ResponseEntity<TutoriaResponse> getTutoriaById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findTutoriaById(id));
    }

    @GetMapping("/tutorias/reporte/{reporteId}")
    public ResponseEntity<List<TutoriaResponse>> getTutoriasByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(service.findTutoriasByReporte(reporteId));
    }
}
