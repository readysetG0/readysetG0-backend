package com.readysetgo.traveltracker.group.application.port.out;

import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;

public interface UpdateGroupPort {

    boolean updateGroup(UpdateGroupCommand command);
}
