package mx.edu.unpa.reporteanualdocente.mappers.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request.ProblemaInvestigacionRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response.ProblemaInvestigacionResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProblemaInvestigacion;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProblemaInvestigacionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    ProblemaInvestigacion toEntity(ProblemaInvestigacionRequestDTO dto);

    ProblemaInvestigacionResponseDTO toDTO(ProblemaInvestigacion entity);

    List<ProblemaInvestigacionResponseDTO> toDTOList(List<ProblemaInvestigacion> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}