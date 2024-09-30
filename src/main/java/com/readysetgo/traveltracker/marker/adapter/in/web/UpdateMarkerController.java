package com.readysetgo.traveltracker.marker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.marker.adapter.in.web.request.UpdateMarkerRequest;
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
        @RequestBody UpdateMarkerRequest request
    ) {
        return updateMarkerUseCase.updateMarker(UpdateMarkerCommand.builder()
            .markerId(markerId)
            .locationName(request.locationName())
            .diaryTitle(request.diaryTitle())
            .diaryContent(request.diaryContent())
            .build());
    }
}
