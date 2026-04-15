package mx.edu.unpa.reporteanualdocente.mappers.report.s2;

import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.Tutoria.request.TutoriaRequestDTO;
import mx.edu.unpa.reporteanualdocente.DTOs.report.s2.Tutoria.response.TutoriaResponseDTO;
import mx.edu.unpa.reporteanualdocente.domains.report.ReporteAnual;
import mx.edu.unpa.reporteanualdocente.domains.report.s2.Tutoria;
import org.springframework.web.bind.annotation.Mapping;


import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TutoriaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reporte", source = "reporteId", qualifiedByName = "mapReporte")
    Tutoria toEntity(TutoriaRequestDTO dto);

    TutoriaResponseDTO toDTO(Tutoria entity);

    List<TutoriaResponseDTO> toDTOList(List<Tutoria> list);

    @Named("mapReporte")
    default ReporteAnual mapReporte(Integer id) {
        if (id == null) return null;
        ReporteAnual r = new ReporteAnual();
        r.setId(id);
        return r;
    }
}
