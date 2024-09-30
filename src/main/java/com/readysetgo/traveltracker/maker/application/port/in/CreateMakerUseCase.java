package com.readysetgo.traveltracker.maker.application.port.in;

import com.readysetgo.traveltracker.maker.adapter.in.web.response.CreateMakerResponse;

public interface CreateMakerUseCase {

    CreateMakerResponse createMaker(CreateMakerCommand command);
}
