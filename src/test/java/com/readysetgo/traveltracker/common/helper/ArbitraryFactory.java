package com.readysetgo.traveltracker.common.helper;

import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category.ID;
import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Category.NAME;

import com.readysetgo.traveltracker.category.adapter.in.web.request.CreateCategoryRequest;
import com.readysetgo.traveltracker.category.adapter.in.web.response.CreateCategoryResponse;
import com.readysetgo.traveltracker.category.adapter.in.web.response.GetCategoryInfoResponse;
import com.readysetgo.traveltracker.category.adapter.out.persistence.CategoryJpaEntity;

/**
 * API 테스트에서 사용되는 요청 및 응답 객체를 생성하는 헬퍼 클래스입니다.
 * <p>
 * 테스트 시 반복적으로 생성되는 객체를 미리 정의하여, 테스트의 간결성과 가독성을 높입니다.
 * </p>
 */
public class ArbitraryFactory {

    /**
     * 카테고리 관련 요청 및 응답 객체 생성을 위한 내부 클래스입니다.
     */
    public static class Category {

        /**
         * 미리 정의된 카테고리 생성 요청 객체입니다.
         * <p>
         * 테스트에서 카테고리 생성 요청 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final CreateCategoryRequest aCreateCategoryRequest =
            CreateCategoryRequest.builder()
                .name(NAME)
                .build();

        /**
         * 미리 정의된 카테고리 생성 응답 객체입니다.
         * <p>
         * 테스트에서 카테고리 생성 결과 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final CreateCategoryResponse aCreateCategoryResponse =
            CreateCategoryResponse.builder()
                .categoryId(ID)
                .build();

        /**
         * 미리 정의된 카테고리 정보 조회 응답 객체입니다.
         * <p>
         * 테스트에서 카테고리 조회 결과 데이터를 반복적으로 사용할 때 활용됩니다.
         * </p>
         */
        public static final GetCategoryInfoResponse aGetCategoryInfoResponse =
            GetCategoryInfoResponse.builder()
                .categoryId(ID)
                .name(NAME)
                .build();

        /**
         * 미리 정의된 `CategoryJpaEntity` 객체를 생성합니다.
         * <p>
         * 테스트에서 JPA 엔터티를 필요로 하는 경우에 활용됩니다.
         * </p>
         *
         * @return 미리 정의된 `CategoryJpaEntity` 객체
         */
        public static CategoryJpaEntity aCategoryJpaEntity() {
            return CategoryJpaEntity.builder()
                .name(NAME)
                .build();
        }
    }
}