package com.readysetgo.traveltracker.maker.adapter.in.web.response;

public record GetMakerInfoResponse(
    Long makerId,
    String locationName,
    String diaryTitle,
    String diaryContent,
    Double latitude,
    Double longitude
) {

}

