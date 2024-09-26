package com.readysetgo.traveltracker.group.application.port.out;

import com.readysetgo.traveltracker.group.domain.ThumbnailImage;

public interface UploadImagePort {

    String uploadImage(ThumbnailImage image);
}
