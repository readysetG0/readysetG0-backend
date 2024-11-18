package com.readysetgo.traveltracker.category.adapter.in.web;

import com.readysetgo.traveltracker.category.application.port.in.DeleteCategoryUseCase;
import com.readysetgo.traveltracker.common.annotation.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 카테고리 삭제 요청을 처리하는 컨트롤러 클래스입니다.
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
public class DeleteCategoryController {

    private final DeleteCategoryUseCase deleteCategoryUseCase;

    /**
     * 카테고리를 삭제합니다.
     *
     * @param categoryId 삭제할 카테고리 ID
     * @return 삭제 성공 여부
     */
    @DeleteMapping("/v1/categories/{categoryId}")
    public Boolean deleteCategory(@PathVariable Long categoryId) {
        return deleteCategoryUseCase.deleteCategory(categoryId);
    }
}