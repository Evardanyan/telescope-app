package com.epam.telescope.service.impl;

import com.epam.telescope.dto.ProjectDto;
import com.epam.telescope.exception.EntityNotFoundException;
import com.epam.telescope.mapper.ProjectMapper;
import com.epam.telescope.model.Project;
import com.epam.telescope.repository.ProjectRepository;
import com.epam.telescope.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectDto> findAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto addProject(ProjectDto projectDto) {
        Project project = projectMapper.projectDtotoProject(projectDto);
        projectRepository.save(project);
        return projectMapper.projectToProjectDto(project);
    }

    @Override
    public ProjectDto getProject(Long id) {
        return projectMapper.projectToProjectDto(projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There was no Project with id: " + id)));
    }

    @Override
    public ProjectDto addProfileToProject(ProjectDto projectDto, Long profileId) {
        Project project = projectRepository.findById(projectDto.getId()).orElseThrow(() -> new EntityNotFoundException("There was no Project with id: " + projectDto.getId()));
        project.getAssignedProfileIds().add(profileId);
        projectRepository.save(project);
        return projectMapper.projectToProjectDto(project);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        Project project = projectRepository.findById(projectDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("There was no Project with id: " + projectDto.getId()));
        projectMapper.updateProject(projectDto, project);
        return projectMapper.projectToProjectDto(projectRepository.save(project));
    }

    @Override
    public boolean deleteProject(Long id) {
        projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There was no Project with id: " + id));
        projectRepository.deleteById(id);
        return true;
    }
}
