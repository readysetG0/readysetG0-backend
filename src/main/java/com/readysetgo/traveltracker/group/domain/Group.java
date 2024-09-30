package com.readysetgo.traveltracker.group.domain;

import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = PRIVATE)
public class Group {

    private Long id;

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public static Group ofNew(LocalDateTime startDate, LocalDateTime endDate) {
        return of(null, startDate, endDate);
    }

    public static Group of(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return new Group(id, startDate, endDate);
    }
}
