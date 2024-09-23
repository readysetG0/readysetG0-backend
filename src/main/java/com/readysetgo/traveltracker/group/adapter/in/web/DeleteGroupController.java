package com.readysetgo.traveltracker.group.adapter.in.web;

import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import com.readysetgo.traveltracker.group.application.port.in.DeleteGroupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class DeleteGroupController {

    private final DeleteGroupUseCase deleteGroupUseCase;

    @DeleteMapping("/v1/groups/{groupId}")
    public Boolean deleteGroup(@PathVariable Long groupId) {
        return deleteGroupUseCase.deleteGroup(groupId);
    }
}
