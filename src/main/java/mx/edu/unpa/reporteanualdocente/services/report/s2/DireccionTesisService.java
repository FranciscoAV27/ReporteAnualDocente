package mx.edu.unpa.reporteanualdocente.services.report.s2;

import mx.edu.unpa.reporteanualdocente.domains.report.s3.DireccionTesis;

import java.util.List;

public interface DireccionTesisService {
    DireccionTesis guardar(DireccionTesis d);
    List<DireccionTesis> listarPorReporte(Integer reporteId);
}