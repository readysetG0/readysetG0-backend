package com.readysetgo.traveltracker.group.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupJpaEntity;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupRepository;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateGroupAdapter implements UpdateGroupPort {

    private final GroupRepository groupRepository;

    @Override
    public boolean updateGroup(UpdateGroupCommand command) {
        GroupJpaEntity group = groupRepository.findById(command.groupId())
                .orElseThrow(RuntimeException::new);

        group.updateInfo(
                command.destination(),
                command.startDate(),
                command.endDate(),
                command.title(),
                command.password(),
                command.thumbnailUrl()
        );

        return true;
    }
}
