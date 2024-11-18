package com.readysetgo.traveltracker.category.application.port.out;

import com.readysetgo.traveltracker.category.domain.Category;

/**
 * 카테고리 조회 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface LoadCategoryPort {

    /**
     * 카테고리 데이터를 조회합니다.
     *
     * @param categoryId 조회할 카테고리 ID
     * @return 카테고리 도메인 객체
     */
    Category loadCategory(Long categoryId);
}