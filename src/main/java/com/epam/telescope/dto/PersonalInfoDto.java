package com.epam.telescope.dto;

import com.epam.telescope.model.enums.Gender;
import com.epam.telescope.model.enums.TShirtSize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Represents an info which is required to add a personal info")
@Data
public class PersonalInfoDto {

    @ApiModelProperty(value = "personalInfoId")
    private Long id;

    @ApiModelProperty(value = "Native name of the employee")
    @NotBlank
    private String nativeName;

    @ApiModelProperty(value = "Gender of the employee")
    private Gender gender;

    @ApiModelProperty(value = "Birthday of the employee")
    private Date birthday;

    @ApiModelProperty(value = "Governmental Id of the employee")
    private String governmentalId;

    @ApiModelProperty(value = "Driver license Id of the employee")
    private String driverLicense;

    @ApiModelProperty(value = "TShirt Size Id of the employee")
    private TShirtSize tShirtSize;

    @ApiModelProperty(value = "Remote Work Possibility for the employee")
    @NotNull
    private boolean remoteWorkPossibility;

    @ApiModelProperty(value = "Phone number of the employee")
    @NotBlank
    private String phoneNumber;

    @ApiModelProperty(value = "The profileId of the profile associated with the personal info")
    @NotNull
    @Positive
    private Long profileId;

    @ApiModelProperty(value = "Children list of the employee")
    @Valid
    private List<ChildDto> childDtoList;

    @ApiModelProperty(value = "Addresses list of the employee")
    @Valid
    private List<AddressDto> addressDtoList;
}
