package mx.edu.unpa.reporteanualdocente.controllers.report.s1;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido.CursoImpartidoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.cursoImpartido.CursoImpartidoResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s1.CursoImpartidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/docencia")
@RequiredArgsConstructor
public class CursoImpartidoController {

    private final CursoImpartidoService cursoImpartidoService;

    @PostMapping("/cursos")
    public ResponseEntity<CursoImpartidoResponse> createCurso(@Valid @RequestBody CursoImpartidoRequest request) {
        return new ResponseEntity<>(cursoImpartidoService.createCurso(request), HttpStatus.CREATED);
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<CursoImpartidoResponse> updateCurso(@PathVariable Long id, @Valid @RequestBody CursoImpartidoRequest request) {
        return ResponseEntity.ok(cursoImpartidoService.updateCurso(id, request));
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoImpartidoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<CursoImpartidoResponse> findCursoById(@PathVariable Long id) {
        return ResponseEntity.ok(cursoImpartidoService.findCursoById(id));
    }

    @GetMapping("/cursos/reporte/{reporteId}")
    public ResponseEntity<List<CursoImpartidoResponse>> findCursosByReporte(@PathVariable Long reporteId) {
        return ResponseEntity.ok(cursoImpartidoService.findCursosByReporte(reporteId));
    }

}
