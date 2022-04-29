package com.epam.telescope.service.impl;

import com.epam.telescope.dto.GeneralInfoDto;
import com.epam.telescope.mapper.GeneralInfoMapper;
import com.epam.telescope.model.GeneralInfo;
import com.epam.telescope.model.Profile;
import com.epam.telescope.repository.GeneralInfoRepository;
import com.epam.telescope.service.GeneralInfoService;
import com.epam.telescope.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneralInfoServiceImpl implements GeneralInfoService {

    private final GeneralInfoRepository generalInfoRepository;
    private final ProfileService profileService;
    private final GeneralInfoMapper generalInfoMapper;

    @Override
    public GeneralInfo getGeneralInfoById(Long id) {
        return generalInfoRepository.getById(id);
    }

    @Override
    public void addGeneralInfo(GeneralInfo generalInfo) {
        if (generalInfo != null) {
            generalInfoRepository.save(generalInfo);
        }
    }

    @Override
    public GeneralInfoDto updateGeneralInfo(GeneralInfoDto generalInfoDto) {
        final Profile profile = profileService.getProfileEntity(generalInfoDto.getProfileId());

        GeneralInfo generalInfo = profile.getGeneralInfo();
        generalInfoMapper.updateGeneralInfo(generalInfoDto, generalInfo);

        return generalInfoMapper.generalInfoToGeneralInfoDto(generalInfoRepository.save(generalInfo));
    }

    @Override
    public void deleteGeneralInfoById(Long id) {
        generalInfoRepository.deleteById(id);
    }

    @Override
    public List<GeneralInfo> getAllGeneralInfo() {
        return generalInfoRepository.findAll();
    }
}