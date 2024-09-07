package com.readysetgo.traveltracker.user.adapter.out.mapper;

import com.readysetgo.traveltracker.user.adapter.out.persistence.entity.UserEntity;
import com.readysetgo.traveltracker.user.domain.User;

public class UserMapper {

    public static User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getSocialType(), userEntity.getSocialId(), userEntity.getFcmId());
    }
}
