package com.readysetgo.traveltracker.group.adapter.out.group;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`GROUP`")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String title;

    private String password;

    private String thumbnailUrl;

    private boolean isCompleted;

    @Builder
    private GroupJpaEntity(
        String destination,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String title,
        String password,
        String thumbnailUrl
    ) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.password = password;
        this.thumbnailUrl = thumbnailUrl;
        this.isCompleted = false;
    }

    public void updateInfo(
        String destination,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String title,
        String password,
        String thumbnailUrl
    ) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.password = password;
        this.thumbnailUrl = thumbnailUrl;
    }
}
