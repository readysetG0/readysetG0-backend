package com.readysetgo.traveltracker.marker.application.port.out;

import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerCommand;

public interface CreateMarkerPort {

    Long createMarker(CreateMarkerCommand command);
}
