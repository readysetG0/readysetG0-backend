package com.readysetgo.traveltracker.group.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.group.adapter.in.web.request.UpdateGroupRequest;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupCommand;
import com.readysetgo.traveltracker.group.application.port.in.UpdateGroupUseCase;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateGroupController {

    private final UpdateGroupUseCase updateGroupUseCase;

    @PutMapping("/v1/groups/{groupId}")
    public Boolean updateGroup(
        @PathVariable Long groupId,
        @RequestPart UpdateGroupRequest request,
        @RequestPart MultipartFile thumbnailImage
    ) throws IOException {
        UpdateGroupCommand command = new UpdateGroupCommand(
            groupId,
            request.destination(),
            request.startDate(),
            request.endDate(),
            request.title(),
            request.password(),
            thumbnailImage.getOriginalFilename(),
            thumbnailImage.getContentType(),
            thumbnailImage.getInputStream()
        );

        return updateGroupUseCase.updateGroup(command);
    }
}
