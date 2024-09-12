package com.readysetgo.traveltracker.group.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.group.adapter.in.web.request.CreateGroupRequest;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateGroupController {

    private final CreateGroupUseCase createGroupUseCase;

    @PostMapping("/v1/groups")
    public void createGroup(@RequestBody CreateGroupRequest request) {
        CreateGroupCommand command = new CreateGroupCommand(
            request.destination(),
            request.startDate(),
            request.endDate(),
            request.title(),
            request.password(),
            request.thumbnailUrl()
        );

        createGroupUseCase.createGroup(command);
    }
}
