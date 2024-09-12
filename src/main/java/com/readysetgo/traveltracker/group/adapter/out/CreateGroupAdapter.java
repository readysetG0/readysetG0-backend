package com.readysetgo.traveltracker.group.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupJpaEntity;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupRepository;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class CreateGroupAdapter implements CreateGroupPort {

    private final GroupRepository groupRepository;

    @Override
    public void createGroup(CreateGroupCommand command) {
        GroupJpaEntity group = createGroupEntity(command);
        groupRepository.save(group);
    }

    private GroupJpaEntity createGroupEntity(CreateGroupCommand command) {
        return GroupJpaEntity.builder()
            .destination(command.destination())
            .startDate(command.startDate())
            .endDate(command.endDate())
            .title(command.title())
            .password(command.password())
            .thumbnailUrl(command.thumbnailUrl())
            .build();
    }
}
