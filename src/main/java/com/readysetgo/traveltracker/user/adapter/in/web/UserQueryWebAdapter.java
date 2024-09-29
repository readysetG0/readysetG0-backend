package com.readysetgo.traveltracker.user.adapter.in.web;

import com.readysetgo.traveltracker.common.util.ConvertUtil;
import com.readysetgo.traveltracker.user.adapter.in.response.UserResponse;
import com.readysetgo.traveltracker.user.application.port.in.UserQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserQueryWebAdapter {

    private final UserQueryUseCase userQueryUseCase;

    @GetMapping(path="/{id}")
    public UserResponse find(@PathVariable String id) {
        return new UserResponse(userQueryUseCase.find(ConvertUtil.convertToLong(id)));
    }
}
