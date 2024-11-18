package com.readysetgo.traveltracker.common.helper.util;

/**
 * API 테스트에서 사용되는 임의의 필드 값을 정의한 클래스입니다.
 * <p>
 * 각종 도메인 관련 요청 및 응답 필드 값, URL, 문서화 섹션명을 포함하고 있어 테스트 및 문서화 설정 시 활용됩니다.
 * </p>
 */
public class ArbitraryField {

    /**
     * 비용(Expense) 관련 임의의 필드 값과 URL을 정의한 내부 클래스입니다.
     */
    public static class Expense {

        /**
         * 임의의 비용 ID
         */
        public static final Long ID = 56L;

        /**
         * 비용 API의 기본 URL
         */
        public static final String EXPENSE_BASE_URL = "/v1/expenses";

        /**
         * 비용 ID를 포함한 상세 조회 URL
         */
        public static final String EXPENSE_ID_URL = EXPENSE_BASE_URL + "/{id}";

        /**
         * 비용 생성 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_CREATE_EXPENSE = "create-expense";

        /**
         * 비용 조회 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_GET_EXPENSE = "get-expense";

        /**
         * 비용 수정 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_UPDATE_EXPENSE = "update-expense";

        /**
         * 비용 삭제 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_DELETE_EXPENSE = "delete-expense";

        /**
         * 임의의 비용 금액
         */
        public static final Double PRICE = 30000.0;

        /**
         * 임의의 결제 세부 정보
         */
        public static final String BILLING_DETAILS = "쌀국수";

        /**
         * 임의의 비용 ID (특정 테스트용)
         */
        public static final Long EXPENSE_ID = 1L;
    }
}