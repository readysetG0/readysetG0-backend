package com.readysetgo.traveltracker.marker.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.marker.adapter.in.web.response.GetMarkerInfoResponse;
import com.readysetgo.traveltracker.marker.application.port.in.GetMarkerInfoQuery;
import com.readysetgo.traveltracker.marker.application.port.out.LoadMarkerPort;
import com.readysetgo.traveltracker.marker.domain.Marker;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMarkerInfoService implements GetMarkerInfoQuery {

    private final LoadMarkerPort loadMarkerPort;

    @Override
    public GetMarkerInfoResponse getMarkerInfo(Long markerId) {
        Marker marker = loadMarkerPort.loadMarker(markerId);

        return new GetMarkerInfoResponse(
            marker.getId(),
            marker.getLocationName(),
            marker.getDiaryTitle(),
            marker.getDiaryContent(),
            marker.getLatitude(),
            marker.getLongitude()
        );
    }
}
