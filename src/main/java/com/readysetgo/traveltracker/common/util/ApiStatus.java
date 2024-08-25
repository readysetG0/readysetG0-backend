package com.readysetgo.traveltracker.common.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApiStatus {

    SUCCESS("성공"),
    ERROR("실패");

    private final String description;
}
