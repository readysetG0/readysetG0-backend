package com.readysetgo.traveltracker.category.adapter.in.web;

import com.readysetgo.traveltracker.category.adapter.in.web.response.GetCategoryInfoResponse;
import com.readysetgo.traveltracker.category.application.port.in.GetCategoryInfoQuery;
import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 카테고리 조회 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetCategoryInfoController {

    private final GetCategoryInfoQuery getCategoryInfoQuery;

    /**
     * 카테고리를 조회합니다.
     *
     * @param categoryId 조회할 카테고리 ID
     * @return 카테고리 정보
     */
    @GetMapping("/v1/categories/{categoryId}")
    public GetCategoryInfoResponse getCategoryInfo(@PathVariable Long categoryId) {
        return getCategoryInfoQuery.getCategoryInfo(categoryId);
    }
}