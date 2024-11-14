package com.readysetgo.traveltracker.common.helper.util;

/**
 * API 테스트에서 사용되는 임의의 필드 값을 정의한 클래스입니다.
 * <p>
 * 마커(Marker)와 카테고리(Category) 관련 요청 및 응답 필드 값, URL, 문서화 섹션명을 포함하고 있어 테스트 및 문서화 설정 시 활용됩니다.
 * </p>
 */
public class ArbitraryField {

    /**
     * 마커 관련 임의의 필드 값과 URL을 정의한 내부 클래스입니다.
     */
    public static class Marker {

        /**
         * 마커 생성 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_CREATE_MARKER = "create-marker";
        /**
         * 마커 조회 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_GET_MARKER = "get-marker";
        /**
         * 마커 수정 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_UPDATE_MARKER = "update-marker";
        /**
         * 마커 삭제 API 문서화 섹션 이름
         */
        public static final String DOC_SECTION_DELETE_MARKER = "delete-marker";

        /**
         * 마커 API의 기본 URL
         */
        public static final String MARKER_BASE_URL = "/v1/markers";
        /**
         * 마커 ID를 포함한 상세 조회 URL
         */
        public static final String MARKER_ID_URL = MARKER_BASE_URL + "/{id}";

        /**
         * 임의의 마커 ID
         */
        public static final Long ID = 12L;
        /**
         * 임의의 다이어리 제목
         */
        public static final String DIARY_TITLE = "Sample Diary Title";
        /**
         * 임의의 다이어리 내용
         */
        public static final String DIARY_CONTENT = "Sample Diary Content";
        /**
         * 임의의 위치 이름
         */
        public static final String LOCATION_NAME = "Seoul Tower";
        /**
         * 임의의 위도 값
         */
        public static final Double LATITUDE = 37.55;
        /**
         * 임의의 경도 값
         */
        public static final Double LONGITUDE = 126.98;

        /**
         * 업데이트된 다이어리 제목
         */
        public static final String UPDATED_DIARY_TITLE = "Updated Diary Title";
        /**
         * 업데이트된 다이어리 내용
         */
        public static final String UPDATED_DIARY_CONTENT = "This content has been updated for testing.";
        /**
         * 업데이트된 위치 이름
         */
        public static final String UPDATED_LOCATION_NAME = "Namsan Seoul Tower";
    }
}