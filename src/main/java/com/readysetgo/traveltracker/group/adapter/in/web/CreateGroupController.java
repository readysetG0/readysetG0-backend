package com.readysetgo.traveltracker.group.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.group.adapter.in.web.request.CreateGroupRequest;
import com.readysetgo.traveltracker.group.adapter.in.web.response.CreateGroupResponse;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.CreateGroupUseCase;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateGroupController {

    private final CreateGroupUseCase createGroupUseCase;

    @PostMapping("/v1/groups")
    public CreateGroupResponse createGroup(
        @RequestPart CreateGroupRequest request,
        @RequestPart MultipartFile thumbnailImage
    ) throws IOException {
        CreateGroupCommand command = new CreateGroupCommand(
            request.destination(),
            request.startDate(),
            request.endDate(),
            request.title(),
            request.password(),
            thumbnailImage.getOriginalFilename(),
            thumbnailImage.getContentType(),
            thumbnailImage.getInputStream()
        );

        return createGroupUseCase.createGroup(command);
    }
}
