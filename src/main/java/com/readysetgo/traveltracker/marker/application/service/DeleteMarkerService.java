package com.readysetgo.traveltracker.marker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.marker.application.port.in.DeleteMarkerUseCase;
import com.readysetgo.traveltracker.marker.application.port.out.DeleteMarkerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class DeleteMarkerService implements DeleteMarkerUseCase {

    private final DeleteMarkerPort deleteMarkerPort;

    @Override
    public boolean deleteMarker(Long markerId) {
        return deleteMarkerPort.deleteMarker(markerId);
    }
}
