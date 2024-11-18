package com.readysetgo.traveltracker.category.adapter.in.web.response;

import lombok.Builder;

/**
 * 카테고리 생성 응답 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record CreateCategoryResponse(
    Long categoryId // 생성된 카테고리 ID
) {

}