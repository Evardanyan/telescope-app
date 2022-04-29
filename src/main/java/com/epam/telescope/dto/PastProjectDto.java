package com.epam.telescope.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;
import org.hibernate.validator.constraints.Length;

@ApiModel(description = "Represents an info which is required to add a past project")
@Data
public class PastProjectDto {

    @ApiModelProperty(value = "pastProjectId")
    private Long id;

    @ApiModelProperty(value = "Start of the past project")
    private Date start;

    @ApiModelProperty(value = "End of the past project")
    private Date end;

    @ApiModelProperty(value = "The customer of the past project")
    @NotBlank
    private String customer;

    @ApiModelProperty(value = "Description of the past project with at least 30 symbols")
    @NotBlank
    @Length(min = 30)
    private String description;

    @ApiModelProperty(value = "The company name of the past project")
    @NotBlank
    private String companyName;

    @ApiModelProperty(value = "The company url of the past project")
    private String companyUrl;

    @ApiModelProperty(value = "Tools which were needed during the past project")
    @NotBlank
    private String tools;

    @ApiModelProperty(value = "Technologies which were used during the past project")
    @NotBlank
    private String technologies;

    @ApiModelProperty(value = "A short description (at least 50 symbols) about the participation of the employee in the past project")
    @NotBlank
    @Length(min = 50)
    private String participation;

    @ApiModelProperty(value = "Job position of the employee during the past project")
    @NotBlank
    private String jobPosition;

    @ApiModelProperty(value = "Database name(s) which was used in the past project")
    private String database;

    @ApiModelProperty(value = "Team members of the past project")
    private String team;

    @ApiModelProperty(value = "The profileId of the profile associated with the past project")
    @NotNull
    @Positive
    private Long profileId;
}
