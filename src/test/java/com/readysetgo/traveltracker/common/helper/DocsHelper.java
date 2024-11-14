package com.readysetgo.traveltracker.common.helper;

import static com.readysetgo.traveltracker.common.helper.util.ArbitraryField.Marker;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.JsonFieldType.BOOLEAN;
import static org.springframework.restdocs.payload.JsonFieldType.NULL;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.web.servlet.ResultHandler;

/**
 * API 문서화를 위한 헬퍼 클래스입니다.
 * <p>
 * Marker와 Category 관련 API의 요청 및 응답 필드를 문서화하여 Spring REST Docs를 통해 API 문서를 생성할 수 있도록 지원합니다.
 * </p>
 */
public class DocsHelper {

    /**
     * 마커 관련 API 문서화를 위한 내부 클래스입니다.
     */
    public static class MarkerDocs {

        /**
         * 마커 생성 API 문서화를 위한 메서드입니다.
         * <p>
         * 마커 생성 요청과 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 마커 생성 API의 요청/응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler createMarkerDocumentation() {
            return MockMvcRestDocumentation.document(Marker.DOC_SECTION_CREATE_MARKER,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("diaryTitle").type(STRING).description("마커 제목"),
                    fieldWithPath("diaryContent").type(STRING).description("마커 내용"),
                    fieldWithPath("locationName").type(STRING).description("위치 이름"),
                    fieldWithPath("latitude").type(NUMBER).description("위도"),
                    fieldWithPath("longitude").type(NUMBER).description("경도")
                ),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data.markerId").type(NUMBER).description("생성된 마커 ID"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 마커 조회 API 문서화를 위한 메서드입니다.
         * <p>
         * 마커 조회 요청에 대한 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 마커 조회 API의 응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler getMarkerDocumentation() {
            return MockMvcRestDocumentation.document(Marker.DOC_SECTION_GET_MARKER,
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data.markerId").type(NUMBER).description("마커 ID"),
                    fieldWithPath("data.diaryTitle").type(STRING).description("마커 제목"),
                    fieldWithPath("data.diaryContent").type(STRING).description("마커 내용"),
                    fieldWithPath("data.locationName").type(STRING).description("위치 이름"),
                    fieldWithPath("data.latitude").type(NUMBER).description("위도"),
                    fieldWithPath("data.longitude").type(NUMBER).description("경도"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 마커 수정 API 문서화를 위한 메서드입니다.
         * <p>
         * 마커 수정 요청과 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 마커 수정 API의 요청/응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler updateMarkerDocumentation() {
            return MockMvcRestDocumentation.document(Marker.DOC_SECTION_UPDATE_MARKER,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("diaryTitle").type(STRING).description("수정할 마커 제목"),
                    fieldWithPath("diaryContent").type(STRING).description("수정할 마커 내용"),
                    fieldWithPath("locationName").type(STRING).description("수정할 위치 이름")
                ),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data").type(BOOLEAN).description("수정 성공 여부"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }

        /**
         * 마커 삭제 API 문서화를 위한 메서드입니다.
         * <p>
         * 마커 삭제 요청에 대한 응답 필드를 정의하여 문서화에 활용합니다.
         * </p>
         *
         * @return 마커 삭제 API의 응답 문서화 설정이 적용된 {@link ResultHandler}
         */
        public static ResultHandler deleteMarkerDocumentation() {
            return MockMvcRestDocumentation.document(Marker.DOC_SECTION_DELETE_MARKER,
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("status").type(STRING).description("API 성공 여부"),
                    fieldWithPath("data").type(BOOLEAN).description("삭제 성공 여부"),
                    fieldWithPath("error").type(NULL).description("에러 정보")
                )
            );
        }
    }

}