package com.readysetgo.traveltracker.maker.adapter.in.web.request;

public record CreateMakerRequest(
    String locationName,
    String diaryTitle,
    String diaryContent,
    Double latitude,
    Double longitude
) {

}
