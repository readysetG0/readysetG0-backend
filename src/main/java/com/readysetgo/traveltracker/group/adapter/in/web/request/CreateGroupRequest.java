package com.readysetgo.traveltracker.group.adapter.in.web.request;

import java.time.LocalDateTime;

public record CreateGroupRequest(
    String destination,
    LocalDateTime startDate,
    LocalDateTime endDate,
    String title,
    String password,
    String thumbnailUrl
) {

}
