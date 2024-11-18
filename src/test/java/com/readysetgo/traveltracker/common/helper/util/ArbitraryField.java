package com.readysetgo.traveltracker.common.helper.util;

/**
 * API 테스트에서 사용되는 임의의 필드 값을 정의한 클래스입니다.
 * <p>
 * 각종 도메인 관련 요청 및 응답 필드 값, URL, 문서화 섹션명을 포함하고 있어 테스트 및 문서화 설정 시 활용됩니다.
 * </p>
 */
public class ArbitraryField {

    /**
     * 카테고리 관련 임의의 필드 값과 URL을 정의한 내부 클래스입니다.
     */
    public static class Category {

        /**
         * 카테고리 생성 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_CREATE = "create-category";
        /**
         * 카테고리 조회 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_GET = "get-category";
        /**
         * 카테고리 삭제 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_DELETE = "delete-category";
        /**
         * 카테고리 API의 기본 URL
         */
        public static final String CATEGORY_BASE_URL = "/v1/categories";
        /**
         * 카테고리 ID를 포함한 상세 조회 URL
         */
        public static final String CATEGORY_ID_URL = CATEGORY_BASE_URL + "/{id}";
        /**
         * 임의의 카테고리 ID
         */
        public static final Long ID = 34L;
        /**
         * 임의의 카테고리 이름
         */
        public static final String NAME = "Arbitrary Category";
    }
}