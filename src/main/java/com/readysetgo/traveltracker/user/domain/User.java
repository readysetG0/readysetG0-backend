package com.readysetgo.traveltracker.user.domain;

import com.readysetgo.traveltracker.user.adapter.out.persistence.entity.UserEntity;
import com.readysetgo.traveltracker.user.domain.enumeration.SocialType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String email;

    private SocialType socialType;

    private String socialId;

    private String fcmId;

    public User(Long id, String name, String email, SocialType socialType, String socialId, String fcmId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.socialType = socialType;
        this.socialId = socialId;
        this.fcmId = fcmId;
    }
}
