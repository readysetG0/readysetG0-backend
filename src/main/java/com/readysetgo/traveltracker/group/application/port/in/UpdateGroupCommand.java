package com.readysetgo.traveltracker.group.application.port.in;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record UpdateGroupCommand(
        @NotNull Long groupId,
        @NotNull String destination,
        @NotNull LocalDateTime startDate,
        @NotNull LocalDateTime endDate,
        @NotNull String title,
        @NotNull String password,
        @NotNull String thumbnailUrl
) {

}
