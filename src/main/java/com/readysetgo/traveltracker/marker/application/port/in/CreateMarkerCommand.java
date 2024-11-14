package com.readysetgo.traveltracker.marker.application.port.in;

import com.readysetgo.traveltracker.common.annotation.BuilderValidator;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@BuilderValidator
public record CreateMarkerCommand(
    @NotNull String locationName,
    @NotNull String diaryTitle,
    @NotNull String diaryContent,
    @NotNull Double latitude,
    @NotNull Double longitude
) {
}
