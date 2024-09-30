package com.readysetgo.traveltracker.maker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.maker.application.port.in.DeleteMakerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class DeleteMakerController {

    private final DeleteMakerUseCase deleteMakerUseCase;

    @DeleteMapping("/v1/makers/{makerId}")
    public Boolean deleteMaker(@PathVariable Long makerId) {
        return deleteMakerUseCase.deleteMaker(makerId);
    }
}
