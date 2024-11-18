package com.readysetgo.traveltracker.category.application.port.out;

/**
 * 카테고리 삭제 작업을 영속성 계층에 위임하기 위한 포트 인터페이스입니다.
 */
public interface DeleteCategoryPort {

    /**
     * 카테고리를 삭제합니다.
     *
     * @param categoryId 삭제할 카테고리 ID
     * @return 삭제 성공 여부
     */
    Boolean deleteCategory(Long categoryId);
}