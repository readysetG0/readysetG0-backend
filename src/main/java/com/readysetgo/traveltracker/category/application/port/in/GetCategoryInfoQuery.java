package com.readysetgo.traveltracker.category.application.port.in;

import com.readysetgo.traveltracker.category.adapter.in.web.response.GetCategoryInfoResponse;

/**
 * 카테고리 조회 유스케이스 인터페이스입니다.
 */
public interface GetCategoryInfoQuery {

    /**
     * 카테고리 정보를 조회합니다.
     *
     * @param categoryId 조회할 카테고리 ID
     * @return 카테고리 정보 응답 객체
     */
    GetCategoryInfoResponse getCategoryInfo(Long categoryId);
}