package com.readysetgo.traveltracker.group.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.group.adapter.in.web.response.GetGroupInfoResponse;
import com.readysetgo.traveltracker.group.application.port.in.GetGroupInfoQuery;
import com.readysetgo.traveltracker.group.application.port.out.LoadGroupPort;
import com.readysetgo.traveltracker.group.domain.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetGroupInfoService implements GetGroupInfoQuery {

    private final LoadGroupPort loadGroupPort;

    @Override
    public GetGroupInfoResponse getGroupInfo(Long groupId) {
        Group group = loadGroupPort.loadGroup(groupId);

        return new GetGroupInfoResponse(
            group.getStartDate(),
            group.getEndDate()
        );
    }
}
