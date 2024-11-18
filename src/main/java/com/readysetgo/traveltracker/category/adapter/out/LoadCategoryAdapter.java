package com.readysetgo.traveltracker.category.adapter.out;

import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryJpaEntity;
import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryRepository;
import com.readysetgo.traveltracker.category.application.port.out.LoadCategoryPort;
import com.readysetgo.traveltracker.category.domain.Category;
import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

/**
 * 카테고리 데이터를 조회하기 위한 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class LoadCategoryAdapter implements LoadCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Category loadCategory(Long categoryId) {
        CategoryJpaEntity category = categoryRepository.findById(categoryId)
            .orElseThrow(RuntimeException::new); // TODO: 적절한 예외 처리 추가 현재 500 응답

        return Category.builder()
            .id(categoryId)
            .name(category.getName())
            .build();
    }
}