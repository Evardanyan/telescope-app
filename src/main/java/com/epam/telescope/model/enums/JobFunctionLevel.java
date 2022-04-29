package com.epam.telescope.model.enums;

public enum JobFunctionLevel {

    LEVEL_ONE("Level 1"),
    LEVEL_TWO("Level 2"),
    LEVEL_THREE("Level 3"),
    LEVEL_FOUR("Level 4");

    private String level;

    JobFunctionLevel(String showLevel) {
        this.level = showLevel;
    }

    public String getLevel() {
        return level;
    }
}