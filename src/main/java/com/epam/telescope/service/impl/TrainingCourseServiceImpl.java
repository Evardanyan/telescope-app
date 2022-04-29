package com.epam.telescope.service.impl;

import com.epam.telescope.dto.TrainingCourseDto;
import com.epam.telescope.mapper.TrainingCourseMapper;
import com.epam.telescope.model.Profile;
import com.epam.telescope.model.TrainingCourse;
import com.epam.telescope.repository.TrainingCourseRepository;
import com.epam.telescope.service.ProfileService;
import com.epam.telescope.service.TrainingCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingCourseServiceImpl implements TrainingCourseService {

    private final TrainingCourseRepository trainingCourseRepository;
    private final TrainingCourseMapper trainingCourseMapper;
    private final ProfileService profileService;

    @Override
    public List<TrainingCourse> findAll() {
        return trainingCourseRepository.findAll();
    }

    @Override
    public TrainingCourseDto addTrainingCourse(TrainingCourseDto trainingCourseDto) {
        final Profile profile = profileService.getProfileEntity(trainingCourseDto.getProfileId());

        var trainingCourse =
                trainingCourseMapper.trainingCourseDtoToTrainingCourse(trainingCourseDto, profile);
        trainingCourse.setProfile(profile);

        return trainingCourseMapper.trainingCourseToTrainingCourseDto(trainingCourseRepository.save(trainingCourse));
    }

    @Override
    public TrainingCourse getTrainingCourse (Long id) {
        return trainingCourseRepository.getById(id);
    }

    @Override
    public void updateTrainingCourse(TrainingCourse trainingCourse) {
        trainingCourseRepository.save(trainingCourse);
    }

    @Override
    public void deleteTrainingCourse(Long id) {
        trainingCourseRepository.deleteById(id);
    }
}
