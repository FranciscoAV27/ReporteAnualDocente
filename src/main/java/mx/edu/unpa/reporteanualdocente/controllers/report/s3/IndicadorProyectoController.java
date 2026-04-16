package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.indicadorProyecto.IndicadorProyectoResponse;
import mx.edu.unpa.reporteanualdocente.services.report.s3.IndicadorProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/investigacion")
@RequiredArgsConstructor
public class IndicadorProyectoController {

    private final IndicadorProyectoService service;

    // -------------------- Indicadores --------------------
    @PostMapping("/indicadores")
    public ResponseEntity<IndicadorProyectoResponse> createIndicador(@Valid @RequestBody IndicadorProyectoRequest request) {
        return new ResponseEntity<>(service.createIndicador(request), HttpStatus.CREATED);
    }

    @PutMapping("/indicadores/{id}")
    public ResponseEntity<IndicadorProyectoResponse> updateIndicador(@PathVariable Long id, @Valid @RequestBody IndicadorProyectoRequest request) {
        return ResponseEntity.ok(service.updateIndicador(id, request));
    }

    @DeleteMapping("/indicadores/{id}")
    public ResponseEntity<Void> deleteIndicador(@PathVariable Long id) {
        service.deleteIndicador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/indicadores/{id}")
    public ResponseEntity<IndicadorProyectoResponse> getIndicadorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findIndicadorById(id));
    }

    @GetMapping("/indicadores/proyecto/{proyectoId}")
    public ResponseEntity<List<IndicadorProyectoResponse>> getIndicadoresByProyecto(@PathVariable Long proyectoId) {
        return ResponseEntity.ok(service.findIndicadoresByProyecto(proyectoId));
    }
}
