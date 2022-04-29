package com.epam.telescope.dto;

import com.epam.telescope.model.enums.JobFunctionLevel;
import com.epam.telescope.model.enums.JobStatus;
import com.epam.telescope.model.enums.Language;
import com.epam.telescope.model.enums.LanguageLevel;
import com.epam.telescope.model.enums.ProductionCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

import java.util.Map;
import org.hibernate.validator.constraints.Length;

@ApiModel(description = "Represents an info which is required to add a general info")
@Data
public class GeneralInfoDto {

     @ApiModelProperty(value = "generalInfoId")
     private Long id;

     @ApiModelProperty(value = "job status of the employee")
     private JobStatus jobStatus;

     @ApiModelProperty(value = "Production category of the employee")
     private ProductionCategory productionCategory;

     @ApiModelProperty(value = "Job title of the employee")
     @NotBlank
     @Length(min = 3)
     private String jobFunction;

     @ApiModelProperty(value = "Job function level of the employee")
     private JobFunctionLevel jobFunctionLevel;

     @ApiModelProperty(value = "Unit of the employee")
     @NotBlank
     private String unit;

     @ApiModelProperty(value = "Unit manager of the employee")
     @NotBlank
     private String unitManager;

     @ApiModelProperty(value = "Uid of the employee")
     private Long uid;

     @ApiModelProperty(value = "The profileId of the profile associated with the general info")
     @NotNull
     @Positive
     private Long profileId;

     @ApiModelProperty(value = "Language-level map of the employee")
     @NotEmpty
     private Map<Language, LanguageLevel> languages;
}
