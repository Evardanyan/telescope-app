package com.epam.telescope.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "Represents an info which is required to add a child")
@Data
public class ChildDto {

    @ApiModelProperty(value = "childId")
    private Long id;

    @ApiModelProperty(value = "First name of the child")
    @NotBlank
    private String firstName;

    @ApiModelProperty(value = "Last name of the child")
    @NotBlank
    private String lastName;

    @ApiModelProperty(value = "Middle name of the child")
    private String middleName;

    @ApiModelProperty(value = "Birthday of the child")
    private Date birthday;
}
