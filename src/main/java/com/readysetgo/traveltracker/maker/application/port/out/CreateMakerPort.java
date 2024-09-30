package com.readysetgo.traveltracker.maker.application.port.out;

import com.readysetgo.traveltracker.maker.application.port.in.CreateMakerCommand;

public interface CreateMakerPort {

    Long createMaker(CreateMakerCommand command);
}
