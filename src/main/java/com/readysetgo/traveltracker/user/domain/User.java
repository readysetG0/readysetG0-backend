package com.readysetgo.traveltracker.user.domain;

import com.readysetgo.traveltracker.user.adapter.out.persistence.entity.UserEntity;
import com.readysetgo.traveltracker.user.domain.enumeration.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class User {

    private Long id;

    private String name;

    private String email;

    private SocialType socialType;

    private String socialId;

    private String fcmId;
}
