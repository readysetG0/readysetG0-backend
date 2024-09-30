package com.readysetgo.traveltracker.maker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.maker.application.port.in.UpdateMakerCommand;
import com.readysetgo.traveltracker.maker.application.port.in.UpdateMakerUseCase;
import com.readysetgo.traveltracker.maker.application.port.out.UpdateMakerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpdateMakerService implements UpdateMakerUseCase {

    private final UpdateMakerPort updateMakerPort;

    @Override
    public boolean updateMaker(UpdateMakerCommand command) {
        return updateMakerPort.updateMaker(command);
    }
}
