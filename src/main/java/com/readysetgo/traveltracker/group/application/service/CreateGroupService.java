package com.readysetgo.traveltracker.group.application.service;

import com.readysetgo.traveltracker.common.annotation.UseCase;
import com.readysetgo.traveltracker.group.adapter.in.web.response.CreateGroupResponse;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupUseCase;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupOutCommand;
import com.readysetgo.traveltracker.group.application.port.out.CreateGroupPort;
import com.readysetgo.traveltracker.group.application.port.out.UploadImagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateGroupService implements CreateGroupUseCase {

    private final CreateGroupPort createGroupPort;
    private final UploadImagePort uploadImagePort;

    @Override
    public CreateGroupResponse createGroup(CreateGroupCommand command) {
        String thumbnailImageUrl = uploadImagePort.uploadImage(command.thumbnailImage());

        CreateGroupOutCommand outCommand = new CreateGroupOutCommand(
            command.destination(),
            command.startDate(),
            command.endDate(),
            command.title(),
            command.password(),
            thumbnailImageUrl
        );

        return new CreateGroupResponse(createGroupPort.createGroup(outCommand));
    }
}
