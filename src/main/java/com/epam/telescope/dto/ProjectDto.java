package com.epam.telescope.dto;

import com.epam.telescope.model.enums.ProjectHealthStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.Set;

@ApiModel(description = "Represents an info which is required to add a project")
@Data
public class ProjectDto {

    private Long id;

    @ApiModelProperty(value = "Project start date")
    @NotNull
    @PastOrPresent
    private Date startDate;

    @ApiModelProperty(value = "Project end date")
    @Future
    private Date endDate;

    @ApiModelProperty(value = "Project health status")
    @NotNull
    private ProjectHealthStatus projectHealth;

    @ApiModelProperty(value = "Project code")
    @NotBlank
    private String projectCode;

    @ApiModelProperty(value = "Project description")
    @NotBlank
    @Min(value = 50)
    private String description;

    @ApiModelProperty(value = "Project technologies")
    @Valid
    private Set<SkillDto> technologies;

    @ApiModelProperty(value = "Assigned profiles to the project")
    @Valid
    private Set<Long> assignedProfileIds;
}
