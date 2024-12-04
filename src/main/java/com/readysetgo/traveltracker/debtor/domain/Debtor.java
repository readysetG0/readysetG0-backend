package com.readysetgo.traveltracker.debtor.domain;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = PRIVATE)
@Builder
public class Debtor {

    private Long id;
}