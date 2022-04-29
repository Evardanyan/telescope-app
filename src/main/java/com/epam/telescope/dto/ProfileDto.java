package com.epam.telescope.dto;

import com.epam.telescope.model.enums.JobStatus;
import com.epam.telescope.model.enums.Language;
import com.epam.telescope.model.enums.ProductionCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel(description = "Represents an info which is required to create a Profile")
@Data
public class ProfileDto {

    @ApiModelProperty(value = "profileId")
    private Long id;

    @ApiModelProperty(value = "First Name of the employee")
    @NotBlank
    private String firstName;

    @ApiModelProperty(value = "Last Name of the employee")
    @NotBlank
    private String lastName;

    @ApiModelProperty(value = "Email of the employee")
    @Email
    @NotBlank
    private String email;

    @ApiModelProperty(value = "Password of the employee")
    @NotNull
    private String password;

    @ApiModelProperty(value = "Is the employee an admin or not")
    @NotNull
    private boolean isAdmin;

    @ApiModelProperty(value = "Is the employee account enabled or not")
    @NotNull
    private boolean enabled;

    @ApiModelProperty(value = "job status of the employee")
    @NotNull
    private JobStatus jobStatus;

    @ApiModelProperty(value = "Production category of the employee")
    @NotNull
    private ProductionCategory productionCategory;

    @ApiModelProperty(value = "Job title of the employee")
    @NotBlank
    @Length(min = 3)
    private String jobFunction;

    @ApiModelProperty(value = "Primary skill id of the employee")
    @NotNull
    @Positive
    private Long primarySkill;

    @ApiModelProperty(value = "Native Language of the employee")
    @NotNull
    private Language nativeLanguage;
}
