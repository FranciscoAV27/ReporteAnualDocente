package mx.edu.unpa.reporteanualdocente.mappers.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request.IndicadorProyectoRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response.IndicadorProyectoResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.IndicadorProyecto;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.ProyectoInvestigacion;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndicadorProyectoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "proyecto", source = "proyectoId", qualifiedByName = "mapProyecto")
    IndicadorProyecto toEntity(IndicadorProyectoRequestDTO dto);

    IndicadorProyectoResponseDTO toDTO(IndicadorProyecto entity);

    List<IndicadorProyectoResponseDTO> toDTOList(List<IndicadorProyecto> list);

    @Named("mapProyecto")
    default ProyectoInvestigacion mapProyecto(Integer id) {
        if (id == null) return null;
        ProyectoInvestigacion p = new ProyectoInvestigacion();
        p.setId(id);
        return p;
    }
}
