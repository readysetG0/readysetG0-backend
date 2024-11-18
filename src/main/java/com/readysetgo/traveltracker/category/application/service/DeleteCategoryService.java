package com.readysetgo.traveltracker.category.application.service;

import com.readysetgo.traveltracker.category.application.port.in.DeleteCategoryUseCase;
import com.readysetgo.traveltracker.category.application.port.out.DeleteCategoryPort;
import com.readysetgo.traveltracker.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 카테고리 삭제 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@UseCase
@Transactional
@RequiredArgsConstructor
public class DeleteCategoryService implements DeleteCategoryUseCase {

    private final DeleteCategoryPort deleteCategoryPort;

    @Override
    public boolean deleteCategory(Long categoryId) {
        return deleteCategoryPort.deleteCategory(categoryId);
    }
}