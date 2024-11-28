package com.readysetgo.traveltracker.category.application.port.in;

/**
 * 카테고리 삭제 유스케이스 인터페이스입니다.
 */
public interface DeleteCategoryUseCase {

    /**
     * 카테고리를 삭제합니다.
     *
     * @param categoryId 삭제할 카테고리 ID
     * @return 삭제 성공 여부
     */
    boolean deleteCategory(Long categoryId);
}