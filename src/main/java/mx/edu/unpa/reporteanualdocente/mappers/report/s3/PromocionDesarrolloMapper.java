package mx.edu.unpa.reporteanualdocente.mappers.report.s3;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.request.PromocionDesarrolloRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s3.response.PromocionDesarrolloResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s3.PromocionDesarrollo;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PromocionDesarrolloMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    PromocionDesarrollo toEntity(PromocionDesarrolloRequestDTO dto);

    PromocionDesarrolloResponseDTO toDTO(PromocionDesarrollo entity);

    List<PromocionDesarrolloResponseDTO> toDTOList(List<PromocionDesarrollo> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}