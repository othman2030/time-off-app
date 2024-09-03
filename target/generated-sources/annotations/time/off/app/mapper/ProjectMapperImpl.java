package time.off.app.mapper;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import time.off.app.dto.ProjectDTO;
import time.off.app.model.Line;
import time.off.app.model.Project;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T15:38:23+0200",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project projectDTOToProject(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        String label = null;
        Date startDate = null;
        Date endDate = null;

        label = projectDTO.getLabel();
        startDate = projectDTO.getStartDate();
        endDate = projectDTO.getEndDate();

        List<Line> lines = null;

        Project project = new Project( label, startDate, endDate, lines );

        return project;
    }
}
