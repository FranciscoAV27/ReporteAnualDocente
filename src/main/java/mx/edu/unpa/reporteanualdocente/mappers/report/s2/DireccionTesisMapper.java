package mx.edu.unpa.reporteanualdocente.mappers.report.s2;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.Tutoria.request.DireccionTesisRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.Tutoria.response.DireccionTesisResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.DireccionTesis;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DireccionTesisMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    DireccionTesis toEntity(DireccionTesisRequestDTO dto);

    DireccionTesisResponseDTO toDTO(DireccionTesis entity);

    List<DireccionTesisResponseDTO> toDTOList(List<DireccionTesis> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}
