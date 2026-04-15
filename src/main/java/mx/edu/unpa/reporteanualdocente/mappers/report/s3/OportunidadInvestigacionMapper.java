package mx.edu.unpa.reporteanualdocente.mappers.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request.OportunidadInvestigacionRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response.OportunidadInvestigacionResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.OportunidadInvestigacion;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OportunidadInvestigacionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    OportunidadInvestigacion toEntity(OportunidadInvestigacionRequestDTO dto);

    OportunidadInvestigacionResponseDTO toDTO(OportunidadInvestigacion entity);

    List<OportunidadInvestigacionResponseDTO> toDTOList(List<OportunidadInvestigacion> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}
