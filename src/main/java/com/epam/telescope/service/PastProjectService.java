package com.epam.telescope.service;

import com.epam.telescope.dto.PastProjectDto;
import com.epam.telescope.model.PastProject;

import java.util.List;

public interface PastProjectService {

    List<PastProject> findAll();

    PastProjectDto addPastProject(PastProjectDto PastProjectDto);

    PastProject getPastProject(Long id);

    void updatePastProject(PastProject pastProject);

    void deletePastProject(Long id);
}
