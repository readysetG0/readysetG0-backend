package com.readysetgo.traveltracker.group.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.group.application.port.in.DeleteGroupUseCase;
import com.readysetgo.traveltracker.group.application.port.out.DeleteGroupPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class DeleteGroupService implements DeleteGroupUseCase {

    private final DeleteGroupPort deleteGroupPort;

    @Override
    public void deleteGroup(Long groupId) {
        deleteGroupPort.deleteGroup(groupId);
    }
}
