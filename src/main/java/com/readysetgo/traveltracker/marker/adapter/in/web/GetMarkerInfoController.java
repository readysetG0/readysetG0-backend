package com.readysetgo.traveltracker.marker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.marker.adapter.in.web.response.GetMarkerInfoResponse;
import com.readysetgo.traveltracker.marker.application.port.in.GetMarkerInfoQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetMarkerInfoController {

    private final GetMarkerInfoQuery getMarkerInfoQuery;

    @GetMapping("/v1/markers/{markerId}")
    public GetMarkerInfoResponse getMarkerInfo(@PathVariable Long markerId) {
        return getMarkerInfoQuery.getMarkerInfo(markerId);
    }
}
