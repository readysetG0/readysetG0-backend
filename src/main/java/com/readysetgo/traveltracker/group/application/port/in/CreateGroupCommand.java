package com.readysetgo.traveltracker.group.application.port.in;

import static com.readysetgo.traveltracker.common.util.ValidationUtils.validate;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CreateGroupCommand(
    @NotNull String destination,
    @NotNull LocalDateTime startDate,
    @NotNull LocalDateTime endDate,
    @NotNull String title,
    @NotNull String password,
    @NotNull String thumbnailUrl
) {

    public CreateGroupCommand(
        String destination,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String title,
        String password,
        String thumbnailUrl
    ) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.password = password;
        this.thumbnailUrl = thumbnailUrl;

        validate(this);
    }
}
