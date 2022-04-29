package com.epam.telescope.service.impl;

import com.epam.telescope.dto.SkillDto;
import com.epam.telescope.exception.EntityNotFoundException;
import com.epam.telescope.mapper.SkillMapper;
import com.epam.telescope.model.Skill;
import com.epam.telescope.repository.SkillRepository;
import com.epam.telescope.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public SkillDto getSkillById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There was no Skill with id: " + id));
        return skillMapper.skillToSkillDto(skill);
    }

    @Override
    public Skill getSkillEntity(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There was no Skill with id: " + id));
    }


    @Override
    public SkillDto addSkill(SkillDto skillDto) {
        Skill skill = skillMapper.skillDtoToSkill(skillDto);
        return skillMapper.skillToSkillDto(skillRepository.save(skill));
    }

    @Override
    public SkillDto updateSkill(SkillDto skillDto) {
        Skill skill = skillRepository.findById(skillDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("There was no Skill with id: " + skillDto.getId()));
        skillMapper.updateSkill(skillDto, skill);
        return skillMapper.skillToSkillDto(skillRepository.save(skill));
    }

    @Override
    public boolean deleteSkillById(Long id) {
        skillRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SkillDto> getAllSkills() {
        return skillMapper.toSkillDtos(skillRepository.findAll());
    }
}
