package com.readysetgo.traveltracker.group.adapter.out.oci;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.application.port.out.UploadImagePort;
import com.readysetgo.traveltracker.group.domain.ThumbnailImage;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ObjectStorageAdapter implements UploadImagePort {

    @Override
    public String uploadImage(ThumbnailImage image) {
        //TODO: Object Storage 버킷 생성 후 구현 예정
        return "";
    }
}
