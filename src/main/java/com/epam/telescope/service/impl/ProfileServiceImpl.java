package com.epam.telescope.service.impl;

import com.epam.telescope.dto.ProfileDto;
import com.epam.telescope.mapper.ProfileMapper;
import com.epam.telescope.model.EmailConfirmationToken;
import com.epam.telescope.model.Profile;
import com.epam.telescope.model.Skill;
import com.epam.telescope.model.enums.Language;
import com.epam.telescope.model.enums.LanguageLevel;
import com.epam.telescope.model.enums.Role;
import com.epam.telescope.repository.ProfileRepository;
import com.epam.telescope.service.EmailConfirmationTokenService;
import com.epam.telescope.service.EmailSenderService;
import com.epam.telescope.service.ProfileService;
import com.epam.telescope.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.epam.telescope.model.enums.Role.ADMIN;
import static com.epam.telescope.model.enums.Role.USER;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService, UserDetailsService {

    private final ProfileRepository profileRepository;
    private final SkillService skillService;
    private final ProfileMapper profileMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailConfirmationTokenService emailConfirmationTokenService;
    private final EmailSenderService emailSenderService;

    @Value("${email.confirmation.token.link}")
    private String confirmationLinkBase;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Profile user = profileRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
        Role role = user.isAdmin() ? ADMIN : USER;
        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(role.name()))
        );
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public ProfileDto registerProfile(ProfileDto profileDto) {
        final Skill primarySkill = skillService.getSkillEntity(profileDto.getPrimarySkill());

        Profile profile = profileMapper.ProfileDtoToProfile(profileDto, primarySkill);

        HashMap<Language, LanguageLevel> languages = new HashMap<>();
        languages.put(profileDto.getNativeLanguage(), LanguageLevel.C2);
        profile.getGeneralInfo().setLanguages(languages);
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));

        Profile savedProfile = profileRepository.save(profile);

        EmailConfirmationToken confirmationToken = emailConfirmationTokenService.generateToken(savedProfile);
        emailConfirmationTokenService.saveEmailConfirmationToken(confirmationToken);

        emailSenderService.send(
                savedProfile.getEmail(),
                emailSenderService.buildEmail(savedProfile.getFirstName(),
                        confirmationLinkBase + confirmationToken.getToken()));

        return profileMapper.ProfileToProfileDto(savedProfile);
    }

    @Override
    public ProfileDto getProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return profileMapper.ProfileToProfileDto(profile);
    }

    @Override
    public Profile getProfileEntity(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void updateProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile getProfileByEmail(String email) {
        return profileRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
    }
}