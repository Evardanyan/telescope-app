package com.epam.telescope.service;

import com.epam.telescope.dto.PersonalInfoDto;
import com.epam.telescope.model.PersonalInfo;
import java.util.List;

public interface PersonalInfoService {

    List<PersonalInfo> findAll();

    void addPersonalInfo(PersonalInfo personalInfo);

    PersonalInfoDto getPersonalInfo(Long id);

    PersonalInfoDto updatePersonalInfo(PersonalInfoDto personalInfoDto);

    void deletePersonalInfo(Long id);
}