package com.epam.telescope.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;
import org.hibernate.validator.constraints.Length;

@ApiModel(description = "Represents an info which is required to add a training course")
@Data
public class TrainingCourseDto {

     @ApiModelProperty(value = "trainingCourseId")
     private Long id;

     @ApiModelProperty(value = "Start of the training course")
     private Date start;

     @ApiModelProperty(value = "End of the training course")
     private Date end;

     @ApiModelProperty(value = "Category of the training course")
     @NotBlank
     private String category;

     @ApiModelProperty(value = "Description of the training course")
     @NotBlank
     @Length(min = 30)
     private String description;

     @ApiModelProperty(value = "Estimated duration of the training course")
     private String duration;

     @ApiModelProperty(value = "Requirements for participating to the training course")
     @NotBlank
     private String requirements;

     @ApiModelProperty(value = "Topic of the training course")
     @NotBlank
     private String topic;

     @ApiModelProperty(value = "Technologies which are needed for the training course")
     @NotBlank
     private String technologies;

     @ApiModelProperty(value = "Level of the training course")
     @NotBlank
     private String level;

     @ApiModelProperty(value = "The profileId of the profile associated with the training course")
     @NotNull
     @Positive
     private Long profileId;
}
