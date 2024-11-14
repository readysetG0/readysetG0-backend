package com.readysetgo.traveltracker.marker.application.port.in;

import com.readysetgo.traveltracker.marker.adapter.in.web.response.GetMarkerInfoResponse;

public interface GetMarkerInfoQuery {

    GetMarkerInfoResponse getMarkerInfo(Long markerId);
}
