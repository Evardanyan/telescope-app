package com.epam.telescope.service;

import com.epam.telescope.dto.GeneralInfoDto;
import com.epam.telescope.model.GeneralInfo;
import java.util.List;

public interface GeneralInfoService {

    GeneralInfo getGeneralInfoById(Long id);

    void addGeneralInfo(GeneralInfo generalInf);

    GeneralInfoDto updateGeneralInfo(GeneralInfoDto generalInfoDto);

    void deleteGeneralInfoById(Long id);

    List<GeneralInfo> getAllGeneralInfo();
}