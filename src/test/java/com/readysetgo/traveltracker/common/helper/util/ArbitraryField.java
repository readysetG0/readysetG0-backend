package com.readysetgo.traveltracker.common.helper.util;

/**
 * API 테스트에서 사용되는 임의의 필드 값을 정의한 클래스입니다.
 * <p>
 * 각종 도메인 관련 요청 및 응답 필드 값, URL, 문서화 섹션명을 포함하고 있어 테스트 및 문서화 설정 시 활용됩니다.
 * </p>
 */
public class ArbitraryField {

    /**
     * 채무자(Debtor) 관련 임의의 필드 값과 URL을 정의한 내부 클래스입니다.
     */
    public static class Debtor {

        /**
         * 임의의 채무자 ID
         */
        public static final Long ID = 56L;

        /**
         * 채무자 API의 기본 URL
         */
        public static final String DEBTOR_BASE_URL = "/v1/debtors";

        /**
         * 채무자 ID를 포함한 상세 조회 URL
         */
        public static final String DEBTOR_ID_URL = DEBTOR_BASE_URL + "/{id}";

        /**
         * 채무자 생성 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_CREATE_DEBTOR = "create-debtor";

        /**
         * 채무자 조회 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_GET_DEBTOR = "get-debtor";

        /**
         * 채무자 삭제 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_DELETE_DEBTOR = "delete-debtor";

        /**
         * 임의의 채무자 ID (특정 테스트용)
         */
        public static final Long DEBTOR_ID = 90L;
    }
}