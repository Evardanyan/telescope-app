package com.epam.telescope.service;

import com.epam.telescope.dto.ProfileDto;
import com.epam.telescope.model.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> findAll();

    ProfileDto registerProfile(ProfileDto profileDto);

    ProfileDto getProfile(Long id);

    Profile getProfileEntity(Long id);

    void updateProfile(Profile profile);

    void deleteProfile(Long id);

    Profile getProfileByEmail(String email);
}