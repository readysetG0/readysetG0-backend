package com.readysetgo.traveltracker.category.adapter.in.web.response;

import lombok.Builder;

/**
 * 카테고리 조회 응답 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record GetCategoryInfoResponse(
    Long categoryId, // 카테고리 ID
    String name      // 카테고리 이름
) {

}