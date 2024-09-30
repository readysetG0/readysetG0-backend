package com.readysetgo.traveltracker.marker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerJpaEntity;
import com.readysetgo.traveltracker.marker.adapter.out.persistence.MarkerRepository;
import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.out.CreateMarkerPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class CreateMarkerAdapter implements CreateMarkerPort {

    private final MarkerRepository markerRepository;

    @Override
    public Long createMarker(CreateMarkerCommand command) {
        MarkerJpaEntity marker = createMarkerEntity(command);
        markerRepository.save(marker);

        return marker.getId();
    }

    private MarkerJpaEntity createMarkerEntity(CreateMarkerCommand command) {
        return MarkerJpaEntity.builder()
            .locationName(command.locationName())
            .diaryTitle(command.diaryTitle())
            .diaryContent(command.diaryContent())
            .latitude(command.latitude())
            .longitude(command.longitude())
            .build();
    }
}
