package com.readysetgo.traveltracker.group.application.port.in;

import com.readysetgo.traveltracker.group.adapter.in.web.response.CreateGroupResponse;

public interface CreateGroupUseCase {

    CreateGroupResponse createGroup(CreateGroupCommand command);
}
