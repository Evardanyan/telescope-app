package com.epam.telescope.service.impl;

import com.epam.telescope.dto.PersonalInfoDto;
import com.epam.telescope.exception.EntityNotFoundException;
import com.epam.telescope.mapper.PersonalInfoMapper;
import com.epam.telescope.model.PersonalInfo;
import com.epam.telescope.model.Profile;
import com.epam.telescope.repository.PersonalInfoRepository;
import com.epam.telescope.service.PersonalInfoService;
import com.epam.telescope.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;
    private final ProfileService profileService;
    private final PersonalInfoMapper personalInfoMapper;
    
    @Override
    public List<PersonalInfo> findAll() {
        return personalInfoRepository.findAll();
    }

    @Override
    public void addPersonalInfo(PersonalInfo personalInfo) {
        personalInfoRepository.save(personalInfo);
    }

    @Override
    public PersonalInfoDto getPersonalInfo(Long id) {
        PersonalInfo personalInfo = personalInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There was no Personal Info with id: " + id));

        return personalInfoMapper.personalInfoToPersonalInfoDto(personalInfo);
    }

    @Override
    public PersonalInfoDto updatePersonalInfo(PersonalInfoDto personalInfoDto) {
        final Profile profile = profileService.getProfileEntity(personalInfoDto.getProfileId());

        PersonalInfo personalInfo = profile.getPersonalInfo();
        personalInfoMapper.updatePersonalInfo(personalInfoDto, personalInfo);

        personalInfo.getChildren().stream().forEach(child -> child.setPersonalInfo(personalInfo));
        personalInfo.getAddresses().stream().forEach(address -> address.setPersonalInfo(personalInfo));

        return personalInfoMapper.personalInfoToPersonalInfoDto(personalInfoRepository.save(personalInfo));
    }

    @Override
    public void deletePersonalInfo(Long id) {
        personalInfoRepository.deleteById(id);
    }
}