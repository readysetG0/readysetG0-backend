package com.readysetgo.traveltracker.group.adapter.in.web.request;

import java.time.LocalDateTime;

public record UpdateGroupRequest(
    String destination,
    LocalDateTime startDate,
    LocalDateTime endDate,
    String title,
    String password
) {

}
