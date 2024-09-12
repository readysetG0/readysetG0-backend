package com.readysetgo.traveltracker.group.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupRepository;
import com.readysetgo.traveltracker.group.application.port.out.DeleteGroupPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteGroupAdapter implements DeleteGroupPort {

    private final GroupRepository groupRepository;

    @Override
    public Boolean deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);

        return true;
    }
}
