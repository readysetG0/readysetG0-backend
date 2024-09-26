package com.readysetgo.traveltracker.group.application.port.out;

import static com.readysetgo.traveltracker.common.util.ValidationUtils.validate;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record UpdateGroupOutCommand(
    @NotNull Long groupId,
    @NotNull String destination,
    @NotNull LocalDateTime startDate,
    @NotNull LocalDateTime endDate,
    @NotNull String title,
    @NotNull String password,
    @NotNull String thumbnailImageUrl
) {

    public UpdateGroupOutCommand(
        Long groupId,
        String destination,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String title,
        String password,
        String thumbnailImageUrl
    ) {
        this.groupId = groupId;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.password = password;
        this.thumbnailImageUrl = thumbnailImageUrl;

        validate(this);
    }
}