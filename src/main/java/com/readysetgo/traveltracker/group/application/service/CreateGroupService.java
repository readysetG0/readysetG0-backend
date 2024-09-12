package com.readysetgo.traveltracker.group.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupUseCase;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateGroupService implements CreateGroupUseCase {

    private final CreateGroupPort createGroupPort;

    @Override
    public void createGroup(CreateGroupCommand command) {
        createGroupPort.createGroup(command);
    }
}
