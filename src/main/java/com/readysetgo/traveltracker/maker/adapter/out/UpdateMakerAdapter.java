package com.readysetgo.traveltracker.maker.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerJpaEntity;
import com.readysetgo.traveltracker.maker.adapter.out.persistence.MakerRepository;
import com.readysetgo.traveltracker.maker.application.port.in.UpdateMakerCommand;
import com.readysetgo.traveltracker.maker.application.port.out.UpdateMakerPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateMakerAdapter implements UpdateMakerPort {

    private final MakerRepository makerRepository;

    @Override
    public boolean updateMaker(UpdateMakerCommand command) {
        MakerJpaEntity maker = makerRepository.findById(command.markerId())
            .orElseThrow(RuntimeException::new);

        maker.updateInfo(
            command.locationName(),
            command.diaryTitle(),
            command.diaryContent()
        );

        return true;
    }
}
