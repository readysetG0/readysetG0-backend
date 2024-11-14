package com.readysetgo.traveltracker.marker.application.port.in;

import com.readysetgo.traveltracker.marker.adapter.in.web.response.CreateMarkerResponse;

public interface CreateMarkerUseCase {

    CreateMarkerResponse createMarker(CreateMarkerCommand command);
}
