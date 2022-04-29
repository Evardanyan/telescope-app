package com.epam.telescope.service;

import com.epam.telescope.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    List<ProjectDto> findAll();

    ProjectDto addProject(ProjectDto projectDto);

    ProjectDto getProject(Long id);

    ProjectDto updateProject(ProjectDto project);

    ProjectDto addProfileToProject(ProjectDto projectDto, Long profileId);

    boolean deleteProject(Long id);
}
