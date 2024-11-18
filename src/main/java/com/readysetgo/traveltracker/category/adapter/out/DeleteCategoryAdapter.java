package com.readysetgo.traveltracker.category.adapter.out;

import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryRepository;
import com.readysetgo.traveltracker.category.application.port.out.DeleteCategoryPort;
import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

/**
 * 카테고리를 삭제하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteCategoryAdapter implements DeleteCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Boolean deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);

        return true; //TODO: 필요시 요청에 따른 응답으로 변경
    }
}