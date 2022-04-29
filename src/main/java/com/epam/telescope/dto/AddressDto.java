package com.epam.telescope.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@ApiModel(description = "Represents an info which is required to add an address")
@Data
public class AddressDto {

    @ApiModelProperty(value = "addressId")
    private Long id;

    @ApiModelProperty(value = "Category of the address")
    private String category;

    @ApiModelProperty(value = "Address territory of the employee")
    private String territory;

    @ApiModelProperty(value = "City of the employee")
    private String city;

    @ApiModelProperty(value = "Street of the employee")
    private String street;

    @ApiModelProperty(value = "Building of the employee")
    @NotNull
    @Positive
    private int building;

    @ApiModelProperty(value = "Room of the employee")
    private int room;

    @ApiModelProperty(value = "Zip code of the employee")
    @NotNull
    @Positive
    @Max(100000)
    private int zipCode;

    @ApiModelProperty(value = "Post office box code of the employee")
    private int postOfficeBox;

    @ApiModelProperty(value = "Is the address of the employee primary")
    @NotNull
    private boolean isPrimary;
}
