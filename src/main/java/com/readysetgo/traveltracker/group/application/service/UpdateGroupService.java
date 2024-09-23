package com.readysetgo.traveltracker.group.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupUseCase;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpdateGroupService implements UpdateGroupUseCase {

    private final UpdateGroupPort updateGroupPort;

    @Override
    public boolean updateGroup(UpdateGroupCommand command) {
        return updateGroupPort.updateGroup(command);
    }
}
