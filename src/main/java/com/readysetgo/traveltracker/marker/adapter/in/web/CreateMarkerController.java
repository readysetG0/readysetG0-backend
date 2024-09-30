package com.readysetgo.traveltracker.marker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.marker.adapter.in.web.request.CreateMarkerRequest;
import com.readysetgo.traveltracker.marker.adapter.in.web.response.CreateMarkerResponse;
import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerCommand;
import com.readysetgo.traveltracker.marker.application.port.in.CreateMarkerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateMarkerController {

    private final CreateMarkerUseCase createMarkerUseCase;

    @PostMapping("/v1/markers")
    public CreateMarkerResponse createMarker(@RequestBody CreateMarkerRequest request) {
        CreateMarkerCommand command = new CreateMarkerCommand(
            request.diaryContent(),
            request.diaryTitle(),
            request.locationName(),
            request.latitude(),
            request.longitude()
        );

        return createMarkerUseCase.createMarker(command);
    }
}
