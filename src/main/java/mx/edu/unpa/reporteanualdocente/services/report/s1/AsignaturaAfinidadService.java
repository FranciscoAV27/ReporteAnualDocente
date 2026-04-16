package mx.edu.unpa.reporteanualdocente.services.report.s1;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad.AsignaturaAfinidadRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s1.asignaturaAfinidad.AsignaturaAfinidadResponse;

import java.util.List;

public interface AsignaturaAfinidadService {
    // AsignaturaAfinidad
    AsignaturaAfinidadResponse createAsignatura(AsignaturaAfinidadRequest request);
    AsignaturaAfinidadResponse updateAsignatura(Long id, AsignaturaAfinidadRequest request);
    void deleteAsignatura(Long id);
    AsignaturaAfinidadResponse findAsignaturaById(Long id);
    List<AsignaturaAfinidadResponse> findAsignaturasByReporte(Long reporteId);
}
