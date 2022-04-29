package com.epam.telescope.mapper;

import com.epam.telescope.dto.SkillDto;
import com.epam.telescope.model.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    @Mapping(target = "id", ignore = true)
    void updateSkill(SkillDto skillDto, @MappingTarget Skill skill);

    SkillDto skillToSkillDto(Skill skill);

    List<SkillDto> toSkillDtos(List<Skill> skills);

    Skill skillDtoToSkill(SkillDto skillDto);
}
