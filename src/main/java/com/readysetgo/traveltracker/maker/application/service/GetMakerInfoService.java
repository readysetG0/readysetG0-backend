package com.readysetgo.traveltracker.maker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.maker.adapter.in.web.response.GetMakerInfoResponse;
import com.readysetgo.traveltracker.maker.application.port.in.GetMakerInfoQuery;
import com.readysetgo.traveltracker.maker.application.port.out.LoadMakerPort;
import com.readysetgo.traveltracker.maker.domain.Maker;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMakerInfoService implements GetMakerInfoQuery {

    private final LoadMakerPort loadMakerPort;

    @Override
    public GetMakerInfoResponse getMakerInfo(Long makerId) {
        Maker maker = loadMakerPort.loadMaker(makerId);

        return new GetMakerInfoResponse(
            maker.getId(),
            maker.getLocationName(),
            maker.getDiaryTitle(),
            maker.getDiaryContent(),
            maker.getLatitude(),
            maker.getLongitude()
        );
    }
}
