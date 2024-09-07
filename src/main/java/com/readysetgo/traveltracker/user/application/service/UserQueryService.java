package com.readysetgo.traveltracker.user.application.service;

import com.readysetgo.traveltracker.user.application.port.in.UserQueryUseCase;
import com.readysetgo.traveltracker.user.application.port.out.UserPort;
import com.readysetgo.traveltracker.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryService implements UserQueryUseCase {

    private final UserPort userPort;

    @Override
    public User find(Long id) {
        return userPort.find(id);
    }
}
