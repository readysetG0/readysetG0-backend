package com.readysetgo.traveltracker.marker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.marker.adapter.in.web.request.CreateMarkerRequest;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.in.UpdateMarkerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateMarkerController {

    private final UpdateMarkerUseCase updateMarkerUseCase;

    @PutMapping("/v1/markers/{markerId}")
    public Boolean updateMarker(
        @PathVariable Long markerId,
        @RequestBody CreateMarkerRequest request
    ) {
        UpdateMarkerCommand command = new UpdateMarkerCommand(
            markerId,
            request.locationName(),
            request.diaryTitle(),
            request.diaryContent()
        );

        return updateMarkerUseCase.updateMarker(command);
    }
}
