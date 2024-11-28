package com.readysetgo.traveltracker.marker.adapter.in.web.request;

import lombok.Builder;

@Builder
public record UpdateMarkerRequest(
    String locationName,
    String diaryTitle,
    String diaryContent
) {

}
