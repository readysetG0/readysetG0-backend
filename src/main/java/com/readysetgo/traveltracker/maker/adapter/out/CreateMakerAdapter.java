package com.readysetgo.traveltracker.maker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerJpaEntity;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerRepository;
import com.readysetgo.traveltracker.maker.application.port.in.CreateMakerCommand;
import com.readysetgo.traveltracker.maker.application.port.out.CreateMakerPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class CreateMakerAdapter implements CreateMakerPort {

    private final MakerRepository makerRepository;

    @Override
    public Long createMaker(CreateMakerCommand command) {
        MakerJpaEntity maker = createMakerEntity(command);
        makerRepository.save(maker);

        return maker.getId();
    }

    private MakerJpaEntity createMakerEntity(CreateMakerCommand command) {
        return MakerJpaEntity.builder()
            .locationName(command.locationName())
            .diaryTitle(command.diaryTitle())
            .diaryContent(command.diaryContent())
            .latitude(command.latitude())
            .longitude(command.longitude())
            .build();
    }
}
