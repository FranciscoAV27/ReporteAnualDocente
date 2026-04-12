package mx.edu.unpa.reporteanualdocente.services.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;

import java.util.List;

public interface TutoriaService {
    Tutoria guardar(Tutoria t);
    List<Tutoria> listarPorReporte(Integer reporteId);
}