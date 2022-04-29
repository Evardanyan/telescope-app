package com.epam.telescope.mapper;

import com.epam.telescope.dto.ProfileDto;
import com.epam.telescope.model.Profile;
import com.epam.telescope.model.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "generalInfo.jobFunction", source = "profileDto.jobFunction")
    @Mapping(target = "generalInfo.productionCategory", source = "profileDto.productionCategory")
    @Mapping(target = "generalInfo.jobStatus", source = "profileDto.jobStatus")
    @Mapping(target = "generalInfo.primarySkill.id", source = "skill.id")
    @Mapping(target = "personalInfo.nativeName",
            expression = "java(profileDto.getFirstName() + \" \" + profileDto.getLastName())")
    Profile ProfileDtoToProfile(ProfileDto profileDto, Skill skill);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "jobFunction", source = "generalInfo.jobFunction")
    @Mapping(target = "productionCategory", source = "generalInfo.productionCategory")
    @Mapping(target = "jobStatus", source = "generalInfo.jobStatus")
    @Mapping(target = "primarySkill", source = "generalInfo.primarySkill.id")
    ProfileDto ProfileToProfileDto(Profile profile);
}
