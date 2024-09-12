package time.off.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import time.off.app.dto.LineDTO;
import time.off.app.model.Line;

@Mapper(componentModel = "spring")
public interface LineMapper {

    @Mapping(source = "line.label", target = "label")
    LineDTO LineTOLineDTO(Line line);

    @Mapping(source = "lineDTO.label", target = "label")
    Line LineDTOToLine(LineDTO lineDTO);
}
