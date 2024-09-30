package com.readysetgo.traveltracker.maker.application.port.in;

import static com.readysetgo.traveltracker.common.util.ValidationUtils.validate;

import jakarta.validation.constraints.NotNull;

public record CreateMakerCommand(
    @NotNull String locationName,
    @NotNull String diaryTitle,
    @NotNull String diaryContent,
    @NotNull Double latitude,
    @NotNull Double longitude
) {

    public CreateMakerCommand {
        validate(this);
    }
}
