package com.readysetgo.traveltracker.group.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupUseCase;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupOutCommand;
import com.readysetgo.traveltracker.group.application.port.out.UpdateGroupPort;
import com.readysetgo.traveltracker.group.application.port.out.UploadImagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class UpdateGroupService implements UpdateGroupUseCase {

    private final UpdateGroupPort updateGroupPort;
    private final UploadImagePort uploadImagePort;

    @Override
    public boolean updateGroup(UpdateGroupCommand command) {
        String thumbnailImageUrl = uploadImagePort.uploadImage(command.thumbnailImage());

        UpdateGroupOutCommand outCommand = new UpdateGroupOutCommand(
            command.groupId(),
            command.destination(),
            command.startDate(),
            command.endDate(),
            command.title(),
            command.password(),
            thumbnailImageUrl
        );

        return updateGroupPort.updateGroup(outCommand);
    }
}
