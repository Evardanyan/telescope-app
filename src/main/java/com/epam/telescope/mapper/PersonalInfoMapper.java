package com.epam.telescope.mapper;

import com.epam.telescope.dto.PersonalInfoDto;
import com.epam.telescope.model.PersonalInfo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface PersonalInfoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "children", source = "childDtoList")
    @Mapping(target = "addresses", source = "addressDtoList")
    void updatePersonalInfo(PersonalInfoDto personalInfoDto, @MappingTarget PersonalInfo PersonalInfo);

    @Mapping(target = "profileId", source = "profile.id")
    @Mapping(target = "childDtoList", source = "children")
    @Mapping(target = "addressDtoList", source = "addresses")
    PersonalInfoDto personalInfoToPersonalInfoDto(PersonalInfo personalInfo);
}