package com.readysetgo.traveltracker.marker.application.port.in;

import jakarta.validation.constraints.NotNull;

public record UpdateMarkerCommand(
    @NotNull Long markerId,
    @NotNull String locationName,
    @NotNull String diaryTitle,
    @NotNull String diaryContent
) {

}
