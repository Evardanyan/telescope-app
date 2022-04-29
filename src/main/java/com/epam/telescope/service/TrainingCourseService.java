package com.epam.telescope.service;

import com.epam.telescope.dto.TrainingCourseDto;
import com.epam.telescope.model.TrainingCourse;
import java.util.List;

public interface TrainingCourseService {

    List<TrainingCourse> findAll();

    TrainingCourseDto addTrainingCourse(TrainingCourseDto trainingCourseDto);

    TrainingCourse getTrainingCourse(Long id);

    void updateTrainingCourse(TrainingCourse trainingCourse);

    void deleteTrainingCourse(Long id);
}
