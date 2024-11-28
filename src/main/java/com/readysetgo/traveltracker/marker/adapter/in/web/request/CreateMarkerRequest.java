package com.readysetgo.traveltracker.marker.adapter.in.web.request;

import lombok.Builder;

@Builder
public record CreateMarkerRequest(
    String locationName,
    String diaryTitle,
    String diaryContent,
    Double latitude,
    Double longitude
) {

}
