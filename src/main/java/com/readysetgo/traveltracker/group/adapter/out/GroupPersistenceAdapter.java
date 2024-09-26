package com.readysetgo.traveltracker.group.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupJpaEntity;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupRepository;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupPort;
import com.readysetgo.traveltracker.group.application.port.out.DeleteGroupPort;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class GroupPersistenceAdapter implements CreateGroupPort, UpdateGroupPort, DeleteGroupPort {

    private final GroupRepository groupRepository;

    @Override
    public Long createGroup(CreateGroupCommand command) {
        GroupJpaEntity group = createGroupEntity(command);
        groupRepository.save(group);

        return group.getId();
    }

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

    @Override
    public Boolean deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);

        return true;
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
