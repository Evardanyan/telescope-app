package com.epam.telescope.mapper;

import com.epam.telescope.dto.ProjectDto;
import com.epam.telescope.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProject(ProjectDto skillDto, @MappingTarget Project project);

    ProjectDto projectToProjectDto(Project project);

    Project projectDtotoProject(ProjectDto projectDto);
}
