package com.readysetgo.traveltracker.marker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerJpaEntity;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerRepository;
import com.readysetgo.traveltracker.marker.application.port.out.LoadMarkerPort;
import com.readysetgo.traveltracker.marker.domain.Marker;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadMarkerAdapter implements LoadMarkerPort {

    private final MarkerRepository markerRepository;

    @Override
    public Marker loadMarker(Long markerId) {
        MarkerJpaEntity marker = markerRepository.findById(markerId)
            .orElseThrow(RuntimeException::new);

        return Marker.of(
            marker.getId(),
            marker.getLocationName(),
            marker.getDiaryTitle(),
            marker.getDiaryContent(),
            marker.getLatitude(),
            marker.getLongitude()
        );
    }
}
