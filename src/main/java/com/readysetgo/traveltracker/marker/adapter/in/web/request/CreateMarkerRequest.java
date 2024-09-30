package com.readysetgo.traveltracker.marker.adapter.in.web.request;

public record CreateMarkerRequest(
    String locationName,
    String diaryTitle,
    String diaryContent,
    Double latitude,
    Double longitude
) {

}
