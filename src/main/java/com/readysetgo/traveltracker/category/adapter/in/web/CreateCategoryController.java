package com.readysetgo.traveltracker.category.adapter.in.web;

import com.readysetgo.traveltracker.category.adapter.in.web.request.CreateCategoryRequest;
import com.readysetgo.traveltracker.category.adapter.in.web.response.CreateCategoryResponse;
import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryCommand;
import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryUseCase;
import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 카테고리 생성 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class CreateCategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    /**
     * 카테고리를 생성합니다.
     *
     * @param request 카테고리 생성 요청 데이터
     * @return 생성된 카테고리 정보
     */
    @PostMapping("/v1/categories")
    public CreateCategoryResponse createCategory(@RequestBody CreateCategoryRequest request) {
        return createCategoryUseCase.createCategory(CreateCategoryCommand.builder()
            .name(request.name())
            .build());
    }
}