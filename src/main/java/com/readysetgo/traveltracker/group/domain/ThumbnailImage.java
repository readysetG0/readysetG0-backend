package com.readysetgo.traveltracker.group.domain;

import java.io.InputStream;

public record ThumbnailImage(
    String fileName,
    String contentType,
    InputStream inputStream
) {

}
