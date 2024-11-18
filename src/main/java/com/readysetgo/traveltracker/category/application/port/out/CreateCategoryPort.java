package com.readysetgo.traveltracker.category.application.port.out;

import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryCommand;

/**
 * 카테고리 생성 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface CreateCategoryPort {

    /**
     * 카테고리를 생성합니다.
     *
     * @param command 카테고리 생성 명령 객체
     * @return 생성된 카테고리 ID
     */
    Long createCategory(CreateCategoryCommand command);
}