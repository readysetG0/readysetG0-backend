package com.readysetgo.traveltracker.group.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.group.adapter.in.web.request.CreateGroupRequest;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateGroupController {

    private final UpdateGroupUseCase updateGroupUseCase;

    @PutMapping("/v1/groups/{groupId}")
    public Boolean updateGroup(
            @PathVariable Long groupId,
            @RequestBody CreateGroupRequest request
    ) {
        UpdateGroupCommand command = new UpdateGroupCommand(
                groupId,
                request.destination(),
                request.startDate(),
                request.endDate(),
                request.title(),
                request.password(),
                request.thumbnailUrl()
        );

        return updateGroupUseCase.updateGroup(command);
    }
}
