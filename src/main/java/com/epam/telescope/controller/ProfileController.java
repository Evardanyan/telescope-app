package com.epam.telescope.controller;

import com.epam.telescope.dto.GeneralInfoDto;
import com.epam.telescope.dto.PastProjectDto;
import com.epam.telescope.dto.PersonalInfoDto;
import com.epam.telescope.dto.ProfileDto;
import com.epam.telescope.dto.TrainingCourseDto;
import com.epam.telescope.service.GeneralInfoService;
import com.epam.telescope.service.PastProjectService;
import com.epam.telescope.service.PersonalInfoService;
import com.epam.telescope.service.ProfileService;
import com.epam.telescope.service.TrainingCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Api(value = "Profile service rest API")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final PastProjectService pastProjectService;
    private final TrainingCourseService trainingCourseService;
    private final PersonalInfoService personalInfoService;
    private final GeneralInfoService generalInfoService;

    @ApiOperation(
        value = "Create a new Profile",
        response = ProfileDto.class,
        tags = "profile-controller")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok, Created"),
            @ApiResponse(code = 400, message = "Bad Request")
        })
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ProfileDto> registerProfile(@Valid @RequestBody ProfileDto profileDto) {
        var body = profileService.registerProfile(profileDto);

        return ResponseEntity.ok(body);
    }

    @ApiOperation(
        value = "Associate a past project with a profile",
        response = PastProjectDto.class,
        tags = "profile-controller")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok, Created"),
            @ApiResponse(code = 400, message = "Bad Request")
        })
    @PostMapping("/past-project")
    public ResponseEntity<PastProjectDto> addPastProject(@Valid @RequestBody PastProjectDto pastProjectDto) {
        var body = pastProjectService.addPastProject(pastProjectDto);

        return ResponseEntity.ok(body);
    }

    @ApiOperation(
        value = "Associate a training course with a profile",
        response = TrainingCourseDto.class,
        tags = "profile-controller")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok, Created"),
            @ApiResponse(code = 400, message = "Bad Request")
        })
    @PostMapping("/training-course")
    public ResponseEntity<TrainingCourseDto> addTrainingCourse(@Valid @RequestBody TrainingCourseDto trainingCourseDto) {
        var body = trainingCourseService.addTrainingCourse(trainingCourseDto);

        return ResponseEntity.ok(body);
    }

    @ApiOperation(
        value = "Update personal info of a profile",
        response = PersonalInfoDto.class,
        tags = "profile-controller")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok, Created"),
            @ApiResponse(code = 400, message = "Bad Request")
        })
    @PutMapping("/personal-info")
    public ResponseEntity<PersonalInfoDto> updatePersonalInfo(@Valid @RequestBody PersonalInfoDto personalInfoDto) {
        var body = personalInfoService.updatePersonalInfo(personalInfoDto);

        return ResponseEntity.ok(body);
    }

    @ApiOperation(
        value = "Update general info of a profile",
        response = GeneralInfoDto.class,
        tags = "profile-controller")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Ok, Created"),
            @ApiResponse(code = 400, message = "Bad Request")
        })
    @PutMapping("/general-info")
    public ResponseEntity<GeneralInfoDto> updateGeneralInfo(@Valid @RequestBody GeneralInfoDto generalInfoDto) {
        var body = generalInfoService.updateGeneralInfo(generalInfoDto);

        return ResponseEntity.ok(body);
    }
}
