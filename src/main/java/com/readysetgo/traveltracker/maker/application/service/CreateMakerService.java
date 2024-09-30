package com.readysetgo.traveltracker.maker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.maker.adapter.in.web.response.CreateMakerResponse;
import com.readysetgo.traveltracker.maker.application.port.in.CreateMakerCommand;
import com.readysetgo.traveltracker.maker.application.port.in.CreateMakerUseCase;
import com.readysetgo.traveltracker.maker.application.port.out.CreateMakerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateMakerService implements CreateMakerUseCase {

    private final CreateMakerPort createMakerPort;

    @Override
    public CreateMakerResponse createMaker(CreateMakerCommand command) {
        return new CreateMakerResponse(createMakerPort.createMaker(command));
    }
}
