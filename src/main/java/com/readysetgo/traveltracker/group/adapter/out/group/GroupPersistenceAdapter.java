package com.readysetgo.traveltracker.group.adapter.out.group;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupOutCommand;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupPort;
import com.readysetgo.traveltracker.group.application.port.out.DeleteGroupPort;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupOutCommand;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class GroupPersistenceAdapter implements CreateGroupPort, UpdateGroupPort, DeleteGroupPort {

    private final GroupRepository groupRepository;

    @Override
    public Long createGroup(CreateGroupOutCommand command) {
        GroupJpaEntity group = createGroupEntity(command);
        groupRepository.save(group);

        return group.getId();
    }

    @Override
    public boolean updateGroup(UpdateGroupOutCommand command) {
        GroupJpaEntity group = groupRepository.findById(command.groupId())
            .orElseThrow(RuntimeException::new);

        group.updateInfo(
            command.destination(),
            command.startDate(),
            command.endDate(),
            command.title(),
            command.password(),
            command.thumbnailImageUrl()
        );

        return true;
    }

    @Override
    public Boolean deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);

        return true;
    }

    private GroupJpaEntity createGroupEntity(CreateGroupOutCommand command) {
        return GroupJpaEntity.builder()
            .destination(command.destination())
            .startDate(command.startDate())
            .endDate(command.endDate())
            .title(command.title())
            .password(command.password())
            .thumbnailUrl(command.thumbnailImageUrl())
            .build();
    }
}
