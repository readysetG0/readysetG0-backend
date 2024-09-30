package com.readysetgo.traveltracker.maker.application.port.in;

import com.readysetgo.traveltracker.maker.adapter.in.web.response.GetMakerInfoResponse;

public interface GetMakerInfoQuery {

    GetMakerInfoResponse getMakerInfo(Long makerId);
}
