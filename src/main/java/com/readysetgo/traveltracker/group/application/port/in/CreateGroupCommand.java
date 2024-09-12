package com.readysetgo.traveltracker.group.application.port.in;

import static com.readysetgo.traveltracker.common.util.ValidationUtils.validate;

import jakarta.validation.constraints.NotNull;

public record CreateGroupCommand(
    @NotNull String destination,
    @NotNull String title,
    @NotNull String password,
    @NotNull String thumbnailUrl
) {

    public CreateGroupCommand {
        validate(this);
    }
}
