package com.readysetgo.traveltracker.category.adapter.out;

import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryJpaEntity;
import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryRepository;
import com.readysetgo.traveltracker.category.application.port.in.CreateCategoryCommand;
import com.readysetgo.traveltracker.category.application.port.out.CreateCategoryPort;
import com.readysetgo.traveltracker.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

/**
 * 카테고리 데이터를 영속성 계층에 저장하는 어댑터 클래스입니다.
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class CreateCategoryAdapter implements CreateCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public Long createCategory(CreateCategoryCommand command) {
        CategoryJpaEntity category = createCategoryEntity(command);
        categoryRepository.save(category);
        return category.getId();
    }

    private CategoryJpaEntity createCategoryEntity(CreateCategoryCommand command) {
        return CategoryJpaEntity.builder()
            .name(command.name())
            .build();
    }
}