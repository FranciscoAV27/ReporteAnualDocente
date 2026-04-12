package mx.edu.unpa.reporteanualdocente.services.servicesImpl.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;
import mx.edu.unpa.reporteanualdocente.repositories.report.s2.TutoriaRepository;
import mx.edu.unpa.reporteanualdocente.services.report.s2.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoriaServiceImpl implements TutoriaService {

    @Autowired
    private TutoriaRepository repo;

    @Override
    public Tutoria guardar(Tutoria t) {
        return repo.save(t);
    }

    @Override
    public List<Tutoria> listarPorReporte(Integer reporteId) {
        return repo.findByReporteId(reporteId);
    }
}