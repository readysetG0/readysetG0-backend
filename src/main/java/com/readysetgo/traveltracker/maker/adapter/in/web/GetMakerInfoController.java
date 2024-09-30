package com.readysetgo.traveltracker.maker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.maker.adapter.in.web.response.GetMakerInfoResponse;
import com.readysetgo.traveltracker.maker.application.port.in.GetMakerInfoQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetMakerInfoController {

    private final GetMakerInfoQuery getMakerInfoQuery;

    @GetMapping("/v1/makers/{makerId}")
    public GetMakerInfoResponse getMakerInfo(@PathVariable Long makerId) {
        return getMakerInfoQuery.getMakerInfo(makerId);
    }
}
