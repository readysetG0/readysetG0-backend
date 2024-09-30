package com.readysetgo.traveltracker.maker.application.port.out;

import com.readysetgo.traveltracker.maker.domain.Maker;

public interface LoadMakerPort {

    Maker loadMaker(Long makerId);
}
