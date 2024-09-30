package com.readysetgo.traveltracker.maker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.maker.application.port.in.DeleteMakerUseCase;
import com.readysetgo.traveltracker.maker.application.port.out.DeleteMakerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class DeleteMakerService implements DeleteMakerUseCase {

    private final DeleteMakerPort deleteMakerPort;

    @Override
    public boolean deleteMaker(Long makerId) {
        return deleteMakerPort.deleteMaker(makerId);
    }
}
