package com.readysetgo.traveltracker.maker.application.port.in;

import jakarta.validation.constraints.NotNull;

public record UpdateMakerCommand(
    @NotNull Long markerId,
    @NotNull String locationName,
    @NotNull String diaryTitle,
    @NotNull String diaryContent
) {

}
