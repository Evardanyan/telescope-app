package com.epam.telescope.service.impl;

import com.epam.telescope.dto.PastProjectDto;
import com.epam.telescope.mapper.PastProjectMapper;
import com.epam.telescope.model.PastProject;
import com.epam.telescope.model.Profile;
import com.epam.telescope.repository.PastProjectRepository;
import com.epam.telescope.service.PastProjectService;
import com.epam.telescope.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PastProjectServiceImpl implements PastProjectService {

    private final PastProjectRepository pastProjectRepository;
    private final PastProjectMapper pastProjectMapper;
    private final ProfileService profileService;

    @Override
    public List<PastProject> findAll() {
        return pastProjectRepository.findAll();
    }

    @Override
    public PastProjectDto addPastProject(PastProjectDto pastProjectDto) {
        final Profile profile = profileService.getProfileEntity(pastProjectDto.getProfileId());

        var pastProject = pastProjectMapper.pastProjectDtoToPastProject(pastProjectDto, profile);
        pastProject.setProfile(profile);

        return pastProjectMapper.pastProjectToPastProjectDto(pastProjectRepository.save(pastProject));
    }

    @Override
    public PastProject getPastProject(Long id) {
        return pastProjectRepository.getById(id);
    }

    @Override
    public void updatePastProject(PastProject pastProject) {
        pastProjectRepository.save(pastProject);
    }

    @Override
    public void deletePastProject(Long id) {
        pastProjectRepository.deleteById(id);
    }
}