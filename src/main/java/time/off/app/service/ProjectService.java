package time.off.app.service;

import org.springframework.stereotype.Service;
import time.off.app.dao.ProjectRepository;
import time.off.app.dto.ProjectDTO;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }

    public void saveOrUpdateProject(ProjectDTO projectDTO)
    {

    }
}
