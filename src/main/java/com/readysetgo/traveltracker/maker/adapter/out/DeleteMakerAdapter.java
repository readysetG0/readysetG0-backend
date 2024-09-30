package com.readysetgo.traveltracker.maker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerRepository;
import com.readysetgo.traveltracker.maker.application.port.out.DeleteMakerPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteMakerAdapter implements DeleteMakerPort {

    private final MakerRepository makerRepository;

    @Override
    public Boolean deleteMaker(Long makerId) {
        makerRepository.deleteById(makerId);

        return true;
    }
}
