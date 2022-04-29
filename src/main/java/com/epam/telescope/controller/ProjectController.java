package com.epam.telescope.controller;

import com.epam.telescope.dto.ProjectDto;
import com.epam.telescope.service.ProjectService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Api(value = "Project service rest API")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@Positive @PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @ApiOperation(
            value = "Create a new Project",
            response = ProjectDto.class,
            tags = "project-controller")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Ok, Created"),
                    @ApiResponse(code = 400, message = "Bad Request")
            })
    @PostMapping
    public ResponseEntity<ProjectDto> addProject(@Valid @RequestBody ProjectDto projectDto) {
        ProjectDto addedProject = projectService.addProject(projectDto);
        return ResponseEntity.ok(addedProject);
    }

    @ApiOperation(
            value = "Update a Project",
            response = ProjectDto.class,
            tags = "project-controller")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Ok, Created"),
                    @ApiResponse(code = 400, message = "Bad Request")
            })
    @PutMapping
    public ResponseEntity<ProjectDto> updateProject(@Valid @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProject(projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @ApiOperation(
            value = "Associate profile to the project",
            response = ProjectDto.class,
            tags = "project-controller")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Ok, Created"),
                    @ApiResponse(code = 400, message = "Bad Request")
            })
    @PutMapping("/{profileId}")
    public ResponseEntity<ProjectDto> updateProject(@Valid @NotNull @RequestBody ProjectDto projectDto, @Positive @PathVariable Long profileId) {
        return ResponseEntity.ok(projectService.addProfileToProject(projectDto, profileId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@Positive @PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}