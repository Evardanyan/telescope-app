package com.epam.telescope.mapper;

import com.epam.telescope.dto.PastProjectDto;
import com.epam.telescope.model.PastProject;
import com.epam.telescope.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PastProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profile.id", source = "profile.id")
    PastProject pastProjectDtoToPastProject(PastProjectDto pastProjectDto, Profile profile);

    @Mapping(target = "profileId", source = "profile.id")
    PastProjectDto pastProjectToPastProjectDto(PastProject pastProject);
}