package com.readysetgo.traveltracker.category.application.service;

import com.readysetgo.traveltracker.category.adapter.in.web.response.CreateCategoryResponse;
import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryCommand;
import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryUseCase;
import com.readysetgo.traveltracker.category.application.port.out.CreateCategoryPort;
import com.readysetgo.traveltracker.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 카테고리 생성 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class CreateCategoryService implements CreateCategoryUseCase {

    private final CreateCategoryPort createCategoryPort;

    @Override
    public CreateCategoryResponse createCategory(CreateCategoryCommand command) {
        return new CreateCategoryResponse(createCategoryPort.createCategory(command));
    }
}