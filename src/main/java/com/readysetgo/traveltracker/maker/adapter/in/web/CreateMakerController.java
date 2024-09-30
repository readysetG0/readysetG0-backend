package com.readysetgo.traveltracker.maker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.maker.adapter.in.web.request.CreateMakerRequest;
import com.readysetgo.traveltracker.maker.adapter.in.web.response.CreateMakerResponse;
import com.readysetgo.traveltracker.maker.application.port.in.CreateMakerCommand;
import com.readysetgo.traveltracker.maker.application.port.in.CreateMakerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateMakerController {

    private final CreateMakerUseCase createMakerUseCase;

    @PostMapping("/v1/makers")
    public CreateMakerResponse createMaker(@RequestBody CreateMakerRequest request) {
        CreateMakerCommand command = new CreateMakerCommand(
            request.diaryContent(),
            request.diaryTitle(),
            request.locationName(),
            request.latitude(),
            request.longitude()
        );

        return createMakerUseCase.createMaker(command);
    }
}
