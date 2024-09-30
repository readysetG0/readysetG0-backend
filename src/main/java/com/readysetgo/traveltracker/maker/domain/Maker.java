package com.readysetgo.traveltracker.maker.domain;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class Maker {

    private Long id;
    private final String locationName;
    private final String diaryTitle;
    private final String diaryContent;
    private final Double latitude;
    private final Double longitude;

    public static Maker ofNew(String locationName, String diaryTitle, String diaryContent,
        Double latitude, Double longitude) {
        return of(null, locationName, diaryTitle, diaryContent, latitude, longitude);
    }

    public static Maker of(Long id, String locationName, String diaryTitle, String diaryContent,
        Double latitude, Double longitude) {
        return new Maker(id, locationName, diaryTitle, diaryContent, latitude, longitude);
    }
}