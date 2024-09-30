package com.readysetgo.traveltracker.maker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerJpaEntity;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerRepository;
import com.readysetgo.traveltracker.maker.application.port.out.LoadMakerPort;
import com.readysetgo.traveltracker.maker.domain.Maker;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadMakerAdapter implements LoadMakerPort {

    private final MakerRepository makerRepository;

    @Override
    public Maker loadMaker(Long makerId) {
        MakerJpaEntity maker = makerRepository.findById(makerId)
            .orElseThrow(RuntimeException::new);

        return Maker.of(
            maker.getId(),
            maker.getLocationName(),
            maker.getDiaryTitle(),
            maker.getDiaryContent(),
            maker.getLatitude(),
            maker.getLongitude()
        );
    }
}
