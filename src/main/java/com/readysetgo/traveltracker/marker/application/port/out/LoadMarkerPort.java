package com.readysetgo.traveltracker.marker.application.port.out;

import com.readysetgo.traveltracker.marker.domain.Marker;

public interface LoadMarkerPort {

    Marker loadMarker(Long markerId);
}
