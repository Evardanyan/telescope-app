package com.epam.telescope.dto;

import com.epam.telescope.model.enums.SkillCategory;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SkillDto {

    private Long id;

    @NotNull
    private SkillCategory category;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Invalid Input")
    private String name;
}
