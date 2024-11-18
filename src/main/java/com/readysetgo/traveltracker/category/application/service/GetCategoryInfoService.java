package com.readysetgo.traveltracker.category.application.service;

import com.readysetgo.traveltracker.category.adapter.in.web.response.GetCategoryInfoResponse;
import com.readysetgo.traveltracker.category.application.port.in.GetCategoryInfoQuery;
import com.readysetgo.traveltracker.category.application.port.out.LoadCategoryPort;
import com.readysetgo.traveltracker.category.domain.Category;
import com.readysetgo.traveltracker.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 카테고리 조회 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetCategoryInfoService implements GetCategoryInfoQuery {

    private final LoadCategoryPort loadCategoryPort;

    @Override
    public GetCategoryInfoResponse getCategoryInfo(Long categoryId) {
        Category category = loadCategoryPort.loadCategory(categoryId);

        return GetCategoryInfoResponse.builder()
            .categoryId(category.getId())
            .name(category.getName())
            .build();
    }
}