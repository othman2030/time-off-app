package time.off.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import time.off.app.dto.ProjectDTO;
import time.off.app.service.ProjectService;

@Slf4j
@RestController
@Tag(name = "Project Service", description = "Handle projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService)
    {
        this.projectService = projectService;
    }

    @Operation(summary = "Save new Project", description = "Project")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "error")
    })


    @RequestMapping(value = "project/save",
            produces = "application/json", consumes = "application/json",
            method = RequestMethod.POST)
    public void saveEmployee(@RequestBody ProjectDTO projectDTO) {

        projectService.saveOrUpdateProject(projectDTO);
    }
}
