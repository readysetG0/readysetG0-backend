package com.readysetgo.traveltracker.group.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.group.adapter.in.web.response.GetGroupInfoResponse;
import com.readysetgo.traveltracker.group.application.port.in.GetGroupInfoQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetGroupInfoController {

    private final GetGroupInfoQuery getGroupInfoQuery;

    @GetMapping("/v1/groups/{groupId}")
    public GetGroupInfoResponse getGroupInfo(@PathVariable Long groupId) {
        return getGroupInfoQuery.getGroupInfo(groupId);
    }
}
