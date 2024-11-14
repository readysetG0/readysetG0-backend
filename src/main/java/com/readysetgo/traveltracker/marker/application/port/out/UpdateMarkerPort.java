package com.readysetgo.traveltracker.marker.application.port.out;

import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerCommand;

public interface UpdateMarkerPort {

    boolean updateMarker(UpdateMarkerCommand command);
}
