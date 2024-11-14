package com.readysetgo.traveltracker.group.application.port.out;

import com.readysetgo.traveltracker.group.domain.Group;

public interface LoadGroupPort {

    Group loadGroup(Long groupId);
}
