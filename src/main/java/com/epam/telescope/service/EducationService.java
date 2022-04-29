package com.epam.telescope.service;

import com.epam.telescope.model.Education;
import java.util.List;

public interface EducationService {

    List<Education> findAll();

    void addEducation(Education education);

    Education getEducation(Long id);

    void updateEducation(Education education);

    void deleteEducation(Long id);
}