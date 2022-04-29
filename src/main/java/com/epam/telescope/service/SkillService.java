package com.epam.telescope.service;

import com.epam.telescope.dto.SkillDto;
import com.epam.telescope.model.Skill;

import java.util.List;

public interface SkillService {

    SkillDto getSkillById(Long id);

    Skill getSkillEntity(Long id);

    SkillDto addSkill(SkillDto skillDto);

    SkillDto updateSkill(SkillDto skillDto);

    boolean deleteSkillById(Long id);

    List<SkillDto> getAllSkills();
}