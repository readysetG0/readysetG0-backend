package com.readysetgo.traveltracker.marker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerUseCase;
import com.readysetgo.traveltracker.marker.application.port.out.UpdateMarkerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpdateMarkerService implements UpdateMarkerUseCase {

    private final UpdateMarkerPort updateMarkerPort;

    @Override
    public boolean updateMarker(UpdateMarkerCommand command) {
        return updateMarkerPort.updateMarker(command);
    }
}
