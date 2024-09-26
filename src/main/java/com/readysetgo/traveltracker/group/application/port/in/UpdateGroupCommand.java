package com.readysetgo.traveltracker.group.application.port.in;

import static com.readysetgo.traveltracker.common.util.ValidationUtils.validate;

import com.readysetgo.traveltracker.group.domain.ThumbnailImage;
import jakarta.validation.constraints.NotNull;
import java.io.InputStream;
import java.time.LocalDateTime;

public record UpdateGroupCommand(
    @NotNull Long groupId,
    @NotNull String destination,
    @NotNull LocalDateTime startDate,
    @NotNull LocalDateTime endDate,
    @NotNull String title,
    @NotNull String password,
    @NotNull ThumbnailImage thumbnailImage
) {

    public UpdateGroupCommand(
        Long groupId,
        String destination,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String title,
        String password,
        String fileName,
        String contentType,
        InputStream imageInputStream
    ) {
        this(
            groupId,
            destination,
            startDate,
            endDate,
            title,
            password,
            new ThumbnailImage(fileName, contentType, imageInputStream)
        );

        validate(this);
    }
}
