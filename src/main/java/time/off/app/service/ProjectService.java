package time.off.app.service;

import org.springframework.stereotype.Service;
import time.off.app.dao.ProjectRepository;
import time.off.app.dto.ProjectDTO;
import time.off.app.mapper.ProjectMapper;
import time.off.app.model.Project;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository,ProjectMapper projectMapper)
    {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public void saveOrUpdateProject(ProjectDTO projectDTO)
    {
       Project project = projectMapper.projectDTOToProject(projectDTO);
       projectRepository.save(project);
    }
}
