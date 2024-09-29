package com.readysetgo.traveltracker.user.adapter.in.response;

import com.readysetgo.traveltracker.user.domain.User;
import com.readysetgo.traveltracker.user.domain.enumeration.SocialType;
import lombok.Data;
@Data
public class UserResponse {

    private String id;

    private String name;

    private String email;

    private SocialType socialType;

    private String socialId;

    private String fcmId;

    public UserResponse(User user) {
        this.id = String.valueOf(user.getId());
        this.name = user.getName();
        this.email = user.getEmail();
        this.socialType = user.getSocialType();
        this.socialId = user.getSocialId();
        this.fcmId = user.getFcmId();
    }
}
