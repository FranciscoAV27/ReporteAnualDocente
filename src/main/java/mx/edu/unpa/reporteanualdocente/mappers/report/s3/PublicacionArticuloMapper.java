package mx.edu.unpa.reporteanualdocente.mappers.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request.PublicacionArticuloRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response.PublicacionArticuloResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.PublicacionArticulo;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PublicacionArticuloMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    PublicacionArticulo toEntity(PublicacionArticuloRequestDTO dto);

    PublicacionArticuloResponseDTO toDTO(PublicacionArticulo entity);

    List<PublicacionArticuloResponseDTO> toDTOList(List<PublicacionArticulo> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}
