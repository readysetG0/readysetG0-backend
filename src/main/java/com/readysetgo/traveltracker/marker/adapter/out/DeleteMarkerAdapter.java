package com.readysetgo.traveltracker.marker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerRepository;
import com.readysetgo.traveltracker.marker.application.port.out.DeleteMarkerPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteMarkerAdapter implements DeleteMarkerPort {

    private final MarkerRepository markerRepository;

    @Override
    public Boolean deleteMarker(Long markerId) {
        markerRepository.deleteById(markerId);

        return true;
    }
}
