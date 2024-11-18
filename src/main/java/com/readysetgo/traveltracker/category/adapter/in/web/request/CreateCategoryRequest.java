package com.readysetgo.traveltracker.category.adapter.in.web.request;

import lombok.Builder;

/**
 * 카테고리 생성 요청 데이터를 표현하는 DTO 클래스입니다.
 */
@Builder
public record CreateCategoryRequest(
    String name // 카테고리 이름
) {

}