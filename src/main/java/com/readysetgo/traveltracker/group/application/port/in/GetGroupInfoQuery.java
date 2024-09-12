package com.readysetgo.traveltracker.group.application.port.in;

import com.readysetgo.traveltracker.group.adapter.in.web.response.GetGroupInfoResponse;

public interface GetGroupInfoQuery {

    GetGroupInfoResponse getGroupInfo(Long groupId);
}
