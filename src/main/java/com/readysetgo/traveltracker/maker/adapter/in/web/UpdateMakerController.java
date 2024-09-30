package com.readysetgo.traveltracker.maker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.maker.adapter.in.web.request.CreateMakerRequest;
import com.readysetgo.traveltracker.maker.application.port.in.UpdateMakerCommand;
import com.readysetgo.traveltracker.maker.application.port.in.UpdateMakerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateMakerController {

    private final UpdateMakerUseCase updateMakerUseCase;

    @PutMapping("/v1/makers/{makerId}")
    public Boolean updateMaker(
        @PathVariable Long makerId,
        @RequestBody CreateMakerRequest request
    ) {
        UpdateMakerCommand command = new UpdateMakerCommand(
            makerId,
            request.locationName(),
            request.diaryTitle(),
            request.diaryContent()
        );

        return updateMakerUseCase.updateMaker(command);
    }
}
