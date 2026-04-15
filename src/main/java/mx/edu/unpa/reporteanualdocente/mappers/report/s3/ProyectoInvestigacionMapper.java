package mx.edu.unpa.reporteanualdocente.mappers.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request.ProyectoInvestigacionRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response.ProyectoInvestigacionResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProyectoInvestigacion;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProyectoInvestigacionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    ProyectoInvestigacion toEntity(ProyectoInvestigacionRequestDTO dto);

    ProyectoInvestigacionResponseDTO toDTO(ProyectoInvestigacion entity);

    List<ProyectoInvestigacionResponseDTO> toDTOList(List<ProyectoInvestigacion> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}
