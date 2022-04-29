package com.epam.telescope.mapper;

import com.epam.telescope.dto.GeneralInfoDto;
import com.epam.telescope.model.GeneralInfo;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface GeneralInfoMapper {

    @Mapping(target = "id", ignore = true)
    void updateGeneralInfo(GeneralInfoDto generalInfoDto, @MappingTarget GeneralInfo GeneralInfo);

    GeneralInfoDto generalInfoToGeneralInfoDto(GeneralInfo generalInfo);
}