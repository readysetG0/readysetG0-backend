package com.readysetgo.traveltracker.marker.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.marker.application.port.in.DeleteMarkerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class DeleteMarkerController {

    private final DeleteMarkerUseCase deleteMarkerUseCase;

    @DeleteMapping("/v1/markers/{markerId}")
    public Boolean deleteMarker(@PathVariable Long markerId) {
        return deleteMarkerUseCase.deleteMarker(markerId);
    }
}
