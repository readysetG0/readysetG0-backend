package com.readysetgo.traveltracker.user.adapter.out.mapper;

import com.readysetgo.traveltracker.user.adapter.out.persistence.entity.UserEntity;
import com.readysetgo.traveltracker.user.domain.User;

public abstract class UserMapper {

    public static User toDomain(UserEntity userEntity) {
        return User.builder()
            .id(userEntity.getId())
            .name(userEntity.getName())
            .email(userEntity.getEmail())
            .socialType(userEntity.getSocialType())
            .socialId(userEntity.getSocialId())
            .fcmId(userEntity.getFcmId())
            .build();
    }
}
