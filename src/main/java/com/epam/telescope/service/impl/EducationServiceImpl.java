package com.epam.telescope.service.impl;

import com.epam.telescope.model.Education;
import com.epam.telescope.repository.EducationRepository;
import com.epam.telescope.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository repository;

    @Override
    public List<Education> findAll() {
        return repository.findAll();
    }

    @Override
    public void addEducation(Education education) {
        repository.save(education);
    }

    @Override
    public Education getEducation(Long id) {
        return repository.getById(id);
    }

    @Override
    public void updateEducation(Education education) {
        repository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        repository.deleteById(id);
    }
}