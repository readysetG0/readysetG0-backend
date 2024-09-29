package com.readysetgo.traveltracker.user.application.port.out;

import com.readysetgo.traveltracker.user.domain.User;

public interface UserPort {

    User find(Long id);
}
