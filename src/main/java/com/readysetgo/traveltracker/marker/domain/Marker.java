package com.readysetgo.traveltracker.marker.domain;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class Marker {

    private Long id;
    private final String locationName;
    private final String diaryTitle;
    private final String diaryContent;
    private final Double latitude;
    private final Double longitude;

    public static Marker ofNew(String locationName, String diaryTitle, String diaryContent,
        Double latitude, Double longitude) {
        return of(null, locationName, diaryTitle, diaryContent, latitude, longitude);
    }

    public static Marker of(Long id, String locationName, String diaryTitle, String diaryContent,
        Double latitude, Double longitude) {
        return new Marker(id, locationName, diaryTitle, diaryContent, latitude, longitude);
    }
}