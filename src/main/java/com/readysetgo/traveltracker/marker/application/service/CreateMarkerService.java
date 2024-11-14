package com.readysetgo.traveltracker.marker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.marker.adapter.in.web.response.CreateMarkerResponse;
import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerUseCase;
import com.readysetgo.traveltracker.marker.application.port.out.CreateMarkerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateMarkerService implements CreateMarkerUseCase {

    private final CreateMarkerPort createMarkerPort;

    @Override
    public CreateMarkerResponse createMarker(CreateMarkerCommand command) {
        return new CreateMarkerResponse(createMarkerPort.createMarker(command));
    }
}
