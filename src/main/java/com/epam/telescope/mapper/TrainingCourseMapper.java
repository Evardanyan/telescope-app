package com.epam.telescope.mapper;

import com.epam.telescope.dto.TrainingCourseDto;
import com.epam.telescope.model.Profile;
import com.epam.telescope.model.TrainingCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingCourseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profile.id", source = "profile.id")
    TrainingCourse trainingCourseDtoToTrainingCourse(TrainingCourseDto TrainingCourseDto, Profile profile);

    @Mapping(target = "profileId", source = "profile.id")
    TrainingCourseDto trainingCourseToTrainingCourseDto(TrainingCourse trainingCourse);
}