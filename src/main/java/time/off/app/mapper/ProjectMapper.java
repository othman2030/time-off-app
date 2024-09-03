package time.off.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import time.off.app.dto.ProjectDTO;
import time.off.app.model.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "projectDTO.label", target = "label")

    @Mapping(source = "projectDTO.startDate", target = "startDate",dateFormat = "dd-MM-yyyy")
    @Mapping(source = "projectDTO.endDate", target = "endDate",dateFormat = "dd-MM-yyyy")
    Project projectDTOToProject(ProjectDTO projectDTO);
}
