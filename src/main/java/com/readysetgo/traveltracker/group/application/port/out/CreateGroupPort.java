package com.readysetgo.traveltracker.group.application.port.out;

import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;

public interface CreateGroupPort {

    Long createGroup(CreateGroupCommand command);
}
