package com.readysetgo.traveltracker.marker.application.port.in;

import static com.readysetgo.traveltracker.common.util.ValidationUtils.validate;

import jakarta.validation.constraints.NotNull;

public record CreateMarkerCommand(
    @NotNull String locationName,
    @NotNull String diaryTitle,
    @NotNull String diaryContent,
    @NotNull Double latitude,
    @NotNull Double longitude
) {

    public CreateMarkerCommand {
        validate(this);
    }
}
