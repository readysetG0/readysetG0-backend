package com.readysetgo.traveltracker.category.application.port.in;

import com.readysetgo.traveltracker.category.adapter.in.web.response.CreateCategoryResponse;

/**
 * 카테고리 생성 유스케이스 인터페이스입니다.
 */
public interface CreateCategoryUseCase {

    /**
     * 카테고리를 생성합니다.
     *
     * @param command 카테고리 생성 명령 객체
     * @return 생성된 카테고리 정보
     */
    CreateCategoryResponse createCategory(CreateCategoryCommand command);
}