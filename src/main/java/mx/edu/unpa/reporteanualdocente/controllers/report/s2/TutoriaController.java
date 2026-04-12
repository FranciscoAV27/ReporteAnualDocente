package mx.edu.unpa.reporteanualdocente.controllers.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;
import mx.edu.unpa.reporteanualdocente.services.report.s2.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s2/tutorias")
public class TutoriaController {

    @Autowired
    private TutoriaService service;

    @PostMapping
    public Tutoria guardar(@RequestBody Tutoria t) {
        return service.guardar(t);
    }

    @GetMapping("/{reporteId}")
    public List<Tutoria> listar(@PathVariable Integer reporteId) {
        return service.listarPorReporte(reporteId);
    }
}