package com.readysetgo.traveltracker.maker.application.port.out;

import com.readysetgo.traveltracker.maker.application.port.in.UpdateMakerCommand;

public interface UpdateMakerPort {

    boolean updateMaker(UpdateMakerCommand command);
}
