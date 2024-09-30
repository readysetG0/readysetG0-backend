package com.readysetgo.traveltracker.marker.adapter.in.web.response;

public record GetMarkerInfoResponse(
    Long markerId,
    String locationName,
    String diaryTitle,
    String diaryContent,
    Double latitude,
    Double longitude
) {

}

