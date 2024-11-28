package com.readysetgo.traveltracker.category.adapter;

import static com.readysetgo.traveltracker.common.helper.ArbitraryFactory.Category.aCategoryJpaEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.readysetgo.traveltracker.category.adapter.out.LoadCategoryAdapter;
import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryJpaEntity;
import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryRepository;
import com.readysetgo.traveltracker.category.domain.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@link LoadCategoryAdapter}에 대한 통합 테스트 클래스입니다.
 * <p>
 * 이 클래스는 데이터베이스와의 실제 상호작용을 통해 어댑터의 동작을 검증합니다.
 * </p>
 */
@SpringBootTest
class LoadCategoryAdapterTest {

    @Autowired
    private LoadCategoryAdapter loadCategoryAdapter;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * 각 테스트 후 데이터 정리를 수행합니다.
     */
    @AfterEach
    void tearDown() {
        categoryRepository.deleteAllInBatch(); // 데이터 정리
    }

    /**
     * 어댑터를 사용하여 데이터베이스에서 카테고리 정보를 불러오는 테스트입니다.
     */
    @DisplayName("데이터베이스에 저장된 카테고리을 어댑터로 불러올 때 유효한 카테고리 반환")
    @Test
    void categorySavedInDatabase_loadedThroughAdapter_returnsValidCategory() {
        // given
        CategoryJpaEntity categoryEntity = aCategoryJpaEntity();
        categoryRepository.save(categoryEntity);

        // when
        Category category = loadCategoryAdapter.loadCategory(categoryEntity.getId());

        // then
        assertThat(category, is(notNullValue())); // 객체가 null이 아님을 확인
        assertThat(category.getId(), is(equalTo(categoryEntity.getId())));
    }
}