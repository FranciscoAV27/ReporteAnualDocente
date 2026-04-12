package mx.edu.unpa.reporteanualdocente.controllers.report.s3;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProyectoInvestigacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s3/proyectos")
public class ProyectoInvestigacionController {

    @Autowired
    private ProyectoInvestigacionService service;

    @PostMapping
    public ProyectoInvestigacion guardar(@RequestBody ProyectoInvestigacion p) {
        return service.guardar(p);
    }

    @GetMapping("/{reporteId}")
    public List<ProyectoInvestigacion> listar(@PathVariable Integer reporteId) {
        return service.listarPorReporte(reporteId);
    }
}