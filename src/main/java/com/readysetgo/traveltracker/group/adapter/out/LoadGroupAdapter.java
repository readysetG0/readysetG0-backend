package com.readysetgo.traveltracker.group.adapter.out;

import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupJpaEntity;
import com.readysetgo.traveltracker.group.adapter.out.persistence.GroupRepository;
import com.readysetgo.traveltracker.group.application.port.out.LoadGroupPort;
import com.readysetgo.traveltracker.group.domain.Group;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class LoadGroupAdapter implements LoadGroupPort {

    private final GroupRepository groupRepository;

    @Override
    public Group loadGroup(Long groupId) {
        GroupJpaEntity group = groupRepository.findById(groupId)
            .orElseThrow(RuntimeException::new);

        return Group.of(
            group.getId(),
            group.getStartDate(),
            group.getEndDate()
        );
    }
}
