package com.readysetgo.traveltracker.marker.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MARKER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarkerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationName;

    private String diaryTitle;

    private String diaryContent;

    private Double latitude;

    private Double longitude;

    @Builder
    public MarkerJpaEntity(String locationName, String diaryTitle, String diaryContent,
        Double latitude,
        Double longitude) {
        this.locationName = locationName;
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void updateInfo(String diaryContent, String diaryTitle, String locationName) {
        this.diaryContent = diaryContent;
        this.diaryTitle = diaryTitle;
        this.locationName = locationName;
    }
}
