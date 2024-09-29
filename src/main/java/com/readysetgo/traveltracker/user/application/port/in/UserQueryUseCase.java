package com.readysetgo.traveltracker.user.application.port.in;

import com.readysetgo.traveltracker.user.adapter.in.response.UserResponse;
import com.readysetgo.traveltracker.user.domain.User;

public interface UserQueryUseCase {

    User find(Long id);
}
