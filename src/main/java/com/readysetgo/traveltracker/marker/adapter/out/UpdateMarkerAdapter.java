package com.readysetgo.traveltracker.marker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerJpaEntity;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerRepository;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.out.UpdateMarkerPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateMarkerAdapter implements UpdateMarkerPort {

    private final MarkerRepository markerRepository;

    @Override
    public boolean updateMarker(UpdateMarkerCommand command) {
        MarkerJpaEntity marker = markerRepository.findById(command.markerId())
            .orElseThrow(RuntimeException::new);

        marker.updateInfo(
            command.locationName(),
            command.diaryTitle(),
            command.diaryContent()
        );

        return true;
    }
}
